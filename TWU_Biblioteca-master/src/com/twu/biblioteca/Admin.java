package com.twu.biblioteca;

// Represents the Library Admin

public class Admin implements Accounts {

	private String userId;
	private String password;

	public Admin(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public boolean authenticate(String userId, String password) {
		return new User(this.userId, this.password).authenticate(userId, password);
	}

}
