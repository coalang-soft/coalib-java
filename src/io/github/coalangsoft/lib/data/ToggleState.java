package io.github.coalangsoft.lib.data;

/**
 * Created by Matthias on 05.03.2017.
 */
public class ToggleState<T> {

    private final T[] values;
    private int index = 0;

    public static ToggleState<Integer> byIntArray(int[] arr){
        Integer[] res = new Integer[arr.length];
        for(int i = 0; i < res.length; i++){
            res[i] = arr[i];
        }
        return new ToggleState<Integer>(res);
    }

    public ToggleState(T[] values){
        if(values.length == 0){
            throw new IllegalArgumentException("Minimum one value expected!");
        }
        this.values = values;
    }

    public T getCurrentValue(){
        return values[index];
    }

    public void toggle(){
        index++;
        if(index >= values.length){
            index = 0;
        }
        onToggle(getCurrentValue());
    }

    protected void onToggle(T current){}

}
