package io.github.coalangsoft.lib.data;

/**
 * A pair with immutable values.
 *
 * @param <A> type of the first value.
 * @param <B> type of the second value.
 */
public class ImmutablePair<A,B> implements Pair<A,B>{

	//the immutable values
	private final A a;
	private final B b;

	/**
	 * Creates a new immutable pair.
	 * @param a the value {@link #getA()} returns.
	 * @param b the value {@link #getB()} returns.
	 */
	public ImmutablePair(A a, B b){
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
