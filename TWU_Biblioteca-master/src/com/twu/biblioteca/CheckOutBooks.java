package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Writer;

// Checks Out a Book
public class CheckOutBooks implements MenuItem {

	private ConsoleReader consoleReader;
	private User user;

	CheckOutBooks(ConsoleReader consoleReader,User user) {

		this.consoleReader = consoleReader;
		this.user = user;
	}

	@Override
	public OperationStatus execute(Library library) throws ItemNotFound {
			new Writer().printMessage(" Enter ID Number");
		int bookID = consoleReader.receiveInput();
			return execute(library, bookID);
	}
	public OperationStatus execute(Library library, int ID) throws ItemNotFound {
		if ((library.checkout(ID,user).getClass()) == Book.class)
			return OperationStatus.SUCCESSFUL_CHECKOUT;
		return OperationStatus.UNSUCCESSFUL_CHECKOUT;
	}
}