package com.twu.biblioteca;


public interface ListOfMenuItem {

	OperationStatus execute(LibraryItem library) throws BookNotFoundExemption;
}
