package io.github.coalangsoft.sequence;

import io.github.coalangsoft.data.Func;

public class SequenceTool<T,S> {

	private Func<T[], S> former;
	private Func<Integer, T[]> arrayFormer;

	public SequenceTool(
			Func<T[], S> former,
			Func<Integer, T[]> arrayFormer
		) {
		this.former = former;
		this.arrayFormer = arrayFormer;
	}
	
	public S form(T[] rawSequence){
		return former.call(rawSequence);
	}

	public T[] array(int size) {
		return arrayFormer.call(size);
	}

}
