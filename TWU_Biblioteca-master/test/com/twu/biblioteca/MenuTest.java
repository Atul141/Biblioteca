package com.twu.biblioteca;

import IO.Input;
import IO.Reader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;

//
public class MenuTest {

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
	public void shouldAbleToPromptInvalidOptionMessageIfInvalidInputIsGiven() throws IOException, BookNotFoundExemption {
		Menu menu=new Menu(new Input());
		Map<Integer,Book> listOfBook=new HashMap<Integer,Book>();
		listOfBook.put(1,new Book(1,"Java","Malik",2005));
		Assert.assertEquals(menu.performOperation(new Library(new Menu(new Input()),listOfBook),5), OperationStatus.INVALID_OPERATION);
	}

	@Test
	public void shouldNotAbleToPromptInvalidOptionMessageIfValidInputIsGiven() throws IOException, BookNotFoundExemption {
		Menu menu=new Menu(new Input());
		Map<Integer,Book> listOfBook=new HashMap<Integer,Book>();
		listOfBook.put(1,new Book(1,"Java","Malik",2005));
		Assert.assertNotEquals(menu.performOperation(new Library(new Menu(new Input()),listOfBook),4), OperationStatus.INVALID_OPERATION);
	}


}
