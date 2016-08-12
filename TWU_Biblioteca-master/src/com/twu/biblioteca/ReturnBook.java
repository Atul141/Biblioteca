package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Writer;

import static com.twu.biblioteca.OperationStatus.*;

//
public class ReturnBook implements ListOfMenuItem {
	private ConsoleReader consoleReader;

	public ReturnBook(ConsoleReader consoleReader) {
		this.consoleReader = consoleReader;
	}

	@Override
	public OperationStatus execute(LibraryItem library) throws BookNotFoundExemption {
		new Writer().printMessage("Enter ISBN");
		int bookID= consoleReader.receiveInput();
		return execute(library,bookID);
	}

	public OperationStatus execute(LibraryItem library, int bookID) throws BookNotFoundExemption {
		if (library.returnBook(bookID).getClass()==Book.class)
			return SUCCESSFUL_RETURN;
		return UNSUCCESSFUL_RETURN;
	}

}
