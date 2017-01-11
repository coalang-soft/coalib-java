package io.github.coalangsoft.lib.sequence;

import io.github.coalangsoft.lib.pattern.AbstractMatcher;

public class AbstractSequence<T, S extends AbstractSequence<T, ? extends S>> {
	
	private T[] values;
	private SequenceTool<T, S> tool;

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
	
	public int length(){
		return values.length;
	}
	
	public AbstractMatcher<T> matcher(T... toTest){
		return new AbstractMatcher<T>(values, toTest);
	}
	
	public AbstractMatcher<T> matcher(AbstractSequence<T, ?> toTest){
		return matcher(toTest.values);
	}
	
}
