package com.twu.biblioteca;

//
public class Exit implements ListOfMenuItem {
	@Override
	public OperationStatus execute(Library library) {

		return OperationStatus.QUIT;
	}


}
