package com.twu.biblioteca;

import IO.ConsoleReader;

import java.util.HashMap;

//

public class Menu {

	private final ConsoleReader consoleReader;

	public Menu(ConsoleReader consoleReader) {


		this.consoleReader = consoleReader;
	}

	public OperationStatus preLoginMenu(Library library, int userChoice) throws ItemNotFound {
		HashMap<Integer, MenuItem> menuItems = new HashMap<Integer, MenuItem>();
		menuItems.put(1, new Items(Library.Type.BOOK));
		menuItems.put(2,new Items(Library.Type.MOVIE));
		menuItems.put(4, new UserLogin());
		menuItems.put(3, new ReturnBook(consoleReader));
		menuItems.put(5, new Exit());
		if (menuItems.containsKey(userChoice)) {
			MenuItem listableMenu = menuItems.get(userChoice);
			return listableMenu.execute(library);
		}
		return OperationStatus.INVALID_OPERATION;
	}


	public String getMenu(){

		return "1.List OF Books\n2.List Of Movie\n3.Checkout\n4.Return\n5.Exit";
	}

}
