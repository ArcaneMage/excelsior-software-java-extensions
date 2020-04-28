package com.excelsior.core.tuple;

import com.excelsior.core.Nullable;

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
 * concrete classes. This class implements serialisation, comparison and iteration.
 * <p>
 * This class and derived classes are immutable.
 * <p>
 * //TODO: Introduce copy constructors for tuples.
 */
@SuppressWarnings("WeakerAccess")
public abstract class AbstractTuple implements Tuple  {

    public static final long serialVersionUID = 6627930356619406060L;

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

    AbstractTuple() {
        depth = 0;
        head = null;
        tail = null;
    }

    AbstractTuple(Object... elements) {
        this();
        for (Object element : elements)
            add(element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Tuple o) {
        if ( o == null )
            throw new NullPointerException();

        // Tuple must be of the same depth for now -- may reconsider
        if ( this.depth() != o.depth() )
            throw new ClassCastException();

        if ( this.equals(o) )
            return 0;

        int result = 0;
        Iterator<Object> iter1 = this.iterator();
        Iterator<Object> iter2 = o.iterator();

        while ( iter1.hasNext() && iter2.hasNext() && result == 0 ) {
            Object e1 = iter1.next();
            Object e2 = iter2.next();
            result = Comparators.compare(e1,e2);
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
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            Node node = head;
            @Override
            public boolean hasNext() {
                return !isEmpty() && node != null;
            }

            @Override
            public Object next() {
                if ( node == null )
                    throw new NoSuchElementException();
                Object result = node.element;
                node = node.next;
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
        Tuple objects = (Tuple) o;

        if ( this.depth() != objects.depth())
            return false;

        Iterator iter1 = this.iterator();
        Iterator iter2 = objects.iterator();

        while ( iter1.hasNext() && iter2.hasNext() ) {
            Object e1 = iter1.next();
            Object e2 = iter2.next();
            if ( !Objects.equals(e1,e2) )
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
        for (Object object : this)
            result = 31 * result + (object == null ? 0 : object.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public <Q,R extends Tuple> R add(int position, Q value) {
        if ( this.depth + 1 > MAX_DEPTH )
            throw new TupleOverflowException();
        if ( position == 1 ) {
            return Tuple.of(value).join(this);
        } else {
            Tuple2<Tuple,Tuple> spliced = this.splice(position);
            return spliced.value1().join(value).join(spliced.value2());
        }
    }

    /**
     * {@inheritDoc}
     */
    public int depth() { return depth; }

    /**
     * {@inheritDoc}
     */
    public <Q extends Tuple, R extends Tuple> R join(Q that) {
        Objects.requireNonNull(that);
        int depth = this.depth + that.depth();
        if ( depth > MAX_DEPTH )
            throw new TupleOverflowException();
        Object[] objects = getObjects(this,that);
        Nullable<R> result = Tuples.fromIterable(Arrays.asList(objects),objects.length);
        return result.get();
    }

    /**
     * {@inheritDoc}
     */
    public int positionOf(Object object) {
        return indexOf(object) + 1;
    }

    /**
     * {@inheritDoc}
     */
    public <Q extends Tuple, R extends Tuple> Tuple2<Q,R> splice(int position) {
        verify(position);
        Nullable<Q> primary = Tuples.fromIterable(this,0,position -1);
        Nullable<R> secondary = Tuples.fromIterable(this,position,depth() - position + 1);
        return Tuple.of(primary.get(),secondary.get());
    }

    /**
     * {@inheritDoc}
     */
    public <T extends Tuple> T truncate(int position) {
        verify(position);
        Object[] objects = getObjects(this);
        Nullable<T> result = Tuples.fromIterable(Arrays.asList(objects),position -1);
        return result.get();
    }

    /**
     * {@inheritDoc}
     */
    public <K> Map<K,?> toMap(Function<? super Integer,? extends K> keyMapper) {
        Map<K,Object> result = new LinkedHashMap<>();
        int i = 0;
        for ( Node node = head; node != null; node = node.next )
            result.put(keyMapper.apply(i++),node.element);

        return result;
    }

    /**
     * {@inheritDoc}
     */
    public Object[] toArray() {
        Object[] result = new Object[depth];
        int i = 0;
        for ( Node node = head; node != null; node = node.next )
            result[i++] = node.element;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public List<?> toList() {
        List<Object> result = new ArrayList<>();
        for ( Node node = head; node != null; node = node.next )
            result.add(node.element);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        StringJoiner joiner = new StringJoiner(",");
        for (Object o : this)
            if (o == null) joiner.add("null");
            else joiner.add(o.toString());

        return String.format("%s=[%s]",this.getClass().getSimpleName(),joiner.toString());
    }

    final AbstractTuple add(Object element) {
        linkToLastNode(element);
        return this;
    }

    final AbstractTuple addFirst(Object element) {
        linkToFirstNode(element);
        return this;
    }

    final int indexOf(Object element) {
        int result = 0;
        for (Node node = head; node != null; node = node.next) {
            if ( (element == null && node.element == null) ||
                    (element != null && element.equals(node.element)) )
                return result;
            result++;
        }
        return -1;
    }

    final Object get(int index) {
        validateNodeIndex(index);
        Object result = null;
        int i = 0;
        for ( Node node = head; node != null && result == null; node = node.next ) {
            if ( index == i ) result = node.element;
            else i++;
        }
        return result;
    }

    private Object[] getObjects(final Tuple... tuples) {
        // Calculate depth
        int depth = 0;
        for ( Tuple tuple : tuples )
            depth += tuple.depth();
        // Convert to objects
        Object[] result = new Object[depth];
        int i = 0;
        for ( Tuple tuple : tuples ) {
            Iterator<?> iter = tuple.iterator();
            while (iter.hasNext()) result[i++] = iter.next();
        }
        return result;
    }

    private Node linkToFirstNode(Object element) {
        Node link;
        if ( isEmpty() ) {
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
        if ( isEmpty() ) {
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
        for ( int i = 0; i < size; i++ ) {
            Object element = in.readObject();
            linkToLastNode(element);
        }
    }

    private void validateNodeIndex(int index) {
        if ( index < 0 || index > depth -1)
            throw new IndexOutOfBoundsException();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(this.depth);
        for (Node node = head; node != null; node = node.next)
            out.writeObject(node.element);
    }

    private void verify(int position) {
        if ( position < 1 || position > (depth()) )
            throw new IllegalArgumentException("Position must be non-zero and less than or equal depth");
    }
}

final class Comparators {
    @SuppressWarnings("unchecked")
    static <T> int compare(T v1, T v2) {
        return Objects.compare(v1,v2, Comparator.nullsLast((a, b) -> ((Comparable<T>) a).compareTo(b)));
    }
}