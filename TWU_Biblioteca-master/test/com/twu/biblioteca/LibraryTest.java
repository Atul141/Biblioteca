package com.twu.biblioteca;

import IO.Reader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

//
public class LibraryTest {

@Before
public void  setup(){
	Map<Integer,Item> items=new HashMap<Integer, Item>();
	items.put(1,new Book(1,"Java","Malik",2010));
	items.put(2,new Book(2,"Nancy Drew","Carolyn Keene",2008));
	items.put(3,new Book(3,"Artemis Fowl","Eoin Colfer",2005));

}
	@Test
	public void shouldBeAbleToVerifyIfItemDetailsArePrintedForBooks() throws IOException {
		List<String> listOFBooks = getBooks();
	Reader reader =new Reader();
	assertEquals(listOFBooks, new Library(reader.fetchFromFile()).printItems(Library.Type.BOOK));
}

	private List<String> getBooks() {
		List<String > listOFBooks= new ArrayList<String>();

		Book book1=new Book(1,"Java","Malik",2010);
		Book book2=new Book(2,"Nancy Drew","Carolyn Keene",2008);
		Book book3=new Book(3,"Artemis Fowl","Eoin Colfer",2005);

		listOFBooks.add(book1.getDetails());
		listOFBooks.add(book2.getDetails());
		listOFBooks.add(book3.getDetails());
		return listOFBooks;
	}

	@Test
	public void shouldBeAbleToVerifyIfItemDetailsArePrintedForMovie() throws IOException {
	List<String > listOFBooks= new ArrayList<String>();

	Item movie1=new Movie(1,"2012","Roland",2011,6);
	Item movie2=new Movie(2,"White House Down","Roland",2008,7);
	Item movie3=new Movie(3,"Black Hawk Down","Rediley",2005,8);

	listOFBooks.add(movie1.getDetails());
	listOFBooks.add(movie2.getDetails());
	listOFBooks.add(movie3.getDetails());

		//assertEquals(listOFBooks, new Library().printItems(Library.Type.MOVIE));
}

}
