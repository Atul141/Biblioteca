package com.twu.biblioteca;

import IO.Input;
import IO.Output;

import java.io.IOException;

public class BibliotecaApp {

	public static void main(String[] args) throws IOException, BookNotFoundExemption {
		printWelcomeMessage();
		Input input = new Input();
		Output output = new Output();
		Menu menu = new Menu(input);
		Library library = new Library(menu, input.fetchFromFile());
		output.printMessage(menu.getMenu());
		OperationStatus operationStatus = menu.performOperation(library, getUserChoice());
		while (operationStatus != OperationStatus.QUIT) {
			output.printMessage(menu.getMenu());
			operationStatus = menu.performOperation(library, getUserChoice());
		}
	}

	public static int getUserChoice() {
		int temp = new Input().receiveInput();
		System.out.println();
		return temp;
	}

	public static void printWelcomeMessage() {
		Output output = new Output();
		OperationStatus operationStatus = OperationStatus.WELCOME;
		output.printMessage(operationStatus.getMessage());

	}
}
