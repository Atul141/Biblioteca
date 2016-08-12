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
	new UserLogin().execute(new Library(listOfBook,new Menu(new Reader())));
	Mockito.verify(reader).receiveInput();

}



}
