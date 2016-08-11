package com.twu.biblioteca;

import IO.Reader;
import IO.Writer;

// Checks Out a Book
public class CheckOutBook implements ListOfMenuItem {

	private Reader reader;
	CheckOutBook(Reader reader) {

		this.reader = reader;
	}
	@Override
	public OperationStatus execute(Library library) throws BookNotFoundExemption {
		new ListOfBooks().execute(library);
		new Writer().printMessage(" Enter ISBN Number");
		int bookID = reader.receiveInput();
		return execute(library, bookID);
	}

	public OperationStatus execute(Library library, int bookID) throws BookNotFoundExemption {
		if ((library.checkout(bookID).getClass()) == Book.class)
			return OperationStatus.SUCCESSFUL_CHECKOUT;
		return OperationStatus.UNSUCCESSFUL_CHECKOUT;
	}


}
