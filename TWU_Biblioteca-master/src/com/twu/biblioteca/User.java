package com.twu.biblioteca;

// Represents a user
public class User {

	private String userID;
	private String password;

	public User(String userID, String password ){

		this.userID = userID;
		this.password = password;
	}
	public boolean authenticate(String userId,String password){

		return userId.equals(this.userID)&&password.equals(this.password);
	}
}
