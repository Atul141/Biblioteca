package com.twu.biblioteca;

// Represents a Book
public class Book implements Item{

	private final int ISBN;
	private final String name;
	private final String author;
	private final int yearOfPublish;

	public Book(int ISBN, String name, String author, int yearOfPublish) {
		this.ISBN = ISBN;
		this.name = name;
		this.author = author;
		this.yearOfPublish = yearOfPublish;
	}

	public String getDetails() {

		return String.format("%-5d%-15s%-15s%-5d\n", ISBN, name, author, yearOfPublish);
	}

	@Override
	public String[] getDetailsForDB() {
		String bookDetails=ISBN+" "+name+" "+author+" "+yearOfPublish;
		return bookDetails.split(" ");
	}

	@Override
	public String toString() {
		return name;
	}
}
