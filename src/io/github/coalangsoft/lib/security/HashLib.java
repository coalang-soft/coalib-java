package io.github.coalangsoft.lib.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashLib {
	
	public static byte[] hash(byte[] dat) throws NoSuchAlgorithmException{
		return algorithm("SHA-256").digest(dat);
	}
	
	public static MessageDigest algorithm(String name) throws NoSuchAlgorithmException{
		return MessageDigest.getInstance(name);
	}
	
}
