package com.alex.store.security;

public class BadUserDetails extends RuntimeException {

	private static final long serialVersionUID = 9056650388889852211L;

	public BadUserDetails(String msg, Throwable e) {
		super(msg, e);
	}
	
	public BadUserDetails(String msg) {
		super(msg);
	}
	
	public BadUserDetails(Throwable e) {
		super(e);
	}
	
	public BadUserDetails() {
		super();
	}
}
