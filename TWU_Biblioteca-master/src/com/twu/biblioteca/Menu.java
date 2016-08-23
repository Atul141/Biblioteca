package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Reader;
import IO.Writer;

import java.util.HashMap;

//

public class Menu {

	private ConsoleReader consoleReader;
	private Library library;
	private Writer writer=new Writer();

	public Menu(ConsoleReader consoleReader, Library library) {

		this.consoleReader = consoleReader;
		this.library = library;
	}

	public void preLoginMenu() throws ItemNotFound {
		OperationStatus operationStatus=null;
		while (operationStatus!=OperationStatus.QUIT){
			writer.printMessage(getMenu());
			int userChoice=getUserChoice();
		HashMap<Integer, MenuItem> menuItems = new HashMap<Integer, MenuItem>();
		menuItems.put(1, new DisplayItems(Library.Type.BOOK));
		menuItems.put(2, new DisplayItems(Library.Type.MOVIE));
		menuItems.put(4, new UserLogin(library,this));
		menuItems.put(3, new ReturnItem(consoleReader));
		menuItems.put(5, new Exit());
		if (menuItems.containsKey(userChoice)) {
			MenuItem listableMenu = menuItems.get(userChoice);
			operationStatus= listableMenu.execute(library);
			writer.printMessage(operationStatus.getMessage());
		}
	else 	writer.printMessage("Invalid Input");

		}
	}

	public void postLoginMenu(User user) throws ItemNotFound {
		OperationStatus operationStatus = null;
		while (operationStatus != OperationStatus.QUIT) {
			writer.printMessage(getPostLoginMenu());
			int userChoice = getUserChoice();
			HashMap<Integer, MenuItem> menuItems = new HashMap<Integer, MenuItem>();
			menuItems.put(1, new DisplayItems(Library.Type.BOOK));
			menuItems.put(2, new DisplayItems(Library.Type.MOVIE));
			menuItems.put(3, new DisplayCustomerInfo(user));
			menuItems.put(4, new CheckOutBooks(consoleReader, user));
			menuItems.put(5, new CheckOutMovies(consoleReader));
			menuItems.put(6, new ReturnItem(consoleReader));
			menuItems.put(7, new UserLogout(this));
			menuItems.put(8, new Exit());
			if (menuItems.containsKey(userChoice)) {
				MenuItem listableMenu = menuItems.get(userChoice);
				operationStatus= listableMenu.execute(library);
				writer.printMessage(operationStatus.getMessage());
			}
			else 	writer.printMessage("Invalid Input");

		}
	}
	public void adminMenu() throws ItemNotFound {
		OperationStatus operationStatus = null;
		while (operationStatus != OperationStatus.QUIT) {
			writer.printMessage(getAdminMenu());
			int userChoice = getUserChoice();
			HashMap<Integer, MenuItem> menuItems = new HashMap<Integer, MenuItem>();
			menuItems.put(1, new TrackCheckOutBooks());
			menuItems.put(2, new UserLogout(this));
			menuItems.put(3, new Exit());
			if (menuItems.containsKey(userChoice)) {
				MenuItem listableMenu = menuItems.get(userChoice);
				operationStatus = listableMenu.execute(library);
				writer.printMessage(operationStatus.getMessage());
			} else writer.printMessage("Invalid Input");

		}
	}
	public String getMenu() {

		return "1.List OF Books\n2.List Of Movie\n3.Return\n4.Login\n5.Exit";
	}



	public String getPostLoginMenu() {
		return "1.List OF Books\n2.List Of Movie\n3.Personal Info\n4.Checkout Book\n5.Checkout Movie\n6.Return Item\n7.Logout\n8.Exit";
	}

	public String getAdminMenu() {
		return "1.track Books\n2.Logout\n3.Exit";
	}

	public static int getUserChoice() {
		return new Reader().receiveInput();
	}

}
