package com.twu.biblioteca;

import IO.Reader;
import IO.Writer;
//
public class ReturnBook implements ListOfMenuItem {
	private Reader reader;

	public ReturnBook(Reader reader) {
		this.reader = reader;
	}

	@Override
	public OperationStatus execute(Library library) throws BookNotFoundExemption {
		new Writer().printMessage("Enter ISBN");
		int bookID=reader.receiveInput();
		return execute(library,bookID);
	}

	public OperationStatus execute(Library library, int bookID) throws BookNotFoundExemption {
		if(library.returnBook(bookID).getClass()==Book.class)
			return OperationStatus.SUCCESSFUL_RETURN;
		return OperationStatus.UNSUCCESSFUL_RETURN;
	}

}
