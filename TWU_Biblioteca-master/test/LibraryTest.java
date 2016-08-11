import com.twu.biblioteca.Book;
import IO.Input;
import com.twu.biblioteca.BookNotFoundExemption;
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
	public void shouldDisplayBookDetails() throws IOException {
		List<String > listOFBooks= new ArrayList<String>();

		Book book1=new Book(1,"Java","Malik",2010);
		Book book2=new Book(2,"Nancy Drew","Carolyn Keene",2008);
		Book book3=new Book(3,"Artemis Fowl","Eoin Colfer",2005);

		listOFBooks.add(book1.getDetails());
		listOFBooks.add(book2.getDetails());
		listOFBooks.add(book3.getDetails());
		Input input=new Input();

		assertEquals(listOFBooks, new Library(new Menu(new Input()),input.fetchFromFile()).printBookList());

	}
	@Test
	public void shouldDisplaySuccessfulCheckoutOfBook() throws IOException, BookNotFoundExemption {
		Input input=new Input();
		input.fetchFromFile();
		Library library=new Library(new Menu(new Input()),input.fetchFromFile());
		assertEquals(library.checkout(2).getClass(),Book.class);
	}
	@Test(expected = BookNotFoundExemption.class)
	public void shouldDisplayUnSuccessfulCheckoutOfBook() throws IOException, BookNotFoundExemption {
		Input input=new Input();
		Library library=new Library(new Menu(new Input()),input.fetchFromFile());
		library.checkout(5);
	}
	@Test
	public void shouldDisplaySuccessfulReturnOfBook() throws IOException, BookNotFoundExemption {
	Input input=new Input();
			Library library=new Library(new Menu(new Input()),input.fetchFromFile());
		library.checkout(2);
		assertEquals(library.returnBook(2).getClass(),Book.class);
	}
	@Test(expected = BookNotFoundExemption.class)
	public void shouldDisplayUnSuccessfulReturnOfBook() throws IOException, BookNotFoundExemption {
		Input input = new Input();
		Library library=new Library(new Menu(new Input()),input.fetchFromFile());
		library.returnBook(2);
	}

}
