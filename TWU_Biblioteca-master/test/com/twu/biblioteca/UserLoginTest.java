package com.twu.biblioteca;

import IO.ConsoleReader;
import IO.Reader;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static com.sun.javaws.JnlpxArgs.verify;

//
public class UserLoginTest {

@Test
	public void shouldAbleToAuthenticateUserId() throws ItemNotFound {

	Map<Integer,Item> listOfBook=new HashMap<Integer,Item>();
	listOfBook.put(1,new Book(1,"Java","Malik",2005));
	ConsoleReader reader= Mockito.mock(ConsoleReader.class);
	Library library=new Library(listOfBook);
	new UserLogin(library).execute(new Library(listOfBook));
	Mockito.verify(reader).receiveInput();

}



}
