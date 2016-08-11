package com.twu.biblioteca;

import java.util.*;

// Represents the collections of book
public class Library {

	Map<Integer, Book> availableBooks = new HashMap<Integer, Book>();
	Map<Integer, Book> checkoutBooks = new HashMap<Integer, Book>();
	private Menu menu;


	public OperationStatus getWelcomeMessage() {
		return OperationStatus.WELCOME;
	}

	public Library(Menu menu, Map<Integer, Book> availableBooks) {
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

	public Book checkout(int ISBN) throws BookNotFoundExemption {
		if (availableBooks.containsKey(ISBN)) {
			Book book = availableBooks.remove(ISBN);
			checkoutBooks.put(ISBN, book);
			return book;
		}
		throw new BookNotFoundExemption();
	}

	public Book returnBook(int ISBN) throws BookNotFoundExemption {
		if (checkoutBooks.containsKey(ISBN)) {
			Book book = checkoutBooks.remove(ISBN);
			availableBooks.put(ISBN, book);

			return book;
		}
		throw new BookNotFoundExemption();
	}


}
