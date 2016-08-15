package com.twu.biblioteca;

import  IO.Writer;
import IO.Reader;
import java.util.HashMap;
import java.util.Map;

//
public class UserLogin implements MenuItem {

	private Writer writer=new Writer();
	private Reader reader=new Reader();
	private Library library;
	private Menu menu;
	private final Map<Accounts,Character> accounts =new HashMap<Accounts,Character>();

	public UserLogin(Library library,Menu menu){
		this.library = library;
		this.menu = menu;
		addAccounts();
	}

	private void addAccounts() {
	accounts.put(new User("0000","Hello"),'u');
	accounts.put(new User("1111","Hello"),'u');
	accounts.put(new Admin("1010","****"),'a');
	accounts.put(new Admin("0101","****"),'a');
	}

	boolean authenticatePassword(String  userId,String password) throws ItemNotFound {
		boolean isPresent=false,isAdmin=false;

		for(Accounts user:accounts.keySet()) {
			if (user.authenticate(userId,password)) {
				isPresent = true;
				if(accounts.get(user)=='a')
					isAdmin=true;
				}
		}
		if(isPresent) {
			if(isAdmin)
			BibliotecaApp.adminLoginOperations(writer,library,menu,new User(userId,password));
			else
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
