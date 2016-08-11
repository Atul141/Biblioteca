package com.twu.biblioteca;

import IO.Reader;

//
public class CheckOutBook implements ListOfMenuItem {

private Reader reader;
	CheckOutBook(Reader reader){

		this.reader = reader;
	}
	@Override
	public OutputString execute(Library library) {
		int bookID=reader.receiveInput();
		return execute(library,bookID);
	}
	public OutputString execute(Library library,int bookID){
		if(library.checkout(bookID))
			return OutputString.SUCCESSFUL_CHECKOUT;
		return OutputString.UNSUCCESSFUL_CHECKOUT;
	}

	@Override
	public String getOperations() {
		return null;
	}
}
