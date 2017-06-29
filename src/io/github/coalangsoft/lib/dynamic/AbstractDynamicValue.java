package io.github.coalangsoft.lib.dynamic;

import io.github.coalangsoft.lib.data.Func;

/**
 * Created by Matthias on 11.05.2017.
 */
public abstract class AbstractDynamicValue<T, D extends AbstractDynamicValue<T,D>> implements Func<Void,T>{

    protected Func<Void, ? extends T> func;

    public AbstractDynamicValue(final T val){
        this(new Func<Void,T>(){

            @Override
            public T call(Void aVoid) {
                return val;
            }

        });
    }
    public AbstractDynamicValue(Func<Void,? extends T> func){
        this.func=func;
    }

    @Override
    public T call(Void aVoid) {
        return func.call(aVoid);
    }

    protected abstract D instance(T v);
    protected abstract D instance(Func<Void,T> f);

    public D act(final Func<T,T> f){
        return instance(new Func<Void, T>() {
            @Override
            public T call(Void aVoid) {
                return f.call(get());
            }
        });
    }

    public DynamicBoolean equ(final Func<Void,T> f){
        return new DynamicBoolean(new Func<Void, Boolean>() {
            @Override
            public Boolean call(Void aVoid) {
                T a = get();
                T b = f.call(aVoid);
                if(a==null){
                    return b==null;
                }
                return a.equals(b);
            }
        });
    }
    public DynamicBoolean equ(T a){
        return this.equ(instance(a));
    }

    public DynamicBoolean same(final Func<Void,T> f){
        return new DynamicBoolean(new Func<Void, Boolean>() {
            @Override
            public Boolean call(Void aVoid) {
                return get() == f.call(aVoid);
            }
        });
    }
    public DynamicBoolean same(T a){
        return this.same(instance(a));
    }

    public DynamicBoolean bool(final Func<T,Boolean> f){
        return new DynamicBoolean(new Func<Void, Boolean>() {
            @Override
            public Boolean call(Void aVoid) {
                return f.call(get());
            }
        });
    }
    public DynamicString str(final Func<T,String> f){
        return new DynamicString(new Func<Void, String>() {
            @Override
            public String call(Void aVoid) {
                return f.call(get());
            }
        });
    }
    public DynamicDouble num(final Func<T,Double> f){
        return new DynamicDouble(new Func<Void, Double>() {
            @Override
            public Double call(Void aVoid) {
                return f.call(get());
            }
        });
    }

    public DynamicBoolean bool(){
        return bool(new Func<T, Boolean>() {
            @Override
            public Boolean call(T t) {
                return (Boolean) t;
            }
        });
    }
    public DynamicString str(){
        return str(new Func<T, String>() {
            @Override
            public String call(T t) {
                return t + "";
            }
        });
    }
    public DynamicDouble num(){
        return num(new Func<T, Double>() {
            @Override
            public Double call(T t) {
                if(t instanceof Boolean){
                    return ((Boolean) t).booleanValue() ? 1d : 0d;
                }
                return ((Number) t).doubleValue();
            }
        });
    }

    public <O> DynamicObject<O> cast(final Func<T,O> f){
        return new DynamicObject<O>(new Func<Void, O>() {
            @Override
            public O call(Void aVoid) {
                return f.call(get());
            }
        });
    }

    public T get(){
        return call(null);
    }

    public <O> DynamicObject<O> _if(final Func<T,Boolean> condition, final Func<T,O> onIf, final Func<T,O> onElse) {
        return new DynamicObject<O>(new Func<Void, O>() {
            @Override
            public O call(Void aVoid) {
                T t = get();
                if(condition.call(t)){
                    return onIf.call(t);
                }else{
                    return onElse.call(t);
                }
            }
        });
    }

    public <O> DynamicObject<O> _if(final Boolean condition, Func<T,O> onIf, Func<T,O> onElse){
        return _if(new Func<T,Boolean>(){
            @Override
            public Boolean call(T t) {
                return condition;
            }
        }, onIf, onElse);
    }

    public <O> DynamicObject<O> _if(Boolean condition, O onIf, O onElse){
        return new DynamicObject<O>(condition ? onIf : onElse);
    }

    public <O> DynamicObject<O> _if(Func<T,Boolean> condition, final O onIf, final O onElse){
        return _if(condition, new Func<T,O>(){
            @Override
            public O call(T t) {
                return onIf;
            }
        }, new Func<T,O>(){
            @Override
            public O call(T t) {
                return onElse;
            }
        });
    }

}
