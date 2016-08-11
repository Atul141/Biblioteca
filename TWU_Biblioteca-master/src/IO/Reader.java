package IO;

import com.twu.biblioteca.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Takes Input
public class Input implements ConsoleReader {

	public int receiveInput() {
		int option = 0;
		Scanner input = new Scanner(System.in);
		try {
			option = input.nextInt();
		} catch (InputMismatchException e) {
		}
		return option;
	}

	public Map<Integer,Book> fetchFromFile(int choice) throws IOException {
		String book;
		List<String> listOfBooks = new ArrayList<String>();
		FileReader reader;
		if(choice==1){
		reader = new FileReader("/Users/atulk/Desktop/Assignment/booklist.txt");}
		else {
			reader = new FileReader("/Users/atulk/Desktop/Assignment/movielist.txt");}


		BufferedReader buffer = new BufferedReader(reader);
		while ((book = buffer.readLine()) != null) {
			listOfBooks.add(book);
		}
			return (new parseInput().createMapOfBooks(listOfBooks));
	}
}