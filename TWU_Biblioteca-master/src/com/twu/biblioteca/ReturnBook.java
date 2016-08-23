package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Writer;

import static com.twu.biblioteca.OperationStatus.*;

//
public class ReturnBook implements MenuItem {
	private ConsoleReader consoleReader;

	public ReturnBook(ConsoleReader consoleReader) {
		this.consoleReader = consoleReader;
	}

	@Override
	public OperationStatus execute(Library library) throws ItemNotFound {
		Writer writer=new Writer();
		writer.printMessage("Enter ID");
		int bookID= consoleReader.receiveInput();
		return execute(library,bookID);
	}

	public OperationStatus execute(Library library, int bookID) throws ItemNotFound {
		if (library.returnBook(bookID).getClass()==Book.class)
			return SUCCESSFUL_RETURN;
		return UNSUCCESSFUL_RETURN;
	}

}
