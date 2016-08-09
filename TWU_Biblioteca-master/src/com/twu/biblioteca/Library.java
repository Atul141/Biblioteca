package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

// Represents the collections of book
public class Library {

	List<Book> checkoutBooks= new ArrayList<Book>();
	List<Book> availableBooks = new ArrayList<Book>();

	public String getWelcomeMessage(){
		return "Welcome";
	}

	public void addBooks(){
		Book book1=new Book(1,"Java","Malik",2010);
		Book book2=new Book(2,"Nancy Drew","Carolyn Keene",2008);
		Book book3=new Book(3,"Artemis Fowl","Eoin Colfer",2005);
		availableBooks.add(book1);
		availableBooks.add(book2);
		availableBooks.add(book3);
	}

	public Library() {

		addBooks();
	}


	public List<String> printBookList() {

		List<String> bookDetails=new ArrayList<String>();
		for (Book book : availableBooks) {
			bookDetails.add(book.printBookDetails());
		}
		return bookDetails;
	}

	public void checkout(int ISBN) {
		for(Book book:availableBooks){
			if(book.contains(ISBN))
			{
			availableBooks.remove(book);
				checkoutBooks.add(book);
			}
		}

	}
}
