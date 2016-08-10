package com.twu.biblioteca;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Parses the input file
public class parseInput {

	Map<Integer, Book> mapOfBooks = new HashMap<Integer, Book>();

	public Map<Integer, Book> createMapOfBooks(List<String> listOfBooks) {
		for (String bookString : listOfBooks) {
			String[] bookDetails = bookString.split(",");
			int ISBN = Integer.parseInt(bookDetails[0]);
			int year = Integer.parseInt(bookDetails[3]);
			String bookName = bookDetails[1];
			String authorName = bookDetails[2];
			mapOfBooks.put(ISBN, new Book(ISBN, bookName, authorName, year));
		}
		return mapOfBooks;
	}

}
