package io.github.coalangsoft.pattern;

import io.github.coalangsoft.data.Func;
import io.github.coalangsoft.data.ImutablePair;
import io.github.coalangsoft.data.Pair;

public class AbstractMatcher<T> {

	T[] pattern;
	T[] toTest;
	int index;
	private boolean found;

	public AbstractMatcher(T[] pattern, T[] toTest) {
		this.pattern = pattern;
		this.toTest = toTest;
		this.index = 0;
	}
	
	public boolean find(Func<Pair<T,T>, Boolean> f){
		baseLoop:
		for(;index < toTest.length - pattern.length; index++){
			for(int i = 0; i < pattern.length; i++){
				if(!f.call(new ImutablePair<T,T>(pattern[i], toTest[i + index]))){
					continue baseLoop;
				}
			}
			found = true;
			return true;
		}
		found = false;
		return false;
	}
	
	public MatchResult<T> get(){
		if(!found){
			throw new NoMatchException("No match found!");
		}
		return new MatchResult<T>(index, this);
	}

}
