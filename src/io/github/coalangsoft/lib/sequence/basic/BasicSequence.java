package io.github.coalangsoft.lib.sequence.basic;

import java.lang.reflect.Array;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.sequence.AbstractSequence;
import io.github.coalangsoft.lib.sequence.SequenceTool;

public class BasicSequence<T> extends AbstractSequence<T, BasicSequence<T>>{

	public BasicSequence(final Class<T> c, T... values) {
		super(new SequenceTool<>(new Func<T[], BasicSequence<T>>() {

			@Override
			public BasicSequence<T> call(T[] p) {
				return new BasicSequence<T>(c, p);
			}
			
		}, new Func<Integer, T[]>() {

			@Override
			public T[] call(Integer p) {
				return (T[]) Array.newInstance(c, p);
			}
			
		}), values);
	}

}
