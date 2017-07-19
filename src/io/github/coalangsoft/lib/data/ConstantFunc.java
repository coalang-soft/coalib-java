package io.github.coalangsoft.lib.data;

/**
 * Function returning a constant value without evaluating every time.
 * @param <T> The type of the returned value
 */
public class ConstantFunc<T> implements Func<Void, T> {

    private final Func<Void, T> base;
    private T val;

    /**
     * Creates a new constant function. The parameter is used to evaluate once, every other time the last result gets returned.
     * @param base the base function to get the start value.
     */
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
