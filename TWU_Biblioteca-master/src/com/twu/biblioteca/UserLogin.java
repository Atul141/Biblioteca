package com.twu.biblioteca;

import  IO.Writer;
import IO.Reader;

import java.util.ArrayList;
import java.util.List;

//
public class UserLogin implements MenuItem {

	private Writer writer=new Writer();
	private Reader reader=new Reader();
	private Library library;
	private Menu menu;
	private final List<User> users=new ArrayList<User>();

	public UserLogin(Library library,Menu menu){
		this.library = library;
		this.menu = menu;
		addUsers();
	}

	private void addUsers() {
		users.add(new User("0000","Hello"));
		users.add(new User("1111","Hello"));
	}

	boolean authenticatePassword(String  userId,String password) throws ItemNotFound {
		boolean isPresent=false;
		for(User user:users) {
			if (user.authenticate(userId,password)) {
				isPresent = true;
				}
		}
		if(isPresent) {
			BibliotecaApp.postLoginOperations(writer,library,menu,new User(userId,password));
		}else{
			writer.printMessage("Wrong password");
			System.exit(0);
		}
	return isPresent;
	}

	@Override
	public OperationStatus execute(Library library) throws ItemNotFound {

			writer.printMessage("Enter your User Id");
			String userId=reader.receiveString();
		writer.printMessage("Enter your Password");
		String password = reader.receiveString();
					authenticatePassword(userId,password);
				System.exit(0);
		return OperationStatus.SUCCESSFUL_LOGIN;
	}
}
