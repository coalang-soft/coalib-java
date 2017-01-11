package io.github.coalangsoft.lib.sequence;

import java.util.Arrays;

import io.github.coalangsoft.lib.data.Func;

public class BaseSequence<T> extends AbstractSequence<T, BaseSequence<T>> {

	public static <T> SequenceTool<T, BaseSequence<T>> makeTool(final Func<Integer, T[]> arrayFormer){
		SequenceData<T, BaseSequence<T>> d = new SequenceData<>();
		d.setFormer(new Func<T[], BaseSequence<T>>() {

			@Override
			public BaseSequence<T> call(T[] p) {
				return new BaseSequence<T>(makeTool(arrayFormer), p);
			}
			
		});
		d.setArrayFormer(arrayFormer);
		return d.buildTool();
	}
	
	public static <T> BaseSequence<T> makeSequence(Func<Integer, T[]> arrayFormer, T... values){
		return new BaseSequence<T>(makeTool(arrayFormer), values);
	}
	
	public BaseSequence(SequenceTool<T, BaseSequence<T>> tool, T... values) {
		super(tool, values);
	}
	
	public String toString(){
		return Arrays.toString(getRaw());
	}

}
