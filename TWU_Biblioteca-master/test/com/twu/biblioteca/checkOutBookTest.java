package com.twu.biblioteca;

import IO.Reader;
import IO.ConsoleReader;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

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
	public void shouldBeAbleToCheckoutAvailableBooks() throws IOException, ItemNotFound {
	Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
	listOfBook.put(1,new Book(1,"Java","Malik",2005));
	DummyConsoleReader dummyReader=new DummyConsoleReader();
	assertEquals(new CheckOutItems(dummyReader).execute(new Library( listOfBook,new Menu(new Reader())), 1, Library.Type.BOOK), OperationStatus.SUCCESSFUL_CHECKOUT);
}
@Test(expected = ItemNotFound.class)
	public void shouldNotBeAbleToCheckoutUnAvailableBooks() throws IOException, ItemNotFound {
	Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
	listOfBook.put(1,new Book(1,"Java","Malik",2005));
	DummyConsoleReader dummyReader=new DummyConsoleReader();
	assertEquals(new CheckOutItems(dummyReader).execute(new Library( listOfBook,new Menu(new Reader())),2, Library.Type.BOOK), OperationStatus.UNSUCCESSFUL_CHECKOUT);
}
	@Test
	public void shouldBeAbleToCheckoutAvailableMovies() throws IOException, ItemNotFound {
		Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
		listOfBook.put(1,new Book(1,"Java","Malik",2005));
		listOfBook.put(2,new Movie(2,"2012","Roland",2010,6));
		DummyConsoleReader dummyReader=new DummyConsoleReader();
		assertEquals(new CheckOutItems(dummyReader).execute(new Library( listOfBook,new Menu(new Reader())),2, Library.Type.MOVIE), OperationStatus.SUCCESSFUL_CHECKOUT);
	}
	@Test(expected = ItemNotFound.class)
	public void shouldNotBeAbleToCheckoutUnAvailableMovies() throws IOException, ItemNotFound {
		Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
		listOfBook.put(1,new Book(1,"Java","Malik",2005));
		listOfBook.put(2,new Movie(2,"2012","Roland",2010,6));
		DummyConsoleReader dummyReader=new DummyConsoleReader();
		assertEquals(new CheckOutItems(dummyReader).execute(new Library( listOfBook,new Menu(new Reader())),3, Library.Type.MOVIE), OperationStatus.SUCCESSFUL_CHECKOUT);
	}
}
