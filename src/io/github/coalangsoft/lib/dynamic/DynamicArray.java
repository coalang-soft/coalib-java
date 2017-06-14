package io.github.coalangsoft.lib.dynamic;

import io.github.coalangsoft.lib.data.Func;

/**
 * Created by Matthias on 07.06.2017.
 */
public class DynamicArray<T> extends DynamicObject<T[]>{

    private final Func<Integer, T> factory;

    public DynamicArray(T[] val) {
        super(val);
        factory = null;
    }

    public DynamicArray(Func<Integer, T> func){
        super((T[]) null);
        this.factory = func;
    }

    public static <T> DynamicArray<T> create(Func<Void, T[]> f){
        return new DynamicArray<T>(new Func<Integer, T>() {
            @Override
            public T call(Integer integer) {
                return f.call(null)[integer];
            }
        });
    }

    public DynamicObject<T> at(DynamicDouble index){
        if(factory != null){
            return new DynamicObject<T>(new Func<Void, T>() {
                @Override
                public T call(Void aVoid) {
                    return factory.call(index.get().intValue());
                }
            });
        }else{
            return new DynamicObject<T>(new Func<Void, T>() {
                @Override
                public T call(Void aVoid) {
                    return get()[index.get().intValue()];
                }
            });
        }
    }

    public DynamicObject<T> at(double d){
        return at(new DynamicDouble(d));
    }

    public <D> DynamicArray<D> forEach(Func<T, D> f){
        return new DynamicArray<D>(new Func<Integer, D>() {
            @Override
            public D call(Integer integer) {
                return f.call(at(integer).get());
            }
        });
    }

}
