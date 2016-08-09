package com.twu.biblioteca;

import java.util.*;

// Represents the collections of book
public class Library {

	Map<Integer, Book> availableBooks = new HashMap<Integer, Book>();
	Map<Integer, Book> checkoutBooks = new HashMap<Integer, Book>();

	public String getWelcomeMessage() {
		return "Welcome";
	}

	public void addBooks() {


		Book book1 = new Book(1, "Java", "Malik", 2010);
		Book book2 = new Book(2, "Nancy Drew", "Carolyn Keene", 2008);
		Book book3 = new Book(3, "Artemis Fowl", "Eoin Colfer", 2005);
		availableBooks.put(1, book1);
		availableBooks.put(2, book2);
		availableBooks.put(3, book3);
	}

	public Library() {

		addBooks();
	}


	public List<String> printBookList() {

		List<String> bookDetails = new ArrayList<String>();
		for (Book book : availableBooks.values()) {
			bookDetails.add(book.printBookDetails());
		}
		return bookDetails;
	}

	public String checkout(int ISBN) {
		if (availableBooks.containsKey(ISBN)) {
			Book book = availableBooks.remove(ISBN);
			checkoutBooks.put(ISBN, book);
			return "Thank you! Enjoy the book";
		}
		return "That book is not available";
	}

	public String  returnBook(int ISBN) {
		if (checkoutBooks.containsKey(ISBN)) {
			Book book = checkoutBooks.remove(ISBN);
			availableBooks.put(ISBN, book);

			return "Thank you for returning the book";
		}
		return "That is not a valid book to return";
	}


}
