package com.alex.store.user;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -307470961180765352L;

	public UserNotFoundException(String msg, Throwable e) {
		super(msg, e);
	}
	
	public UserNotFoundException(Throwable e) {
		super(e);
	}
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
	
	public UserNotFoundException() {
		super();
	}
	
}
