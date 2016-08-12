package com.twu.biblioteca;


public interface MenuItem {

	OperationStatus execute(Library library) throws ItemNotFound;
}
