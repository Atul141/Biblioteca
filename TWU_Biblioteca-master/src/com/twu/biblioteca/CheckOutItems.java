package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Writer;

// Checks Out a Book
public class CheckOutItems implements ListOfMenuItem {

	private ConsoleReader consoleReader;
	CheckOutItems(ConsoleReader consoleReader) {

		this.consoleReader = consoleReader;
	}
	@Override
	public OperationStatus execute(LibraryItem library) throws BookNotFoundExemption {
		Writer writer=new Writer();
		writer.printMessage("1.Books\n2.Movies");
		int option=consoleReader.receiveInput();
		if(option==1)
		new ListOfItems(LibraryItem.Type.BOOK).execute(library);
		else
			new ListOfItems(LibraryItem.Type.MOVIE);
		writer.printMessage(" Enter ID Number");
		int bookID = consoleReader.receiveInput();
		return execute(library, bookID);
	}

	public OperationStatus execute(LibraryItem library, int bookID) throws BookNotFoundExemption {
		if ((library.checkout(bookID).getClass()) == Item.class)
			return OperationStatus.SUCCESSFUL_CHECKOUT;
		return OperationStatus.UNSUCCESSFUL_CHECKOUT;
	}


}
