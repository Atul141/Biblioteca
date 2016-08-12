package com.twu.biblioteca;

import IO.Reader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//
public class ReaderTest {
@Test
public void shouldReturnAMapOFBooks() throws IOException {
	Map<Integer,Book> listOFBooks=new HashMap<Integer,Book>();
	Reader reader =new Reader();
	Book book1=new Book(1,"Java","Malik",2010);
	Book book2=new Book(2,"Nancy Drew","Carolyn Keene",2008);
	Book book3=new Book(3,"Artemis Fowl","Eoin Colfer",2005);

	listOFBooks.put(1,book1);
	listOFBooks.put(2,book2);
	listOFBooks.put(3,book3);
	Assert.assertEquals(listOFBooks, reader.fetchFromFile());
}
}
