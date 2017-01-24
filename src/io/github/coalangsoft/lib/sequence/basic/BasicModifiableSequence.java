package io.github.coalangsoft.lib.sequence.basic;

import java.lang.reflect.Array;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.sequence.ModifiableSequence;
import io.github.coalangsoft.lib.sequence.SequenceTool;

public class BasicModifiableSequence<T> extends
		ModifiableSequence<T, BasicModifiableSequence<T>> {

	public BasicModifiableSequence(final Class<T> c, T... values) {
		super(new SequenceTool<>(new Func<T[], BasicModifiableSequence<T>>() {

			@Override
			public BasicModifiableSequence<T> call(T[] p) {
				return new BasicModifiableSequence<T>(c, p);
			}
			
		}, new Func<Integer, T[]>() {

			@Override
			public T[] call(Integer p) {
				return (T[]) Array.newInstance(c, p);
			}
			
		}), values);
	
	}

}
