package com.twu.biblioteca;

import IO.Input;
import IO.Reader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//
public class MainMenuTest {

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
	public void shouldAbleToPromptInvalidOptionMessageIfInvalidInputIsGiven() throws IOException {
		MainMenu menu=new MainMenu(new Input());
		Map<Integer,Book> listOfBook=new HashMap<Integer,Book>();
		listOfBook.put(1,new Book(1,"Java","Malik",2005));
		Assert.assertEquals(menu.performOperation(new Library(new Menu(),listOfBook),5),OutputString.INVALID_OPERATION);
	}

	@Test
	public void shouldNotAbleToPromptInvalidOptionMessageIfValidInputIsGiven() throws IOException {
		MainMenu menu=new MainMenu(new Input());
		Map<Integer,Book> listOfBook=new HashMap<Integer,Book>();
		listOfBook.put(1,new Book(1,"Java","Malik",2005));
		Assert.assertNotEquals(menu.performOperation(new Library(new Menu(),listOfBook),4),OutputString.INVALID_OPERATION);
	}


}
