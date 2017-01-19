package io.github.coalangsoft.lib.sequence;

import io.github.coalangsoft.lib.data.Func;

public class ModifiableSequence<T,S extends ModifiableSequence<T,S>> extends AbstractSequence<T,S> {

	public ModifiableSequence(SequenceTool<T, S> tool, T[] values) {
		super(tool, values);
		// TODO Auto-generated constructor stub
	}
	
	public void add(T value){
		T[] arr = tool.array(length() + 1);
		for(int i = 0; i < length(); i++){
			arr[i] = at(i);
		}
		arr[length()] = value;
		values = arr;
	}
	
	public void clear(){
		values = tool.array(0);
	}
	
	public S link(AbstractSequence<T, ?> other, boolean duplicate){
		if(duplicate){
			return linkNoDup(other);
		}else{
			return linkDup(other);
		}
	}

	private S linkDup(AbstractSequence<T, ?> other) {
		final S ret = tool.form(values);
		other.forEach(new Func<T,Void>(){
			@Override
			public Void call(T p) {
				if(!ret.contains(p)){
					ret.add(p);
				}
				return null;
			}
		});
		return ret;
	}

	private S linkNoDup(AbstractSequence<T, ?> other) {
		final S ret = tool.form(values);
		other.forEach(new Func<T,Void>(){
			@Override
			public Void call(T p) {
				if(!ret.contains(p)){
					ret.add(p);
				}
				return null;
			}
		});
		return ret;
	}

}
