package com.twu.biblioteca;

import IO.Writer;

import java.util.List;

// Prints The List OF Books
public class ListOfItems implements ListOfMenuItem {

	private LibraryItem.Type type;

	ListOfItems(LibraryItem.Type type) {

		this.type = type;
	}

	@Override
	public OperationStatus execute(LibraryItem library) {
		Writer writer = new Writer();
		List<String> listOfBooks = library.printBookList(type);
		if (type == LibraryItem.Type.BOOK) {

			writer.printMessage("ISBN NAME           AUTHOR         YEAR ");
			for (String book : listOfBooks) {
				writer.printMessage(book);
			}
			return OperationStatus.SUCCESSFULLY_RETURNED;
		} else {
			writer.printMessage("ID   NAME                     DIRECTOR                 YEAR RATING");
			for (String movie : listOfBooks) {
				writer.printMessage(movie);
			}
		}
			return OperationStatus.SUCCESSFULLY_RETURNED;
	}
}