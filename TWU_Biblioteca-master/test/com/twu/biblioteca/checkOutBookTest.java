package com.twu.biblioteca;

import IO.Reader;
import IO.ConsoleReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//
public class checkOutBookTest {


	class DummyConsoleReader implements ConsoleReader {

		@Override
		public int receiveInput() {
			return 2;

		}

		@Override
		public Map<Integer, Item> fetchFromFile() throws IOException {
			return null;
		}
	}
	@Test
	public void shouldBeAbleToCheckoutAvailableBooks() throws IOException, BookNotFoundExemption {
	Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
	listOfBook.put(1,new Book(1,"Java","Malik",2005));
	DummyConsoleReader dummyReader=new DummyConsoleReader();
	Assert.assertEquals(new CheckOutItems(dummyReader).execute(new LibraryItem( listOfBook,new Menu(new Reader())), 1), OperationStatus.SUCCESSFUL_CHECKOUT);
}
@Test(expected = BookNotFoundExemption.class)
	public void shouldNotBeAbleToCheckoutUnAvailableBooks() throws IOException, BookNotFoundExemption {
	Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
	listOfBook.put(1,new Book(1,"Java","Malik",2005));
	DummyConsoleReader dummyReader=new DummyConsoleReader();
	Assert.assertEquals(new CheckOutItems(dummyReader).execute(new LibraryItem( listOfBook,new Menu(new Reader())), 2), OperationStatus.UNSUCCESSFUL_CHECKOUT);
}
}
