package io.github.coalangsoft.lib.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Matthias on 19.04.2017.
 */

public class Container<T> {

    private T value;
    private List<Func<Container<T>,Void>> listeners;
    private Map<Integer, Integer> dexes = new HashMap<>();

    public Container(T val){
        this.value = val;
        this.listeners = new ArrayList<Func<Container<T>,Void>>();
    }

    public void addListener(Func<Container<T>, Void> l){
        listeners.add(l);
    }

    public T getValue(){
        return value;
    }

    public final void setValue(T val){
        value = val;
        update();
    }

    private void update() {
        for(int i = 0; i < listeners.size(); i++){
            listeners.get(i).call(this);
        }
    }

}
