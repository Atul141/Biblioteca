package com.twu.biblioteca;

import IO.DBParser;
import IO.Reader;
import IO.Writer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class BibliotecaApp {

	public static void main(String[] args) throws IOException, ItemNotFound, SQLException {
		printWelcomeMessage();
		Reader reader = new Reader();
		Writer writer = new Writer();
		DBParser dbParser = new DBParser();
		dbParser.connectToDB();
		Library library = new Library(dbParser.getItemsFromDb());
		Menu menu = new Menu(reader, library);
		menu.preLoginMenu();
	}


	public static void printWelcomeMessage() {
		Writer writer = new Writer();
		OperationStatus operationStatus = OperationStatus.WELCOME;
		writer.printMessage(operationStatus.getMessage());

	}
}
