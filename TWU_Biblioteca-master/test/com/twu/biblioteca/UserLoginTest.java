package com.twu.biblioteca;

import IO.Reader;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

//
public class UserLoginTest {

@Test
	public void shouldAbleToAuthenticateUse() throws ItemNotFound {

	Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
	listOfBook.put(1,new Book(1,"Java","Malik",2005));
	Library library=new Library(listOfBook);
	assertTrue(new UserLogin(library,new Menu(new Reader(),library)).authenticatePassword("0000","Hello"));
}



}
