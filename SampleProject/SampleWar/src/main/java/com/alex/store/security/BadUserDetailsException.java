package com.alex.store.security;

public class BadUserDetailsException extends RuntimeException {

	private static final long serialVersionUID = 9056650388889852211L;

	public BadUserDetailsException(String msg, Throwable e) {
		super(msg, e);
	}
	
	public BadUserDetailsException(String msg) {
		super(msg);
	}
	
	public BadUserDetailsException(Throwable e) {
		super(e);
	}
	
	public BadUserDetailsException() {
		super();
	}
}
