package com.twu.biblioteca;


import IO.Reader;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CheckOutMovieTest {


	@Test
	public void shouldBeAbleToCheckoutAvailableMovies() throws IOException, ItemNotFound {
		Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
		listOfBook.put(1,new Movie(1,"White House Down","Roland",2005,7));
		listOfBook.put(2,new Movie(2,"2012","Roland",2010,6));
		assertEquals(new CheckOutMovies(new Reader()).execute(new Library(listOfBook),2), OperationStatus.SUCCESSFUL_CHECKOUT);
	}
	@Test(expected = ItemNotFound.class)
	public void shouldNotBeAbleToCheckoutUnAvailableMovies() throws IOException, ItemNotFound {
		Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
		listOfBook.put(1,new Movie(1,"White House Down","Roland",2005,7));
		listOfBook.put(2,new Movie(2,"2012","Roland",2010,6));
		assertEquals(new CheckOutMovies(new Reader()).execute(new Library( listOfBook),3), OperationStatus.UNSUCCESSFUL_CHECKOUT);
	}

}
