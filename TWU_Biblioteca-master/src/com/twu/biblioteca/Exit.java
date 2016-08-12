package com.twu.biblioteca;

import IO.Writer;

//Exit from the program
public class Exit implements MenuItem {
	@Override
	public OperationStatus execute(Library library) {
		OperationStatus operationStatus=OperationStatus.QUIT;
		new Writer().printMessage(operationStatus.getMessage());
		return operationStatus;
	}


}
