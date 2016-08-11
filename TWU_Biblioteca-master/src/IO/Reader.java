package IO;


import com.twu.biblioteca.Book;

import java.io.IOException;
import java.util.Map;

public interface Reader {

  int receiveInput();
	Map<Integer,Book> fetchFromFile() throws IOException;
}
