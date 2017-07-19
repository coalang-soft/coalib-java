package io.github.coalangsoft.lib;

/**
 * Thread that returns a value.
 * @param <T> the type of the return value.
 */
public abstract class RVThread<T> extends Thread{

    private T value;

    /**
     * The standard run methods. Runs {@link #eval()} and saves the result as the return value.
     */
    public final void run(){
        value = eval();
    }

    /**
     * The main action of the thread.
     * @return the return value - can be accessed using {{@link #getValue()} after the thread finished.
     */
    protected abstract T eval();
    
    /**
     * Returns the current value of this thread - null if the thread never finished.
     * @return the current value.
     */
    public T getValue(){
        return value;
    }

}
