package com.twu.biblioteca;

//
public enum OutputString {

	WELCOME("Welcome"),INVALID_OPERATION("Select a valid option"),
	SUCCESSFULLY_RETURNED_LIST_OF_BOOKS(""), QUIT(""),
	SUCCESSFUL_CHECKOUT("Thank you! Enjoy the book"),
	UNSUCCESSFUL_CHECKOUT("This book is not available"),
	UNSUCCESSFUL_RETURN("That is not a valid book to return."),
	SUCCESSFUL_RETURN("Thank you for returning the book");

	private String message;

	OutputString(String message) {

		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}
