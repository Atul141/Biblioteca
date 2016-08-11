package com.twu.biblioteca;


import org.junit.Assert;
import org.junit.Test;

public class BookTest {
@Test
	public void shouldCreateNewBook(){
	Assert.assertEquals("1    Java           Malik          2005 \n",new Book(1,"Java","Malik",2005).getBookDetails());
}
}
