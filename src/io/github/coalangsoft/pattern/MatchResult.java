package io.github.coalangsoft.pattern;

import java.util.ArrayList;

public class MatchResult<T> {

	private int index;
	private AbstractMatcher<T> matcher;

	public MatchResult(int index, AbstractMatcher<T> m) {
		this.index = index;
		this.matcher = m;
	}
	
	public int getIndex(){
		return index;
	}
	
	public ArrayList<T> getRaw(){
		ArrayList<T> l = new ArrayList<T>();
		for(int i = 0; i < matcher.pattern.length; i++){
			l.add(matcher.toTest[i + index]);
		}
		return l;
	}
	
}
