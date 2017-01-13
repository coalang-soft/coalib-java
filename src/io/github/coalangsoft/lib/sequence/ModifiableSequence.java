package io.github.coalangsoft.lib.sequence;

public class ModifiableSequence<T> extends BaseSequence<T> {

	public ModifiableSequence(SequenceTool<T, BaseSequence<T>> tool, T[] values) {
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

}
