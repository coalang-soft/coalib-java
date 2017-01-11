package io.github.coalangsoft.lib.pattern;

import java.util.Arrays;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.data.ImutablePair;
import io.github.coalangsoft.lib.data.Pair;

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
		if(toTest.length == pattern.length){
			return matches(f);
		}
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
	
	public boolean matches(Func<Pair<T,T>, Boolean> f) {
		if(toTest.length != pattern.length){
			return false;
		}
		for(int i = 0; i < toTest.length; i++){
			if(!f.call(new ImutablePair<T,T>(toTest[i], pattern[i]))){
				return false;
			}
		}
		return true;
	}

	public MatchResult<T> get(){
		if(!found){
			throw new NoMatchException("No match found!");
		}
		return new MatchResult<T>(index, this);
	}

}
