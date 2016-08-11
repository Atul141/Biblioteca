package com.twu.biblioteca;

import IO.Input;
import IO.Writer;

import java.io.IOException;

public class BibliotecaApp {

	public static void main(String[] args) throws IOException, BookNotFoundExemption {
		printWelcomeMessage();
		Input input = new Input();
		Writer writer = new Writer();
		Menu menu = new Menu(input);
		Library library = new Library(menu, input.fetchFromFile());
		writer.printMessage(menu.getMenu());
		OperationStatus operationStatus = menu.performOperation(library, getUserChoice());
		while (operationStatus != OperationStatus.QUIT) {
			writer.printMessage(menu.getMenu());
			operationStatus = menu.performOperation(library, getUserChoice());
		}
	}

	public static int getUserChoice() {
		int temp = new Input().receiveInput();
		System.out.println();
		return temp;
	}

	public static void printWelcomeMessage() {
		Writer writer = new Writer();
		OperationStatus operationStatus = OperationStatus.WELCOME;
		writer.printMessage(operationStatus.getMessage());

	}
}
