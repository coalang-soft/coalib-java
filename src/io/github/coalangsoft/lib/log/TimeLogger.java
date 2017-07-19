package io.github.coalangsoft.lib.log;

import java.io.PrintStream;
import java.util.Date;

/**
 * Basic logger class to provide time information.
 */
public class TimeLogger {
	
	/**
	 * A time logger that writes to the standard error Stream {@link System#err}.
	 */
	public static final TimeLogger err = new TimeLogger(System.err);
	/**
	 * A time logger that writes to the standard output Stream {@link System#out}.
	 */
	public static final TimeLogger std = new TimeLogger(System.out);
	
	private PrintStream out;
	
	/**
	 * Creates a new time logger.
	 * @param out the output to write the messages to.
	 */
	public TimeLogger(PrintStream out){
		this.out = out;
	}
	
	/**
	 * Logs a message. It is written to the underlying {@link PrintStream}, with a time stamp before it.
	 * @param msg the message to log
	 */
	public void log(Object msg){
		StringBuilder b = new StringBuilder();
		
		b.append("[" + new Date() + "]: ");
		
		b.append(msg);
		out.println(b.toString());
	}
	
}
