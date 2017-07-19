package io.github.coalangsoft.lib.data;

/**
 * A basic pair of two values.
 *
 * @param <A> type of one value.
 * @param <B> type of the other value.
 */
public interface Pair<A, B> {
	
	/**
	 * Returns the one value.
	 * @return the value.
	 */
	A getA();
	/**
	 * Returns the other value.
	 * @return the value.
	 */
	B getB();
	
}
