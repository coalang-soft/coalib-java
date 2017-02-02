package io.github.coalangsoft.lib.data;

public class ImutablePair<A,B> implements Pair<A,B>{

	private A a;
	private B b;

	public ImutablePair(A a, B b){
		this.a = a;
		this.b = b;
	}
	
	public A getA() {
		return a;
	}

	public B getB() {
		return b;
	}

	@Override
	public String toString() {
		return "ImutablePair [a=" + a + ", b=" + b + "]";
	}

}
