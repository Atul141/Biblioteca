package com.twu.biblioteca;

import IO.Reader;
import IO.Writer;

import java.io.IOException;

public class BibliotecaApp {

	public static void main(String[] args) throws IOException, ItemNotFound {
		printWelcomeMessage();
		Reader reader = new Reader();
		Writer writer = new Writer();
		Library library = new Library(reader.fetchFromFile());
		Menu menu = new Menu(reader, library);
		writer.printMessage(menu.getMenu());
		OperationStatus operationStatus = menu.preLoginMenu(library, getUserChoice());
		operationStatus = preLoginOperations(writer, library, menu);
		if (operationStatus == OperationStatus.SUCCESSFUL_LOGIN) {
			postLoginOperations(writer, library, menu);

		}
	}
	public static void postLoginOperations(Writer writer, Library library, Menu menu) throws ItemNotFound {
		writer.printMessage(menu.getPostLoginMenu());
		OperationStatus operationStatus=menu.postLoginMenu(library);
		while (operationStatus != OperationStatus.QUIT) {
			try {
				writer.printMessage(menu.getPostLoginMenu());
				operationStatus = menu.postLoginMenu(library);
			} catch (ItemNotFound e) {
				writer.printMessage("Item not Found");
			}
		}
	}

	public static OperationStatus preLoginOperations(Writer writer, Library library, Menu menu) throws ItemNotFound {
		writer.printMessage(menu.getMenu());
	OperationStatus	operationStatus = menu.preLoginMenu(library, getUserChoice());
		while (operationStatus != OperationStatus.QUIT && operationStatus != OperationStatus.SUCCESSFUL_LOGIN) {
			try {
				writer.printMessage(menu.getMenu());
				operationStatus = menu.preLoginMenu(library, getUserChoice());
			} catch (ItemNotFound e) {
				writer.printMessage("Item Not Found");
			}
		}
		return operationStatus;
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
