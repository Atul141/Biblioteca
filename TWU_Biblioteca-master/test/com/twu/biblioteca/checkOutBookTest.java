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

	@Test
	public void shouldBeAbleToCheckoutAvailableBooks() throws IOException, ItemNotFound {
	Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
	listOfBook.put(1,new Book(1,"Java","Malik",2005));
	assertEquals(new CheckOutBooks(new Reader(),new User("0000","Hello")).execute(new Library( listOfBook), 1), OperationStatus.SUCCESSFUL_CHECKOUT);
}
@Test(expected = ItemNotFound.class)
	public void shouldNotBeAbleToCheckoutUnAvailableBooks() throws IOException, ItemNotFound {
	Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
	listOfBook.put(1,new Book(1,"Java","Malik",2005));
	assertEquals(new CheckOutBooks(new Reader(),new User("0000","Hello")).execute(new Library( listOfBook),2), OperationStatus.UNSUCCESSFUL_CHECKOUT);
}
}
