import com.twu.biblioteca.Book;
import IO.Input;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Menu;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

	@Test
	public void shouldPrintWelcomeMessage() throws IOException {
			Input input=new Input();
		assertEquals("Welcome",new Library(new Menu(),input.fetchFromFile()).getWelcomeMessage());
	}
	@Test
	public void shouldDisplayBookDetails() throws IOException {
		List<String > listOFBooks= new ArrayList<String>();

		Book book1=new Book(1,"Java","Malik",2010);
		Book book2=new Book(2,"Nancy Drew","Carolyn Keene",2008);
		Book book3=new Book(3,"Artemis Fowl","Eoin Colfer",2005);

		listOFBooks.add(book1.getBookDetails());
		listOFBooks.add(book2.getBookDetails());
		listOFBooks.add(book3.getBookDetails());
		Input input=new Input();

		assertEquals(listOFBooks, new Library(new Menu(),input.fetchFromFile()).printBookList());

	}
	@Test
	public void shouldDisplaySuccessfulCheckoutOfBook() throws IOException {
		Input input=new Input();
		input.fetchFromFile();
		Library library=new Library(new Menu(),input.fetchFromFile());
		assertTrue(library.checkout(2));
	}
	@Test
	public void shouldDisplayUnSuccessfulCheckoutOfBook() throws IOException {
		Input input=new Input();
		Library library=new Library(new Menu(),input.fetchFromFile());
		assertEquals(false,library.checkout(5));
	}
	@Test
	public void shouldDisplaySuccessfulReturnOfBook() throws IOException {
	Input input=new Input();
			Library library=new Library(new Menu(),input.fetchFromFile());
		library.checkout(2);
		assertEquals(true,library.returnBook(2));
	}
	@Test
	public void shouldDisplayUnSuccessfulReturnOfBook() throws IOException {
		Input input = new Input();
		Library library=new Library(new Menu(),input.fetchFromFile());
		assertEquals(false,library.returnBook(2));
	}

}
