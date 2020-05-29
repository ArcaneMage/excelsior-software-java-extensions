package org.javalaboratories.core.tuple;

import java.util.EnumSet;
import java.util.Set;

import static org.javalaboratories.core.tuple.AbstractMatcher.MatcherProperties.MATCH_ALL;
import static org.javalaboratories.core.tuple.AbstractMatcher.MatcherProperties.MATCH_ANY;

public final class Matcher3<T1,T2,T3> extends AbstractMatcher {
    private final T1 t1;
    private final T2 t2;
    private final T3 t3;

    public static <T1,T2,T3> Matcher3<T1,T2,T3> all(T1 t1, T2 t2, T3 t3) { return new Matcher3<>(t1,t2,t3); }
    public static <T1,T2,T3> Matcher3<T1,T2,T3> any(T1 t1, T2 t2, T3 t3) { return new Matcher3<>(EnumSet.of(MATCH_ANY),t1,t2,t3); }

    private Matcher3(T1 t1, T2 t2, T3 t3) {
        this(EnumSet.of(MATCH_ALL),t1,t2,t3);
    }

    private Matcher3(Set<MatcherProperties> properties, T1 t1, T2 t2, T3 t3) {
        super(properties,t1,t2,t3);
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    public T1 value1() {
        return t1;
    }
    public T2 value2() {
        return t2;
    }
    public T3 value3() {
        return t3;
    }
}