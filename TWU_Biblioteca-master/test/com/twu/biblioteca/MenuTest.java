package com.twu.biblioteca;

import IO.DBParser;
import IO.Reader;
import IO.ConsoleReader;
import IO.Writer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//

public class MenuTest {

	@Test
	public void shouldDisplayPreLoginMenu() throws ItemNotFound, SQLException {
		Reader reader = mock(Reader.class);
		Writer writer = mock(Writer.class);
		DBParser dbParser = new DBParser();
		dbParser.connectToDB();
		Library library = new Library(dbParser.getItemsFromDb());
		Menu menu = new Menu(reader, library);
		writer.printMessage(menu.getMenu());
		verify(writer).printMessage("1.List OF Books\n2.List Of Movie\n3.Return\n4.Login\n5.Exit");
	}

	@Test
	public void shouldDisplayBooks() throws ItemNotFound, SQLException {
		Reader reader = mock(Reader.class);
		Writer writer = mock(Writer.class);
		DBParser dbParser = new DBParser();
		dbParser.connectToDB();
		Library library = new Library(dbParser.getItemsFromDb());

		new DisplayItems(Library.Type.BOOK).execute(library);
		verify(writer).printMessage("ISBN NAME           AUTHOR         YEAR \n" +
				"1    java           Malik          2005 \n" +
				"\n" +
				"2    Artemis Fowl   Eoin Colfer    2010 \n" +
				"\n" +
				"3    nancy drew     corolyn        2008 \n");
	}
}
