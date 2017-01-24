package io.github.coalangsoft.lib.sequence;

import java.util.Arrays;
import java.util.List;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.pattern.AbstractMatcher;

public class AbstractSequence<T, S extends AbstractSequence<T, ? extends S>> {
	
	protected T[] values;
	protected final SequenceTool<T, S> tool;

	public AbstractSequence(SequenceTool<T,S> tool, T... values){
		this.values = values;
		this.tool = tool;
	}
	
	public S subSequence(int start, int end){
		T[] nRaw = tool.array(end - start);
		for(int i = start; i < end; i++){
			nRaw[i - start] = values[i];
		}
		return tool.form(nRaw);
	}
	
	public S subSequence(int start){
		int end = values.length;
		T[] nRaw = tool.array(end - start);
		for(int i = start; i < end; i++){
			nRaw[i - start] = values[i];
		}
		return tool.form(nRaw);
	}
	
	public T[] getRaw(){
		return values;
	}
	
	public T at(int index){
		return values[index];
	}
	
	public T atOrDefault(int index, T defaultValue){
		if(length() <= index){
			return defaultValue;
		}else{
			return at(index);
		}
	}
	
	public int length(){
		return values.length;
	}
	
	public AbstractMatcher<T> matcher(T... toTest){
		return new AbstractMatcher<T>(values, toTest);
	}
	
	public AbstractMatcher<T> matcher(AbstractSequence<T, ?> toTest){
		return matcher(toTest.values);
	}
	
	public boolean contains(T value){
		for(int i = 0; i < values.length; i++){
			if(values[i] == value){
				return true;
			}
		}
		return false;
	}
	
	public List<T> asList(){
		return Arrays.asList(values);
	}
	
	public void forEach(Func<T,Void> f){
		for(int i = 0; i < length(); i++){
			f.call(at(i));
		}
	}

	@Override
	public String toString() {
		return "AbstractSequence [values=" + Arrays.toString(values) + "]";
	}
	
}
