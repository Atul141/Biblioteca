package com.twu.biblioteca;

import IO.ConsoleReader;

//
public class CheckOutMovies implements MenuItem {
	private ConsoleReader consoleReader;

	public CheckOutMovies(ConsoleReader consoleReader) {
		this.consoleReader = consoleReader;
	}

	@Override
	public OperationStatus execute(Library library) throws ItemNotFound {
		int bookID = consoleReader.receiveInput();
		return execute(library, bookID);
	}

	public OperationStatus execute(Library library, int ID) throws ItemNotFound {
		if ((library.checkout(ID,new User("0000","Hello")).getClass()) == Movie.class)
			return OperationStatus.SUCCESSFUL_CHECKOUT;
		return OperationStatus.UNSUCCESSFUL_CHECKOUT;

	}
}