package com.twu.biblioteca;

//
public enum OperationStatus {

	WELCOME("Welcome"),INVALID_OPERATION("Select a valid option"),
	SUCCESSFULLY_RETURNED_LIST_OF_BOOKS(""), QUIT("Thanks For Using"),
	SUCCESSFUL_CHECKOUT("Thank you! Enjoy the book"),
	UNSUCCESSFUL_CHECKOUT("This book is not available"),
	UNSUCCESSFUL_RETURN("That is not a valid book to return."),
	SUCCESSFUL_RETURN("Thank you for returning the book");

	private String message;

	OperationStatus(String message) {

		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}
