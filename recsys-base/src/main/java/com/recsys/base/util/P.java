package com.recsys.base.util;

import java.nio.charset.Charset;

public class P {

	/**
	 * Print a horizontal line with 65 characters.
	 */
	public static void hline() {
		println("---------- ---------- ---------- ---------- ---------- ----------");
	}
	
	
	/**
	 * Auxiliary method for sending time information to the standard output. 
	 * Time is measured in milliseconds, see the documentation
	 * of <tt>System.currentTimeMillis()</tt> for details.
	 * 
	 */
	public static void time() {
		println("Time: "+System.currentTimeMillis());
	}
	
	/**
	 * Auxiliary method for sending time information to the standard output.
	 * The time is given in milliseconds and in relation to a given moment
	 * in the past, determined by the value of the argument <tt>t</tt>. 
	 * 
	 */
	public static void time(long t) {
		println("Time: "+ (System.currentTimeMillis()-t));
	}
	
	public static void main(String[] args) {
		println(Charset.defaultCharset().displayName());
		println("" + P.class.getName());
	}

	public static void println(String s) {
		System.out.println(s);
	}
}
