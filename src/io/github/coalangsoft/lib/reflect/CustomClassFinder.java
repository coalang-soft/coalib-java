package io.github.coalangsoft.lib.reflect;

import java.net.URL;

public interface CustomClassFinder {
	
	Class<?> find(String name) throws ClassNotFoundException;
	URL resource(String name);
	
}
