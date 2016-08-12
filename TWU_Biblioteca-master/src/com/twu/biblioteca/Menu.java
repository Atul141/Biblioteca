package com.twu.biblioteca;

import IO.ConsoleReader;

import java.util.HashMap;

//

public class Menu {

	HashMap<Integer, ListOfMenuItem> menuItems = new HashMap<Integer, ListOfMenuItem>();

	public Menu(ConsoleReader consoleReader) {

		menuItems.put(1, new ListOfItems(LibraryItem.Type.BOOK));
		menuItems.put(2,new ListOfItems(LibraryItem.Type.MOVIE));
		menuItems.put(3, new CheckOutItems(consoleReader));
		menuItems.put(4, new ReturnBook(consoleReader));
		menuItems.put(5, new Exit());
	}

	public OperationStatus performOperation(LibraryItem library, int userChoice) throws BookNotFoundExemption {
		if (menuItems.containsKey(userChoice)) {
			ListOfMenuItem listableMenu = menuItems.get(userChoice);
			return listableMenu.execute(library);
		}
		return OperationStatus.INVALID_OPERATION;
	}

	public String getMenu(){

		return "1.List OF Books\n2.List Of Movie\n3.Checkout\n4.Return\n5.Exit";
	}

}
