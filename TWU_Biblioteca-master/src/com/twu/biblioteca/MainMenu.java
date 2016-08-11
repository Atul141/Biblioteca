package com.twu.biblioteca;

import IO.Reader;

import java.util.HashMap;

//
public class MainMenu {
	HashMap<Integer, ListOfMenuItem> menuItems = new HashMap<Integer, ListOfMenuItem>();

	public MainMenu(Reader reader) {

		menuItems.put(1, new ListOfBooks());
		menuItems.put(2, new CheckOutBook(reader));
		menuItems.put(3, new ReturnBook(reader));
		menuItems.put(4, new Exit());
	}

	public OutputString performOperation(Library library, int userChoice) {
		if (menuItems.containsKey(userChoice)) {
			ListOfMenuItem listableMenu = menuItems.get(userChoice);
			return listableMenu.execute(library);
		}
		return OutputString.INVALID_OPERATION;
	}


}
