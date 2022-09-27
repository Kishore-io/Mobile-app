package com.wp.mobilephone.exception;

public class MobileAlreadyExistsException extends RuntimeException {

	String msg;
	public MobileAlreadyExistsException(String msg) {
		super(msg);
	}
}
