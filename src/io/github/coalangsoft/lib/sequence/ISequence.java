package io.github.coalangsoft.lib.sequence;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.pattern.AbstractMatcher;
import io.github.coalangsoft.lib.sequence.basic.BasicModifiableSequence;

import java.util.List;

public interface ISequence<T,S extends ISequence<T,? extends S>> {

    S filter(Func<T,Boolean> condition);
    S clone();
    T[] toArray();
    S subSequence(int start, int end);
    S subSequence(int start);
    T[] getRaw();
    T at(int index);
    T atOrDefault(int index, T defaultValue);
    int length();
    AbstractMatcher<T> matcher(T... toTest);
    AbstractMatcher<T> matcher(ISequence<T, ?> toTest);
    boolean contains(Object value);
    List<T> asList();
    void forEach(Func<T,?> f);
    <R> BasicModifiableSequence<R> forEach(Func<T,R> f, Class<R> c);
    S sort();
    S sort(Func<T,Integer> f);
    T first(Func<T,Boolean> rule);

}
