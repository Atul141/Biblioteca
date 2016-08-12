import IO.Reader;
import com.twu.biblioteca.Book;
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

/*	@Test
	public void shouldDisplayBookDetails() throws IOException {
		List<String > listOFBooks= new ArrayList<String>();

		Book book1=new Book(1,"Java","Malik",2010);
		Book book2=new Book(2,"Nancy Drew","Carolyn Keene",2008);
		Book book3=new Book(3,"Artemis Fowl","Eoin Colfer",2005);

		listOFBooks.add(book1.getDetails());
		listOFBooks.add(book2.getDetails());
		listOFBooks.add(book3.getDetails());
		Reader reader =new Reader();

		assertEquals(listOFBooks, new Library(new Menu(new Reader()), reader.fetchFromFile()).printBookList());

	}
	@Test
	public void shouldDisplaySuccessfulCheckoutOfBook() throws IOException, BookNotFoundExemption {
		Reader reader =new Reader();
		reader.fetchFromFile();
		Library library=new Library(new Menu(new Reader()), reader.fetchFromFile());
		assertEquals(library.checkout(2).getClass(),Book.class);
	}
	@Test(expected = BookNotFoundExemption.class)
	public void shouldDisplayUnSuccessfulCheckoutOfBook() throws IOException, BookNotFoundExemption {
		Reader reader =new Reader();
		Library library=new Library(new Menu(new Reader()), reader.fetchFromFile());
		library.checkout(5);
	}
	@Test
	public void shouldDisplaySuccessfulReturnOfBook() throws IOException, BookNotFoundExemption {
	Reader reader =new Reader();
			Library library=new Library(new Menu(new Reader()), reader.fetchFromFile());
		library.checkout(2);
		assertEquals(library.returnBook(2).getClass(),Book.class);
	}
	@Test(expected = BookNotFoundExemption.class)
	public void shouldDisplayUnSuccessfulReturnOfBook() throws IOException, BookNotFoundExemption {
		Reader reader = new Reader();
		Library library=new Library(new Menu(new Reader()), reader.fetchFromFile());
		library.returnBook(2);
	}
*/
}
