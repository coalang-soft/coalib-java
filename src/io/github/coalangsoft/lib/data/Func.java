package io.github.coalangsoft.lib.data;

/**
 * Represents a function with a parameter and a return value.
 *
 * @param <P> the parameter type
 * @param <R> the return type
 */
public interface Func<P, R> {
	
	/**
	 * Calls this function.
	 * @param p the parameter
	 * @return the return result.
	 */
	public R call(P p);
	
}
