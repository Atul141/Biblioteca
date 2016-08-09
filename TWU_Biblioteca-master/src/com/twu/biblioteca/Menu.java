package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Represents the I/O operations
public class Menu {

	Output output = new Output();
	Input input = new Input();
	Library library = new Library(input.fetchFromFile());

	public Menu() throws IOException {
		output.printMessage(library.getWelcomeMessage());
	}

	List<String> listOfBooks = new ArrayList<String>();

	public void printBookList() {
		output.printMessage(String.format("ISBN Book Name      Author         Year\n"));
		listOfBooks = library.printBookList();
		for (String bookDetails : listOfBooks) {
			output.printMessage(bookDetails);
		}
	}

	public void mainMenu() {

		while (true) {
			output.printMessage("1.List OF Books\n2.CheckoutBooks\n3.Return Book\n4.Exit");
				applyOptions(input.receiveInput());
		}
	}

	private void applyOptions(int option) {

		switch (option) {
			case 1:
				printBookList();
				break;
			case 2:
				checkoutBook();
				break;
			case 3:returnBook();break;
			case 4:	systemExit();

			default:
				invalidInput();
		}
	}
	private void returnBook() {

		output.printMessage("Enter the ISBN Number");
		output.printMessage(library.returnBook(input.receiveInput()));
	}

	private void checkoutBook() {
		printBookList();
		output.printMessage("Enter the ISBN Number");
			output.printMessage(library.checkout(input.receiveInput()));
	}

	private void systemExit() {
		output.printMessage("Thanks For Using");
		System.exit(0);
	}

	private void invalidInput() {
		output.printMessage("Invalid Output");

	}
}
