import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

	@Test
	public void shouldPrintWelcomeMessage(){

		assertEquals("Welcome",new Library().getWelcomeMessage());
	}
	@Test
	public void shouldDisplayBookDetails(){
		List<String > listOFBooks= new ArrayList<String>();

		Book book1=new Book(1,"Java","Malik",2010);
		Book book2=new Book(2,"Nancy Drew","Carolyn Keene",2008);
		Book book3=new Book(3,"Artemis Fowl","Eoin Colfer",2005);

		listOFBooks.add(book1.printBookDetails());
		listOFBooks.add(book2.printBookDetails());
		listOFBooks.add(book3.printBookDetails());
		assertEquals(listOFBooks, new Library().printBookList());

	}
}
