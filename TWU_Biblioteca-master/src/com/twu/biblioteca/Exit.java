package com.twu.biblioteca;

import IO.Writer;

//Exit from the program
public class Exit implements ListOfMenuItem {
	@Override
	public OperationStatus execute(LibraryItem library) {
		OperationStatus operationStatus=OperationStatus.QUIT;
		new Writer().printMessage(operationStatus.getMessage());
		return operationStatus;
	}


}
