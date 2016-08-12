package com.twu.biblioteca;

import IO.Reader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//
public class LibraryItemTest {
@Test
	public void shouldBeAbleToVerifyIfItemDetailsArePrintedForBooks() throws IOException {
	List<String > listOFBooks= new ArrayList<String>();

	Book book1=new Book(1,"Java","Malik",2010);
	Book book2=new Book(2,"Nancy Drew","Carolyn Keene",2008);
	Book book3=new Book(3,"Artemis Fowl","Eoin Colfer",2005);

	listOFBooks.add(book1.getDetails());
	listOFBooks.add(book2.getDetails());
	listOFBooks.add(book3.getDetails());
	Reader reader =new Reader();
	Assert.assertEquals(listOFBooks, new LibraryItem(reader.fetchFromFile(),new Menu(new Reader())).printBookList(LibraryItem.Type.BOOK));
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
	Assert.assertEquals(listOFBooks, new LibraryItem(new Menu(new Reader())).printBookList(LibraryItem.Type.MOVIE));
}

}
