package com.twu.biblioteca;

import IO.Reader;
import IO.ConsoleReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//
public class ReturnBookTest {

	class DummyConsoleReader implements ConsoleReader {

		@Override
		public int receiveInput() {
			return 1;
		}

		@Override
		public Map<Integer, Item> fetchFromFile() throws IOException {
			return null;
		}
	}

	@Test
	public void shouldBeAbleToReturnCheckedBook() throws IOException, BookNotFoundExemption {

		Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
		listOfBook.put(1,new Book(1,"Java","Malik",2005));
		DummyConsoleReader dummyReader=new DummyConsoleReader();
		LibraryItem library=new LibraryItem(listOfBook,new Menu(new Reader()));
		new CheckOutBook(dummyReader).execute(library,1);
		Assert.assertEquals(new ReturnBook(dummyReader).execute(library,1), OperationStatus.SUCCESSFUL_RETURN);
	}
@Test(expected =BookNotFoundExemption.class)
	public void shouldNotBeAbleToReturnUnCheckedBook() throws IOException, BookNotFoundExemption {

		Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
		listOfBook.put(1,new Book(1,"Java","Malik",2005));
		DummyConsoleReader dummyReader=new DummyConsoleReader();
		LibraryItem library=new LibraryItem(listOfBook,new Menu(new Reader()));
		new CheckOutBook(dummyReader).execute(library,1);
		Assert.assertEquals(new ReturnBook(dummyReader).execute(library,2), OperationStatus.UNSUCCESSFUL_RETURN);
	}

}
