package com.twu.biblioteca;

import IO.Writer;

import java.util.List;

// Prints The List OF Books
public class DisplayItems implements MenuItem {

	private Library.Type type;

	DisplayItems(Library.Type type) {

		this.type = type;
	}

	@Override
	public OperationStatus execute(Library library) {
		Writer writer = new Writer();
		List<String> items = library.printItems(type);
		if (type == Library.Type.BOOK) {
			writer.printMessage("ISBN NAME           AUTHOR         YEAR ");
			displayItems(writer, items);
		} else {
			writer.printMessage("ID   NAME                     DIRECTOR                 YEAR RATING");
			displayItems(writer, items);
		}
		return OperationStatus.SUCCESSFULLY_RETURNED;
	}

	private void displayItems(Writer writer, List<String> items) {
		for (String item : items) {
			writer.printMessage(item);
		}
	}
}