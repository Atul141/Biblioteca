package com.twu.biblioteca;

import IO.DBParser;
import IO.Reader;
import IO.Writer;

import java.io.IOException;
import java.sql.SQLException;

public class BibliotecaApp {

	public static void main(String[] args) throws IOException, ItemNotFound, SQLException {
		printWelcomeMessage();
		Reader reader = new Reader();
		Writer writer = new Writer();
		DBParser dbParser=new DBParser();
		dbParser.connectToDB();
		Library library = new Library(dbParser.getItemsFromDb());
		Menu menu = new Menu(reader, library);
		preLoginOperations(writer,library,menu);
	}
	public static void postLoginOperations(Writer writer, Library library, Menu menu,User user) throws ItemNotFound {
		writer.printMessage(menu.getPostLoginMenu());
		OperationStatus operationStatus=menu.postLoginMenu(library,user);
		while (operationStatus != OperationStatus.QUIT) {
			try {
				writer.printMessage(menu.getPostLoginMenu());
				operationStatus = menu.postLoginMenu(library,user);
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
	public static OperationStatus adminLoginOperations(Writer writer, Library library, Menu menu,Admin user) throws ItemNotFound {
		writer.printMessage(menu.getAdminMenu());
		OperationStatus	operationStatus = menu.adminMenu(library,user);
		while (operationStatus != OperationStatus.QUIT && operationStatus != OperationStatus.SUCCESSFUL_LOGIN) {
			try {
				writer.printMessage(menu.getAdminMenu());
				operationStatus = menu.adminMenu(library,user);
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
