package io.github.coalangsoft.lib.dynamic;

import io.github.coalangsoft.lib.data.Func;

/**
 * Created by Matthias on 11.05.2017.
 */
public class DynamicObject<T> extends AbstractDynamicValue<T,DynamicObject<T>>{

    public DynamicObject(T val) {
        super(val);
    }

    public DynamicObject(Func<Void, ? extends T> func) {
        super(func);
    }

    @Override
    protected DynamicObject<T> instance(T v) {
        return new DynamicObject<T>(v);
    }

    @Override
    protected DynamicObject<T> instance(Func<Void, T> f) {
        return new DynamicObject<T>(f);
    }

}
