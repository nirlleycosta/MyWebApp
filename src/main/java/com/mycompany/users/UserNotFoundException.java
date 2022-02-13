package com.mycompany.users;

@SuppressWarnings("serial")
public class UserNotFoundException extends Throwable {
	public UserNotFoundException(String message) {
		super(message);
	}
}
