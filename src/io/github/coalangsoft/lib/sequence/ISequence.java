package io.github.coalangsoft.lib.sequence;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.pattern.AbstractMatcher;
import io.github.coalangsoft.lib.sequence.basic.BasicModifiableSequence;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface ISequence<T,S extends ISequence<T,? extends S>> extends Iterable<T> {

    S filter(Func<T,Boolean> condition);
    S clone();
    T[] toArray();
    S subSequence(int start, int end);
    S subSequence(int start);
    T[] getRaw();
    T at(int index);
    default T atOrDefault(int index, T defaultValue){
        if(length() <= index){
            return defaultValue;
        }else{
            return at(index);
        }
    }
    int length();
    AbstractMatcher<T> matcher(T... toTest);
    AbstractMatcher<T> matcher(ISequence<T, ?> toTest);
    boolean contains(Object value);
    List<T> asList();
    void forEach(Func<T,?> f);
    <R> BasicModifiableSequence<R> forEach(Func<T,R> f, Class<R> c);
    default void forEach(Func<T,Boolean> condition, Func<T,?> f){
        forEach((a) -> {
            if(condition.call(a)){
                f.call(a);
            }
            return null;
        });
    }
    S sort();
    S sort(Func<T,Long> f);
    T first(Func<T,Boolean> rule);
    default <R> List<R> asList(Func<T, R> f) {
        ArrayList<R> list = new ArrayList<>();
        forEach((t) -> {
            list.add(f.call(t));
            return null;
        });
        return list;
    }
    default <R> List<R> asList(Func<T, Boolean> condition, Func<T, R> f) {
        ArrayList<R> list = new ArrayList<>();
        forEach(condition, (t) -> {
            list.add(f.call(t));
            return null;
        });
        return list;
    }
    default void forEach(Consumer<? super T> c){
        forEach((f) -> {c.accept(f); return null;});
    }

}
