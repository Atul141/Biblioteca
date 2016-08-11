package com.twu.biblioteca;

import IO.Reader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//
public class ReturnBookTest {

	class DummyReader implements Reader{

		@Override
		public int receiveInput() {
			return 1;
		}

		@Override
		public Map<Integer, Book> fetchFromFile() throws IOException {
			return null;
		}
	}

	@Test
	public void shouldBeAbleToReturnCheckedBook() throws IOException {

		Map<Integer,Book> listOfBook=new HashMap<Integer,Book>();
		listOfBook.put(1,new Book(1,"Java","Malik",2005));
		DummyReader dummyReader=new DummyReader();
		Library library=new Library(new Menu(),listOfBook);
		new CheckOutBook(dummyReader).execute(library,1);
		Assert.assertEquals(new ReturnBook(dummyReader).execute(library,1),OutputString.SUCCESSFUL_RETURN);
	}
@Test
	public void shouldNotBeAbleToReturnUnCheckedBook() throws IOException {

		Map<Integer,Book> listOfBook=new HashMap<Integer,Book>();
		listOfBook.put(1,new Book(1,"Java","Malik",2005));
		DummyReader dummyReader=new DummyReader();
		Library library=new Library(new Menu(),listOfBook);
		new CheckOutBook(dummyReader).execute(library,1);
		Assert.assertEquals(new ReturnBook(dummyReader).execute(library,2),OutputString.UNSUCCESSFUL_RETURN);
	}

}
