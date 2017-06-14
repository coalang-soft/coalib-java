package io.github.coalangsoft.lib.data;

/**
 * Created by Matthias on 13.06.2017.
 */
public class ConstantFunc<T> implements Func<Void, T> {

    private final Func<Void, T> base;
    private T val;

    public ConstantFunc(Func<Void, T> base){
        this.base = base;
    }

    @Override
    public T call(Void aVoid) {
        if(val == null){
            return val = base.call(null);
        }else{
            return val;
        }
    }

}
