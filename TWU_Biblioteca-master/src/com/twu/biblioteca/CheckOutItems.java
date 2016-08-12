package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Writer;

// Checks Out a Book
public class CheckOutItems implements MenuItem {

	private ConsoleReader consoleReader;

	CheckOutItems(ConsoleReader consoleReader) {

		this.consoleReader = consoleReader;
	}

	@Override
	public OperationStatus execute(Library library) throws ItemNotFound {
		Library.Type type;
		Writer writer = new Writer();
		writer.printMessage("1.Books\n2.Movies");
		int option = consoleReader.receiveInput();
		if (option == 1)
			type = Library.Type.BOOK;
		else
			type = Library.Type.MOVIE;
		new Items(type);
		writer.printMessage(" Enter ID Number");
		int bookID = consoleReader.receiveInput();
		return execute(library, bookID, type);
	}

	public OperationStatus execute(Library library, int ID, Library.Type type) throws ItemNotFound {
		boolean isSuccess = false;
		if (type == Library.Type.BOOK) {
			if ((library.checkout(ID).getClass()) == Book.class)
				isSuccess = true;
		} else {
			if ((library.checkout(ID).getClass()) == Movie.class)
				isSuccess = true;
		}
		if (isSuccess)
			return OperationStatus.SUCCESSFUL_CHECKOUT;
		return OperationStatus.UNSUCCESSFUL_CHECKOUT;


	}
}