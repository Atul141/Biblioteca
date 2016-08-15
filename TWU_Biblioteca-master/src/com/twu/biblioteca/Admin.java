package com.twu.biblioteca;

import javax.jws.soap.SOAPBinding;

// Represents the Library Admin
public class Admin extends User {

	public Admin(String userId, String password){
		super(userId,password);
	}
	public boolean authenticate(String userId,String password){
		return super.authenticate(userId,password);
	}
}
