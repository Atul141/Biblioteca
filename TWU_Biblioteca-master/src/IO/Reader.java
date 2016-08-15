package IO;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Takes Reader
public class Reader implements ConsoleReader {

	public int receiveInput() {
		int option = 0;
		Scanner input = new Scanner(System.in);
		try {
			option = input.nextInt();
		} catch (InputMismatchException e) {
		}
		return option;
	}

	public Map<Integer,Item> fetchFromFile() throws IOException {
		String book;
		List<String> listOfItems = new ArrayList<String>();
		FileReader reader = new FileReader("/Users/atulk/Desktop/Assignment/booklistdlahdliwhdl.txt");
		BufferedReader buffer = new BufferedReader(reader);
		while ((book = buffer.readLine()) != null) {
			listOfItems.add(book);
		}
		return (new parseInput().createMapOfBooks(listOfItems));
	}

	public String receiveString() {
	Scanner input=new Scanner(System.in);
		return input.next();
	}
}
