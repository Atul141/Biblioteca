package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Writer;

import java.util.Map;

// To check who has checked out books

public class TrackCheckOutBooks implements MenuItem {
	public TrackCheckOutBooks() {
	}

	@Override
	public OperationStatus execute(Library library) throws ItemNotFound {
		Writer writer = new Writer();
		Map<Book, User> checkoutBooksDetails = library.getCheckedOutbooks();
		for (Map.Entry<Book, User> entry : checkoutBooksDetails.entrySet()) {
			writer.printMessage("Book =" + entry.getKey().toString() + "\tUserId=" + entry.getValue().toString());
		}
		return OperationStatus.SUCCESSFULLY_RETURNED;
	}
}
