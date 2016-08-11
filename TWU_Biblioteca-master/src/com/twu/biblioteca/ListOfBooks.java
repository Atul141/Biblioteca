package com.twu.biblioteca;

import IO.Output;

import java.util.List;

//
public class ListOfBooks implements ListOfMenuItem {

	private Output output;
	@Override
	public OutputString execute(Library library) {
	List<String> listOfBooks=library.printBookList();
		for(String book:listOfBooks){
			output.printMessage(book);
		}
		return OutputString.SUCCESSFULLY_RETURNED_LIST_OF_BOOKS;
	}

	@Override
	public String getOperations() {
		return "List Of Books";
	}
}
