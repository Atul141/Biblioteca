import com.twu.biblioteca.Book;
import com.twu.biblioteca.Input;
import com.twu.biblioteca.Library;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {

	@Test
	public void shouldPrintWelcomeMessage(){

		assertEquals("Welcome",new Library().getWelcomeMessage());
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

		assertEquals(listOFBooks, new Library(input.fetchFromFile()).printBookList());

	}
	@Test
	public void shouldDisplaySuccessfulCheckoutOfBook() throws IOException {
		Input input=new Input();
		input.fetchFromFile();
		Library library=new Library(input.fetchFromFile());
		assertTrue(library.checkout(2));
	}
	@Test
	public void shouldDisplayUnSuccessfulCheckoutOfBook() throws IOException {
		Input input=new Input();
		Library library=new Library(input.fetchFromFile());
		assertEquals(false,library.checkout(5));
	}
	@Test
	public void shouldDisplaySuccessfulReturnOfBook() throws IOException {
	Input input=new Input();
			Library library=new Library(input.fetchFromFile());
		library.checkout(2);
		assertEquals(true,library.returnBook(2));
	}
	@Test
	public void shouldDisplayUnSuccessfulReturnOfBook() throws IOException {
		Input input = new Input();
		Library library=new Library(input.fetchFromFile());
		assertEquals(false,library.returnBook(2));
	}

}
