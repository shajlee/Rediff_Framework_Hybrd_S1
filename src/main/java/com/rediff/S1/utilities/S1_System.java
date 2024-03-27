package com.rediff.S1.utilities;

public class S1_System {
	
	public static void main (String [] args) {
		System.getProperties().list(System.out);
		System.out.println("-------------------------------");
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("java.runtime.version"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.country"));
		System.out.println(System.getProperty("user.language"));
		
		
		
		
	}

}
