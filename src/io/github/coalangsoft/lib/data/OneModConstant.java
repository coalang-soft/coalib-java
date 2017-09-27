package io.github.coalangsoft.lib.data;

public class OneModConstant<T> {
	
	private T value;
	private boolean changed;

	public OneModConstant(T value){
		this.value = value;
	}
	
	public T get(){
		return value;
	}
	
	public void set(T value){
		if(changed){
			throw new IllegalStateException("Value was already set!");
		}
		this.value = value;
		this.changed = true;
	}
	
}
