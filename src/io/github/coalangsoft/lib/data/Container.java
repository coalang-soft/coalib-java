package io.github.coalangsoft.lib.data;

import java.util.ArrayList;
import java.util.List;

/**
 * A basic value container that allows to add change listeners.
 * @param <T> the type of the value to store.
 */

public class Container<T> {

    private T value;
    private List<Func<Container<T>,Void>> listeners;
    
    /**
     * Creates a container with an initial value and no listeners.
     * @param val the initial value.
     */
    public Container(T val){
        this.value = val;
        this.listeners = new ArrayList<Func<Container<T>,Void>>();
    }

    /**
     * Adds a listener to this container. Listeners are called when {@link #setValue(Object)} is used.
     * @param l the listener to add.
     */
    public void addListener(Func<Container<T>, Void> l){
        listeners.add(l);
    }

    /**
     * Returns the current value of this container.
     * @return the value.
     */
    public T getValue(){
        return value;
    }

    /**
     * Sets the value of this container and triggers the listeners.
     * @param val the new value.
     * @see #addListener(Func)
     */
    public final void setValue(T val){
        value = val;
        triggerListeners();
    }

    /**
     * Triggers the listeners.
     */
    private void triggerListeners() {
        for(int i = 0; i < listeners.size(); i++){
            listeners.get(i).call(this);
        }
    }

}
