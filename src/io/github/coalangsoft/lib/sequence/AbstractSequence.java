package io.github.coalangsoft.lib.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.pattern.AbstractMatcher;

public class AbstractSequence<T, S extends AbstractSequence<T, ? extends S>> {
	
	protected T[] values;
	protected final SequenceTool<T, S> tool;

	public S clone(){
		return tool.form(values.clone());
	}

	public T[] toArray(){
		return values.clone();
	}

	public AbstractSequence(SequenceTool<T,S> tool, T... values){
		this.values = values;
		this.tool = tool;
		if(this.values == null){
			this.values = tool.array(0);
		}
	}
	
	public S filter(final Func<T,Boolean> filter){
		final ArrayList<T> oks = new ArrayList<T>();
		forEach(new Func<T, Void>() {
			public Void call(T p) {
				if(filter.call(p)){
					oks.add(p);
				}
				return null;
			}
		});
		return tool.form(oks.toArray(tool.array(0)));
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
	
	public boolean contains(Object value){
		for(int i = 0; i < values.length; i++){
			if(values[i].equals(value)){
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

	public S sort(){
		List<T> l = asList();
		Collections.sort((List<? extends Comparable>) l);
		return tool.form(l.toArray(tool.array(0)));
	}
	
	@Override
	public String toString() {
		return "AbstractSequence [values=" + Arrays.toString(values) + "]";
	}

}
