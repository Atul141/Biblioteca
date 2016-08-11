package com.twu.biblioteca;

import java.util.*;

// Represents the collections of book
public class Library {

	private Menu menu;
	Map<Integer, Book> availableBooks = new HashMap<Integer, Book>();
	Map<Integer, Book> checkoutBooks = new HashMap<Integer, Book>();



	public OutputString getWelcomeMessage() {
		return OutputString.WELCOME;
	}

	public Library(Menu menu,Map<Integer, Book> availableBooks) {
		this.menu = menu;

		this.availableBooks = availableBooks;
	}

	public List<String> printBookList() {

		List<String> bookDetails = new ArrayList<String>();
		for (Book book : availableBooks.values()) {
			bookDetails.add(book.getBookDetails());
		}
		return bookDetails;
	}

	public boolean checkout(int ISBN) {
		if (availableBooks.containsKey(ISBN)) {
			Book book = availableBooks.remove(ISBN);
			checkoutBooks.put(ISBN, book);
			return true;
		}
		return false;
	}

	public boolean returnBook(int ISBN) {
		if (checkoutBooks.containsKey(ISBN)) {
			Book book = checkoutBooks.remove(ISBN);
			availableBooks.put(ISBN, book);

			return true;
		}
		return false;
	}


}
