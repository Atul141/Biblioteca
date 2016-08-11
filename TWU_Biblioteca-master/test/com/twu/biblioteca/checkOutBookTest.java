package com.twu.biblioteca;

import IO.Input;
import IO.Reader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//
public class checkOutBookTest {


	class DummyReader implements Reader {

		@Override
		public int receiveInput() {
			return 2;

		}

		@Override
		public Map<Integer, Book> fetchFromFile() throws IOException {
			return null;
		}
	}
	@Test
	public void shouldBeAbleToCheckoutAvailableBooks() throws IOException {
	Map<Integer,Book> listOfBook=new HashMap<Integer,Book>();
	listOfBook.put(1,new Book(1,"Java","Malik",2005));
	DummyReader dummyReader=new DummyReader();
	Assert.assertEquals(new CheckOutBook(dummyReader).execute(new Library(new Menu(), listOfBook), 1), OutputString.SUCCESSFUL_CHECKOUT);
}
@Test
	public void shouldNotBeAbleToCheckoutUnAvailableBooks() throws IOException {
	Map<Integer,Book> listOfBook=new HashMap<Integer,Book>();
	listOfBook.put(1,new Book(1,"Java","Malik",2005));
	DummyReader dummyReader=new DummyReader();
	Assert.assertEquals(new CheckOutBook(dummyReader).execute(new Library(new Menu(), listOfBook), 2), OutputString.UNSUCCESSFUL_CHECKOUT);
}
}
