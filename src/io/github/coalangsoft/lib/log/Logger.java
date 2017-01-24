package io.github.coalangsoft.lib.log;

import java.io.PrintStream;
import java.util.Date;

public class Logger {
	
	public static final Logger err = new Logger(System.err);
	public static final Logger std = new Logger(System.out);
	
	private PrintStream out;
	private boolean logTime = true;
	
	public Logger(PrintStream out){
		this.out = out;
	}
	
	public void log(Object msg){
		StringBuilder b = new StringBuilder();
		if(logTime){
			b.append("[" + new Date() + "]: ");
		}
		b.append(msg);
		out.println(b.toString());
	}
	
}
