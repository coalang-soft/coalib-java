package io.github.coalangsoft.lib.dynamic;

import io.github.coalangsoft.lib.data.Func;

/**
 * Created by Matthias on 11.05.2017.
 */
public abstract class AbstractDynamicNumber<T extends Number, D extends AbstractDynamicNumber<T,D>> extends AbstractDynamicValue<T,D> {

    public AbstractDynamicNumber(T val) {
        super(val);
    }

    public AbstractDynamicNumber(Func<Void,T> f){
        super(f);
    }

    protected abstract D instance(Func<Void,T> f);
    protected abstract D instance(T v);

    protected abstract T addImpl(T a,T b);
    protected abstract T subImpl(T a,T b);
    protected abstract T mulImpl(T a,T b);
    protected abstract T divImpl(T a,T b);
    protected abstract T powImpl(T a,T b);
    protected abstract boolean lssImpl(T a,T b);
    protected abstract boolean gtrImpl(T a,T b);
    protected abstract T modImpl(T a,T b);

    public D add(final Func<Void,T> f){
        return instance(new Func<Void, T>() {
            @Override
            public T call(Void aVoid) {
                return addImpl(get(),f.call(aVoid));
            }
        });
    }
    public D sub(final Func<Void,T> f){
        return instance(new Func<Void, T>() {
            @Override
            public T call(Void aVoid) {
                return subImpl(get(),f.call(aVoid));
            }
        });
    }
    public D mul(final Func<Void,T> f){
        return instance(new Func<Void, T>() {
            @Override
            public T call(Void aVoid) {
                return mulImpl(get(),f.call(aVoid));
            }
        });
    }
    public D div(final Func<Void,T> f){
        return instance(new Func<Void, T>() {
            @Override
            public T call(Void aVoid) {
                return divImpl(get(),f.call(aVoid));
            }
        });
    }
    public D pow(final Func<Void,T> f){
        return instance(new Func<Void, T>() {
            @Override
            public T call(Void aVoid) {
                return powImpl(get(),f.call(aVoid));
            }
        });
    }
    public DynamicBoolean lss(final Func<Void,T> f){
        return new DynamicBoolean(new Func<Void, Boolean>() {
            @Override
            public Boolean call(Void aVoid) {
                return lssImpl(get(),f.call(aVoid));
            }
        });
    }
    public DynamicBoolean gtr(final Func<Void,T> f){
        return new DynamicBoolean(new Func<Void, Boolean>() {
            @Override
            public Boolean call(Void aVoid) {
                return gtrImpl(get(),f.call(aVoid));
            }
        });
    }
    public D mod(final Func<Void,T> f){
        return instance(new Func<Void, T>() {
            @Override
            public T call(Void aVoid) {
                return modImpl(get(),f.call(aVoid));
            }
        });
    }

    public D add(T a){
        return this.add(instance(a));
    }
    public D sub(T a){
        return this.sub(instance(a));
    }
    public D mul(T a){
        return this.mul(instance(a));
    }
    public D div(T a){
        return this.div(instance(a));
    }
    public D pow(T a){
        return this.pow(instance(a));
    }
    public D mod(T a){
        return this.mod(instance(a));
    }
    public DynamicBoolean lss(T a){
        return this.lss(instance(a));
    }
    public DynamicBoolean gtr(T a){
        return this.gtr(instance(a));
    }

}
