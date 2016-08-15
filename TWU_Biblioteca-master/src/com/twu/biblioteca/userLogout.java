package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Writer;

// Logs out User
public class userLogout implements MenuItem {
	private ConsoleReader consoleReader;
	private Menu menu;

	public userLogout(ConsoleReader consoleReader,Menu menu) {
		this.consoleReader = consoleReader;
		this.menu = menu;
	}

	@Override
	public OperationStatus execute(Library library) throws ItemNotFound {
		BibliotecaApp.preLoginOperations(new Writer(),library,menu);
		return OperationStatus.SUCCESSFUL_LOGOUT;
	}
}
