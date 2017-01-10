package io.github.coalangsoft.pattern;

public class AbstractPattern<T> {
	
	private T[] pattern;

	public AbstractPattern(T... pattern){
		this.pattern = pattern;
	}
	
	public AbstractMatcher<T> matcher(T... toTest){
		return new AbstractMatcher<T>(pattern, toTest);
	}
	
}
