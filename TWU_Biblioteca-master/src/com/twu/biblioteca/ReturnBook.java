package com.twu.biblioteca;

import IO.Reader;

//
public class ReturnBook implements ListOfMenuItem {
	private Reader reader;

	public ReturnBook(Reader reader) {
		this.reader = reader;
	}

	@Override
	public OutputString execute(Library library) {
		int bookID=reader.receiveInput();
		return execute(library,bookID);
	}

	public OutputString execute(Library library, int bookID) {
		if(library.returnBook(bookID))
			return OutputString.SUCCESSFUL_RETURN;
		return OutputString.UNSUCCESSFUL_RETURN;
	}

	@Override
	public String getOperations() {
		return "Return Book";
	}
}
