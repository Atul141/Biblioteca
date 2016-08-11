package com.twu.biblioteca;

import IO.Reader;

import java.util.HashMap;

//

public class Menu {

	HashMap<Integer, ListOfMenuItem> menuItems = new HashMap<Integer, ListOfMenuItem>();

	public Menu(Reader reader) {

		menuItems.put(1, new ListOfBooks());
		menuItems.put(2, new CheckOutBook(reader));
		menuItems.put(3, new ReturnBook(reader));
		menuItems.put(4, new Exit());
	}

	public OperationStatus performOperation(Library library, int userChoice) throws BookNotFoundExemption {
		if (menuItems.containsKey(userChoice)) {
			ListOfMenuItem listableMenu = menuItems.get(userChoice);
			return listableMenu.execute(library);
		}
		return OperationStatus.INVALID_OPERATION;
	}

	public String getMenu(){
		return "1.List OF Books\n2.CheckoutBooks\n3.Return Book\n4.Exit";
	}

}
