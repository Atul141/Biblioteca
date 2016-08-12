package com.twu.biblioteca;

import IO.Reader;
import IO.Writer;

import java.io.IOException;

public class BibliotecaApp {

	public static void main(String[] args) throws IOException, ItemNotFound {
		printWelcomeMessage();
		Reader reader = new Reader();
		Writer writer = new Writer();
		Menu menu = new Menu(reader);
		Library library = new Library(reader.fetchFromFile(),menu);
		writer.printMessage(menu.getMenu());
		OperationStatus operationStatus = menu.preLoginMenu(library, getUserChoice());
		while (operationStatus != OperationStatus.QUIT) {
			writer.printMessage(menu.getMenu());
			operationStatus = menu.preLoginMenu(library, getUserChoice());
		}
	}

	public static int getUserChoice() {
		int temp = new Reader().receiveInput();
		System.out.println();
		return temp;
	}

	public static void printWelcomeMessage() {
		Writer writer = new Writer();
		OperationStatus operationStatus = OperationStatus.WELCOME;
		writer.printMessage(operationStatus.getMessage());

	}
}
