package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Reader;
import IO.Writer;

import java.util.HashMap;

//

public class Menu {

	private ConsoleReader consoleReader;

	public Menu(ConsoleReader consoleReader, Library library) {


		this.consoleReader = consoleReader;
	}

	public OperationStatus preLoginMenu(Library library, int userChoice) throws ItemNotFound {
		HashMap<Integer, MenuItem> menuItems = new HashMap<Integer, MenuItem>();
		menuItems.put(1, new Items(Library.Type.BOOK));
		menuItems.put(2, new Items(Library.Type.MOVIE));
		menuItems.put(4, new UserLogin(library,this));
		menuItems.put(3, new ReturnBook(consoleReader));
		menuItems.put(5, new Exit());
		if (menuItems.containsKey(userChoice)) {
			MenuItem listableMenu = menuItems.get(userChoice);
			return listableMenu.execute(library);
		}
		return OperationStatus.INVALID_OPERATION;
	}

	public OperationStatus postLoginMenu(Library library) throws ItemNotFound {
		HashMap<Integer, MenuItem> menuItems = new HashMap<Integer, MenuItem>();
		menuItems.put(1, new Items(Library.Type.BOOK));
		menuItems.put(2, new Items(Library.Type.MOVIE));
		menuItems.put(3, new CheckOutBooks(consoleReader));
		menuItems.put(4, new CheckOutMovies(consoleReader));
		menuItems.put(5, new ReturnBook(consoleReader));
		menuItems.put(6, new userLogout(consoleReader,this));
		menuItems.put(7, new Exit());
		int userChoice = getUserChoiceForPostLoginMenu();
		if (menuItems.containsKey(userChoice)) {
			MenuItem listableMenu = menuItems.get(userChoice);
			return listableMenu.execute(library);
		}
		return OperationStatus.INVALID_OPERATION;
	}


	public String getMenu() {

		return "1.List OF Books\n2.List Of Movie\n3.Return\n4.Login\n5.Exit";
	}

	public int getUserChoiceForPostLoginMenu() {
		return consoleReader.receiveInput();
	}

	public String getPostLoginMenu() {
		return "1.List OF Books\n2.List Of Movie\n3.Checkout Book\n4.Checkout Movie\n5.Return Item\n6.Logout\n7.Exit";
	}
}
