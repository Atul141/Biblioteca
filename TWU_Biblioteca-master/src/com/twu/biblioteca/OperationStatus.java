package com.twu.biblioteca;

//
public enum OperationStatus {

	WELCOME("Welcome"),INVALID_OPERATION("Select a valid option"),
	SUCCESSFULLY_RETURNED(""), QUIT("Thanks For Using"),
	SUCCESSFUL_CHECKOUT("Thank you! Enjoy the Library Item"),
	UNSUCCESSFUL_CHECKOUT("This item is not available"),
	UNSUCCESSFUL_RETURN("That is not a valid Library Item to return."),
	SUCCESSFUL_LOGIN(""),
	SUCCESSFUL_LOGOUT(""),
	SUCCESSFUL_DISPLAY(""),
	SUCCESSFUL_RETURN("Thank you for returning the item");

	public String message;

	 OperationStatus(String message) {

		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}
