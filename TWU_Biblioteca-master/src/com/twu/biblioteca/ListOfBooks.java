package com.twu.biblioteca;

import IO.Output;

import java.util.List;

//
public class ListOfBooks implements ListOfMenuItem {

	private Output output=new Output();
	@Override
	public OperationStatus execute(Library library) {
	List<String> listOfBooks=library.printBookList();
		for(String book:listOfBooks){
			output.printMessage(book);
		}
		return OperationStatus.SUCCESSFULLY_RETURNED_LIST_OF_BOOKS;
	}

}
