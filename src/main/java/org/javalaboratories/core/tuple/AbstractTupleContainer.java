package org.javalaboratories.core.tuple;
/*
 * Copyright 2020 Kevin Henry
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.function.Function;

/**
 * Tuples inherit from this class.
 * <p>
 * The tuple is considered to be a container. It currently uses a simple doubly
 * linked list data structure. A decision was made to use this approach rather
 * than reusing {@link LinkedList} because it is important to reduce the overhead
 * of the structure of the tuple as well as minimise typing where possible in
 * concrete classes. This class implements {@link Comparable},
 * {@link java.io.Serializable} and {@link Iterable} interfaces.
 * <p>
 * Although the internal data structure of the container is a linked list, it is
 * a linked list of {@link Object} element types, however, when the iterator
 * traverses the {@code Node} objects, it returns {@link TupleElement}
 * implementation with information pertaining to current the element. This is
 * useful for some client classes that require additional information such as the
 * {@link DefaultTupleElementMatcher} class. This approach is also conservative
 * of memory.
 * <p>
 * This class and derived classes are immutable.
 *
 * @author Kevin Henry
 */
@SuppressWarnings("WeakerAccess")
public abstract class AbstractTupleContainer implements TupleContainer {

    public static final long serialVersionUID = -8849025043951429993L;

    private static class Node {
        public Object element;
        public Node prev;
        public Node next;

        public Node(Object element) {
            this(null,element,null);
        }

        public Node(Node prev, Object element, Node next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private transient int depth;
    private transient Node head;
    private transient Node tail;

    AbstractTupleContainer() {
        depth = 0;
        head = null;
        tail = null;
    }

    AbstractTupleContainer(Object... elements) {
        this();
        for (Object element : elements)
            add(element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(TupleContainer o) {
        if (o == null)
            throw new NullPointerException();

        if (this.equals(o))
            return 0;

        // Compare depth (sort by depth first)
        int result = this.depth() - o.depth();
        if (result != 0)
            return result;

        // Then by tuple elements
        Iterator<TupleElement> iter1 = this.iterator();
        Iterator<TupleElement> iter2 = o.iterator();
        try {
            while (iter1.hasNext() && iter2.hasNext() && result == 0)
                result = Comparators.compare(iter1.next().value(), iter2.next().value());
        } catch (ClassCastException e) {
            throw new TupleComparableException("Element types of tuples, with equal depth, must be in the same order");
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object element) {
        return indexOf(element) > -1;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<TupleElement> iterator() {
        return new Iterator<TupleElement>() {
            Node node = head;
            int index = 0;
            @Override
            public boolean hasNext() {
                return !isEmpty() && node != null;
            }

            @Override
            public TupleElement next() {
                if (node == null)
                    throw new NoSuchElementException();
                TupleElement result = new TupleElement() {
                    private Object element = node.element;
                    private int position = index + 1;
                    @Override
                    public <T> T value() {
                        @SuppressWarnings("unchecked")
                        T result = (T) element;
                        return result;
                    }

                    @Override
                    public boolean isString() {
                        return element != null && element instanceof String;
                    }

                    @Override
                    public <T extends TupleContainer> T owner() {
                        @SuppressWarnings("unchecked")
                        T result = (T) AbstractTupleContainer.this;
                        return result;
                    }

                    @Override
                    public int position() {
                        return position;
                    }
                };
                node = node.next;
                index++;
                return result;
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TupleContainer objects = (TupleContainer) o;

        if (this.depth() != objects.depth())
            return false;

        Iterator<TupleElement> iter1 = this.iterator();
        Iterator<TupleElement> iter2 = objects.iterator();

        while (iter1.hasNext() && iter2.hasNext()) {
            TupleElement e1 = iter1.next();
            TupleElement e2 = iter2.next();
            if (!Objects.equals(e1.value(),e2.value()))
                return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = 1;
        for (TupleElement element : this)
            result = 31 * result + (element.value() == null ? 0 : element.value().hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int depth() { return depth; }

    /**
     * {@inheritDoc}
     */
    @Override
    public int positionOf(Object object) {
        return indexOf(object) + 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <K> Map<K,?> toMap(Function<? super Integer, ? extends K> keyMapper) {
        Map<K,Object> result = new LinkedHashMap<>();
        int i = 0;
        for (Node node = head; node != null; node = node.next)
            result.put(keyMapper.apply(i++),node.element);

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[depth];
        int i = 0;
        for (Node node = head; node != null; node = node.next)
            result[i++] = node.element;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<?> toList() {
        List<Object> result = new ArrayList<>();
        for (Node node = head; node != null; node = node.next)
            result.add(node.element);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",");
        for (TupleElement element : this)
            if (element.value() == null) joiner.add("null");
            else joiner.add(element.value().toString());

        return String.format("%s=[%s]",this.getClass().getSimpleName(),joiner.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T value(int position) {
        verify(position);
        @SuppressWarnings("unchecked")
        T result = (T) this.get(position -1);
        return result;
    }

    protected final void verify(int position) {
        if (position < 1 || position > (depth()))
            throw new IllegalArgumentException("Position must be non-zero and less than or equal depth");
    }

    final AbstractTupleContainer add(Object element) {
        linkToLastNode(element);
        return this;
    }

    final AbstractTupleContainer addFirst(Object element) {
        linkToFirstNode(element);
        return this;
    }

    final int indexOf(Object element) {
        int result = 0;
        for (Node node = head; node != null; node = node.next) {
            if ((element == null && node.element == null) ||
                    (element != null && element.equals(node.element)))
                return result;
            result++;
        }
        return -1;
    }

    final Object get(int index) {
        validateNodeIndex(index);
        Object result = null;
        int i = 0;
        for (Node node = head; node != null; node = node.next) {
            if (index == i) {
                result = node.element;
                break;
            }
            else i++;
        }
        return result;
    }

    private Node linkToFirstNode(Object element) {
        Node link;
        if (isEmpty()) {
            link = new Node(element);
            tail = link;
        } else {
            link = new Node(null,element, head);
            head.prev = link;
        }
        head = link;
        depth++;
        return head;
    }

    private Node linkToLastNode(Object element) {
        Node link;
        if (isEmpty()) {
            link = new Node(element);
            head = link;
        } else {
            link = new Node(tail,element,null);
            tail.next = link;
        }
        tail = link;
        depth++;
        return tail;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            Object element = in.readObject();
            linkToLastNode(element);
        }
    }

    private void validateNodeIndex(int index) {
        if (index < 0 || index > depth -1)
            throw new IndexOutOfBoundsException();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(this.depth);
        for (Node node = head; node != null; node = node.next)
            out.writeObject(node.element);
    }
}

final class Comparators {
    @SuppressWarnings("unchecked")
    static <T> int compare(T v1, T v2) {
        return Objects.compare(v1,v2, Comparator.nullsLast((a, b) -> ((Comparable<T>) a).compareTo(b)));
    }
}