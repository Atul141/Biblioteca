package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Writer;

// Checks Out a Book
public class CheckOutBook implements ListOfMenuItem {

	private ConsoleReader consoleReader;
	CheckOutBook(ConsoleReader consoleReader) {

		this.consoleReader = consoleReader;
	}
	@Override
	public OperationStatus execute(LibraryItem library) throws BookNotFoundExemption {
		new ListOfBooks().execute(library);
		new Writer().printMessage(" Enter ISBN Number");
		int bookID = consoleReader.receiveInput();
		return execute(library, bookID);
	}

	public OperationStatus execute(LibraryItem library, int bookID) throws BookNotFoundExemption {
		if ((library.checkout(bookID).getClass()) == Item.class)
			return OperationStatus.SUCCESSFUL_CHECKOUT;
		return OperationStatus.UNSUCCESSFUL_CHECKOUT;
	}


}
