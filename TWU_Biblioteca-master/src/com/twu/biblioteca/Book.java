package com.twu.biblioteca;

// Represents a Book
public class Book {

private final int ISBN;
public final String name;
private final String author;
private final int yearOfPublish;

public Book(int ISBN, String name, String author, int yearOfPublish){
	this.ISBN=ISBN;
	this.name=name;
	this.author=author;
	this.yearOfPublish=yearOfPublish;
}
public String printBookDetails(){
return 	String.format("%-5d%-15s%-15s%-5d\n", ISBN, name, author,yearOfPublish);
}

}
