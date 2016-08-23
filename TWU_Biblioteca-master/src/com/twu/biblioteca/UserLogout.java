package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Writer;

// Logs out User
public class UserLogout implements MenuItem {
	private Menu menu;

	public UserLogout(Menu menu) {
		this.menu = menu;
	}

	@Override
	public OperationStatus execute(Library library) throws ItemNotFound {
		menu.preLoginMenu();
		return OperationStatus.SUCCESSFUL_LOGOUT;
	}
}
