package com.twu.biblioteca;

import IO.Writer;

import java.util.List;

// Prints The List OF Books
public class ListOfBooks implements ListOfMenuItem {

	@Override
	public OperationStatus execute(LibraryItem library) {
		 Writer writer =new Writer();

	List<String> listOfBooks=library.printBookList(LibraryItem.Type.BOOK);
		writer.printMessage("ISBN NAME           AUTHOR         YEAR ");
		for(String book:listOfBooks){
			writer.printMessage(book);
		}
		return OperationStatus.SUCCESSFULLY_RETURNED_LIST_OF_BOOKS;
	}

}
