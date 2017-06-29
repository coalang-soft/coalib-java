package io.github.coalangsoft.lib;

/**
 * Created by Matthias on 23.02.2017.
 */

public abstract class RVThread<T> extends Thread{

    private T value;

    public void run(){
        value = eval();
    }

    protected abstract T eval();
    public T getValue(){
        return value;
    }

}
