package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

// Represents the collections of book
public class Library {

	List<Book> listOFBooks= new ArrayList<Book>();
	List<String> bookDetails=new ArrayList<String>();

	public String getWelcomeMessage(){
		return "Welcome";
	}

	public void addBooks(){
		Book book1=new Book(1,"Java","Malik",2010);
		Book book2=new Book(2,"Nancy Drew","Carolyn Keene",2008);
		Book book3=new Book(3,"Artemis Fowl","Eoin Colfer",2005);
		listOFBooks.add(book1);
		listOFBooks.add(book2);
		listOFBooks.add(book3);
	}

	public Library() {

		addBooks();
	}


	public List<String> printBookList() {

		for (Book book : listOFBooks) {
			bookDetails.add(book.printBookDetails());
		}
		return bookDetails;
	}
}
