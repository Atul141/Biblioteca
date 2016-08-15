package com.twu.biblioteca;

// Represents a user
public class User implements Accounts{

	private String userID;
	private String password;
	public String name;
	private String email;
	private String phoneNo;

	public User(String userID, String password ){

		this.userID = userID;
		this.password = password;
	}
	public boolean authenticate(String userId,String password){

		return userId.equals(this.userID)&&password.equals(this.password);
	}
	public String toString(){
		return userID;
	}

	public void addDetails(String name, String email, String phoneNo) {
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	public String getUserDetails(){
		return String.format("%-15s%-25s%-15s\n",name,email,phoneNo);

	}
}
