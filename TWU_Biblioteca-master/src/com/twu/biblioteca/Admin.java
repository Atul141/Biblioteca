package com.twu.biblioteca;

import javax.jws.soap.SOAPBinding;

// Represents the Library Admin
public class Admin implements Accounts {

	private String userId;
	private String password;

	public Admin(String userId, String password){
		this.userId = userId;
		this.password = password;
	}
	public boolean authenticate(String userId,String password){
		System.out.println(userId+password);
		return new User(this.userId,this.password).authenticate(userId,password);
	}

}
