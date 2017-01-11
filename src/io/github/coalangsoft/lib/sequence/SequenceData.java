package io.github.coalangsoft.lib.sequence;

import io.github.coalangsoft.lib.data.Func;

public class SequenceData<T, S> {
	
	private Func<T[], S> former;
	private Func<Integer, T[]> arrayFormer;
	
	public void setFormer(Func<T[], S> former){
		this.former = former;
	}
	public void setArrayFormer(Func<Integer, T[]> arrayFormer){
		this.arrayFormer = arrayFormer;
	}
	
	public SequenceTool<T,S> buildTool(){
		return new SequenceTool<T,S>(
			former,
			arrayFormer
		);
	}
	
}
