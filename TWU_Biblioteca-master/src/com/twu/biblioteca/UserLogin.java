package com.twu.biblioteca;

import IO.Writer;
import IO.Reader;

import java.util.HashMap;
import java.util.Map;

//
public class UserLogin implements MenuItem {

	private Writer writer = new Writer();
	private Reader reader = new Reader();
	private Library library;
	private Menu menu;
	private final Map<Accounts, Character> accounts = new HashMap<Accounts, Character>();

	public UserLogin(Library library, Menu menu) {
		this.library = library;
		this.menu = menu;
		addAccounts();
	}

	private void addAccounts() {
		User user1 = new User("0000", "Hello");
		User user2 = new User("1111", "Hello");
		accounts.put(user1, 'u');
		accounts.put(user2, 'u');
		accounts.put(new Admin("1010", "****"), 'a');
		accounts.put(new Admin("0101", "****"), 'a');
		user1.addDetails("Alpha", "alpha@gmail.com", "1800");
		user2.addDetails("Beta", "beta@gmail.com", "1801");
	}

	boolean authenticatePassword(String userId, String password) throws ItemNotFound {
		boolean isPresent = false;
		for (Accounts user : accounts.keySet()) {
			if (user.authenticate(userId, password)) {
				isPresent = true;
				if (accounts.get(user) == 'a')
					invokeAdminMenu((User) user);
				else
					invokeUserMenu((User) user);
			}
		}
		if (!(isPresent))
			wrongPassword();
		return isPresent;
	}

	private void wrongPassword() {
		writer.printMessage("Wrong password");
		System.exit(0);
	}

	private void invokeAdminMenu(User user) throws ItemNotFound {
		BibliotecaApp.adminLoginOperations(writer, library, menu, user);
	}

	private void invokeUserMenu(User user) throws ItemNotFound {
		BibliotecaApp.postLoginOperations(writer, library, menu, user);
	}

	@Override
	public OperationStatus execute(Library library) throws ItemNotFound {

		writer.printMessage("Enter your User Id");
		String userId = reader.receiveString();
		writer.printMessage("Enter your Password");
		String password = reader.receiveString();
		authenticatePassword(userId, password);
		System.exit(0);
		return OperationStatus.SUCCESSFUL_LOGIN;
	}
}
