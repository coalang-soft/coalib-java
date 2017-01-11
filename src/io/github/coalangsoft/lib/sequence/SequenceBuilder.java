package io.github.coalangsoft.lib.sequence;

import java.util.ArrayList;

public class SequenceBuilder<T,S> {
	
	private SequenceTool<T, S> tool;
	private ArrayList<T> list;
	
	public SequenceBuilder(SequenceTool<T,S> tool){
		this.tool = tool;
		this.list = new ArrayList<T>();
	}
	
	public void add(T... values){
		for(int i = 0; i < values.length; i++){
			list.add(values[i]);
		}
	}
	
	public S build(){
		return tool.form(list.toArray(tool.array(0)));
	}
	
}
