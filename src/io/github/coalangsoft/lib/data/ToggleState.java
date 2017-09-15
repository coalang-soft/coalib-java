package io.github.coalangsoft.lib.data;

/**
 * Tool to toggle between multiple values.
 * @param <T> the type of values.
 */
public class ToggleState<T> {

    private final T[] values;
    private int index = 0;

    /**
     * Creates a new toggle state by an integer array.
     * @param arr the integer array.
     * @return the toggle state.
     */
    public static ToggleState<Integer> byIntArray(int[] arr){
        Integer[] res = new Integer[arr.length];
        for(int i = 0; i < res.length; i++){
            res[i] = arr[i];
        }
        return new ToggleState<Integer>(res);
    }

    /**
     * Creates a new toggle state.
     * @param values the values to toggle between.
     */
    public ToggleState(T[] values){
        if(values.length == 0){
            throw new IllegalArgumentException("Minimum one value expected!");
        }
        this.values = values;
    }

    /**
     * Returns the current value of the toggle state, but does not toggle.
     * To do that, use {@link #toggle()}.
     * @return the current value.
     */
    public T getCurrentValue(){
        return values[index];
    }

    /**
     * Toggles to the next value.
     */
    public void toggle(){
        index++;
        if(index >= values.length){
            index = 0;
        }
        onToggle(getCurrentValue());
    }

    /**
     * This is called whenever the {@link #toggle()} method is used.
     * Listens to state changes.
     * @param current the current value (after toggling)
     */
    protected void onToggle(T current){}
    
    public static <T extends Enum<T>> T firstDifferent(T current, T... others){
    	for(int i = 0; i < others.length; i++){
    		if(others[i] != current){
    			return others[i];
    		}
    	}
    	return null;
    }

}
