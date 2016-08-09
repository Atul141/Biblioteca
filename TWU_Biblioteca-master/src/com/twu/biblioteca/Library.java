package com.twu.biblioteca;

import java.util.*;

// Represents the collections of book
public class Library {

	Map<Integer, Book> availableBooks = new HashMap<Integer, Book>();
	Map<Integer, Book> checkoutBooks = new HashMap<Integer, Book>();

	public Library() {

	}

	public String getWelcomeMessage() {
		return "Welcome";
	}

	public Library(Map<Integer,Book> availableBooks) {
		this.availableBooks=availableBooks;
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
