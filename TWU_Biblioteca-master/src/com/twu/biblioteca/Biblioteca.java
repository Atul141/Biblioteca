package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

// Represents the I/O operations
public class Biblioteca {

Library library=new Library();
List<String > listOfBooks=new ArrayList<String>();
	public void welcomeMessage(){
		library.getWelcomeMessage();
	}
	public void printBookList(){
		System.out.format("ISBN Book Name      Author         Year\n");
		listOfBooks=		library.printBookList();
	for(String bookDetails:listOfBooks){
		printMessage(bookDetails);
	}
	}

	private void printMessage(String bookDetails) {
	System.out.println(bookDetails);

	}
}
