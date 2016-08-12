package com.twu.biblioteca;

import IO.Reader;
import IO.ConsoleReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;

//

public class MenuTest {

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
	public void shouldAbleToPromptInvalidOptionMessageIfInvalidInputIsGiven() throws IOException, BookNotFoundExemption {
		Menu menu=new Menu(new Reader());
		Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
		listOfBook.put(1,new Book(1,"Java","Malik",2005));
		Assert.assertEquals(menu.performOperation(new LibraryItem(listOfBook,new Menu(new Reader())),5), OperationStatus.INVALID_OPERATION);
	}

	@Test
	public void shouldNotAbleToPromptInvalidOptionMessageIfValidInputIsGiven() throws IOException, BookNotFoundExemption {
		Menu menu=new Menu(new Reader());
		Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
		listOfBook.put(1,new Book(1,"Java","Malik",2005));
		Assert.assertNotEquals(menu.performOperation(new LibraryItem(listOfBook,new Menu(new Reader())),4), OperationStatus.INVALID_OPERATION);
	}


}
