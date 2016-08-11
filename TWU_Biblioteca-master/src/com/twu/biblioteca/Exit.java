package com.twu.biblioteca;

//
public class Exit implements ListOfMenuItem {
	@Override
	public OutputString execute(Library library) {
		return OutputString.QUIT;
	}

	@Override
	public String getOperations() {
		return "Exit";
	}
}
