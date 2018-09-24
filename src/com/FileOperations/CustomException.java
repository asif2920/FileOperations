package com.FileOperations;
/**
 * 
 * @author asif
 * 
 * Example of custom Exception handling
 *
 */
public class CustomException extends Exception{
	private String strExceptionValue;
	public CustomException(String s) {
		strExceptionValue=s;
	}
	public String toString() {
		return strExceptionValue;
	}

}
