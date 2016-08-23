package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Writer;

import static com.twu.biblioteca.OperationStatus.*;

//
public class ReturnItem implements MenuItem {
	private ConsoleReader consoleReader;

	public ReturnItem(ConsoleReader consoleReader) {
		this.consoleReader = consoleReader;
	}

	@Override
	public OperationStatus execute(Library library) throws ItemNotFound {
		Writer writer=new Writer();
		writer.printMessage("Enter ID");
		int bookID= consoleReader.receiveInput();
		return execute(library,bookID);
	}

	public OperationStatus execute(Library library, int bookID) throws ItemNotFound {
		boolean success=false;
		try {success=library.returnBook(bookID).getClass() == Book.class;
		}catch (ItemNotFound e){
		}
		if(success)
		return SUCCESSFUL_RETURN;
		return UNSUCCESSFUL_RETURN;
	}

}
