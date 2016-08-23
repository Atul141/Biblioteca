package com.twu.biblioteca;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

@Test
public void shouldBeAbleToCreateABook(){
	Book book = new Book(1,"Java","Malik",2005);
	assertEquals(book.getClass(),Book.class);
}
@Test
	public void shouldBeAbleVerifyIfBookDetailsIsPrinted(){
	assertEquals("1    Java           Malik          2005 \n",new Book(1,"Java","Malik",2005).getDetails());
}
}
