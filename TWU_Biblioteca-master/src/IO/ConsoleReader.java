package IO;


import com.twu.biblioteca.Item;

import java.io.IOException;
import java.util.Map;

public interface ConsoleReader {

  int receiveInput();
	Map<Integer, Item> fetchFromFile() throws IOException;
}
