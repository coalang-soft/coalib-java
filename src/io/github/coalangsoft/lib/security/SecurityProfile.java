package io.github.coalangsoft.lib.security;

import java.util.ArrayList;
import java.util.regex.Pattern;

import io.github.coalangsoft.lib.data.OneModConstant;

public class SecurityProfile extends SecurityManager {
	
	private OneModConstant<Boolean> fileRead;
	private ArrayList<Pattern> fileReadSignatures;
	private OneModConstant<Boolean> fileWrite;
	private ArrayList<Pattern> fileWriteSignatures;
	private OneModConstant<Boolean> packageAccess;
	private ArrayList<Pattern> packageAccessSignatures;
	private OneModConstant<Boolean> propertyAccess;
	private ArrayList<Pattern> propertyAccessSignatures;
	private OneModConstant<Boolean> freeze;
	
	{
		fileRead = new OneModConstant<Boolean>(false);
		fileReadSignatures = new ArrayList<>();
		fileWrite = new OneModConstant<Boolean>(false);
		fileWriteSignatures = new ArrayList<>();
		packageAccess = new OneModConstant<Boolean>(false);
		packageAccessSignatures = new ArrayList<>();
		propertyAccess = new OneModConstant<Boolean>(false);
		propertyAccessSignatures = new ArrayList<>();
		freeze = new OneModConstant<Boolean>(false);
	}
	
	public void checkRead(String file){
		if(!fileRead.get()){
			throw new SecurityException("File reading not allowed!");
		}
		for(int i = 0; i < fileReadSignatures.size(); i++){
			if(fileReadSignatures.get(i).matcher(file).matches()){
				return;
			}
		}
		throw new SecurityException("File signature not allowed for reading: " + file);
	}
	
	public void allowFileReading(boolean b){
		allow();
		fileRead.set(b);
	}
	
	public void allowFileReadSignature(String regex){
		allow();
		fileReadSignatures.add(Pattern.compile(regex));
	}
	
	public void checkWrite(String file){
		if(!fileRead.get()){
			throw new SecurityException("File writing not allowed!");
		}
		for(int i = 0; i < fileWriteSignatures.size(); i++){
			if(fileWriteSignatures.get(i).matcher(file).matches()){
				return;
			}
		}
		throw new SecurityException("File signature not allowed for writing: " + file);
	}
	
	public void allowFileWriting(boolean b){
		allow();
		fileWrite.set(b);
	}
	
	public void allowFileWriteSignature(String regex){
		allow();
		fileWriteSignatures.add(Pattern.compile(regex));
	}
	
	public void checkPackageAccess(String pack){
		if(!packageAccess.get()){
			throw new SecurityException("Package access is not allowed!");
		}
		for(int i = 0; i < packageAccessSignatures.size(); i++){
			if(packageAccessSignatures.get(i).matcher(pack).matches()){
				return;
			}
		}
		throw new SecurityException("Package signature not allowed for access: " + pack);
	}
	
	public void allowPackageAccess(boolean b){
		allow();
		packageAccess.set(b);
	}
	
	public void allowPackageAccessSignature(String regex){
		allow();
		packageAccessSignatures.add(Pattern.compile(regex));
	}
	
	public void checkPropertyAccess(String prop){
		if(!propertyAccess.get()){
			throw new SecurityException("Property access is not allowed!");
		}
		for(int i = 0; i < propertyAccessSignatures.size(); i++){
			if(propertyAccessSignatures.get(i).matcher(prop).matches()){
				return;
			}
		}
		throw new SecurityException("Property signature not allowed for access: " + prop);
	}
	
	public void allowPropertyAccess(boolean b){
		allow();
		propertyAccess.set(b);
	}
	
	public void allowPropertyAccessSignature(String regex){
		allow();
		propertyAccessSignatures.add(Pattern.compile(regex));
	}

	private void allow() {
		if(freeze.get()){
			throw new SecurityException("SecurityProfile is frozen. Not possible to change.");
		}
	}
	
	public void freeze(){
		freeze.set(true);
	}
	
}
