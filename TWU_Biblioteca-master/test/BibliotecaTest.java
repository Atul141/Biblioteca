import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Library;
import org.junit.Assert;
import org.junit.Test;

public class BibliotecaTest {

	@Test
	public void shouldPrintWelcomeMessage(){

		Assert.assertEquals("Welcome",new Library().getWelcomeMessage());
	}
}
