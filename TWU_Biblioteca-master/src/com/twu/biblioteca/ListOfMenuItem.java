package com.twu.biblioteca;


public interface ListOfMenuItem {

	OperationStatus execute(Library library) throws BookNotFoundExemption;
}
