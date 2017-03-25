package io.github.coalangsoft.lib.reflect;

public interface CustomClassFinder {
	
	Class<?> find(String name) throws ClassNotFoundException;
	
}
