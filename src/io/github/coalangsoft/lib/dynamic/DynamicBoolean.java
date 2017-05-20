package io.github.coalangsoft.lib.dynamic;

import io.github.coalangsoft.lib.data.Func;

/**
 * Created by Matthias on 11.05.2017.
 */
public class DynamicBoolean extends AbstractDynamicValue<Boolean,DynamicBoolean> {

    public DynamicBoolean(Boolean val) {
        super(val);
    }

    public DynamicBoolean(Func<Void, Boolean> func) {
        super(func);
    }

    @Override
    protected DynamicBoolean instance(Boolean v) {
        return new DynamicBoolean(v);
    }

    @Override
    protected DynamicBoolean instance(Func<Void, Boolean> f) {
        return new DynamicBoolean(f);
    }

    public DynamicBoolean not(){
        return new DynamicBoolean(new Func<Void, Boolean>() {
            @Override
            public Boolean call(Void aVoid) {
                return !get();
            }
        });
    }
    public DynamicBoolean and(final Func<Void,Boolean> f){
        return new DynamicBoolean(new Func<Void, Boolean>() {
            @Override
            public Boolean call(Void aVoid) {
                return f.call(aVoid) && get();
            }
        });
    }
    public DynamicBoolean or(final Func<Void,Boolean> f){
        return new DynamicBoolean(new Func<Void, Boolean>() {
            @Override
            public Boolean call(Void aVoid) {
                return f.call(aVoid) || get();
            }
        });
    }

    public DynamicBoolean xor(final Func<Void,Boolean> f){
        return new DynamicBoolean(new Func<Void, Boolean>() {
            @Override
            public Boolean call(Void aVoid) {
                return f.call(aVoid) ^ get();
            }
        });
    }

    public DynamicBoolean and(Boolean b){
        return and(new DynamicBoolean(b));
    }
    public DynamicBoolean or(Boolean b){
        return or(new DynamicBoolean(b));
    }
    public DynamicBoolean xor(Boolean b){
        return xor(new DynamicBoolean(b));
    }

    public <O> DynamicObject<O> _if(Func<Boolean,O> onIf, Func<Boolean,O> onElse){
        return super._if(new Func<Boolean, Boolean>() {
            @Override
            public Boolean call(Boolean aBoolean) {
                return get();
            }
        },onIf,onElse);
    }

    public <O> DynamicObject<O> _if(O onIf, O onElse){
        return super._if(new Func<Boolean, Boolean>() {
            @Override
            public Boolean call(Boolean aBoolean) {
                return get();
            }
        },onIf,onElse);
    }

}
