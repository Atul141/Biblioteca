package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Takes Input
public class Input {

	public int receiveInput() {
		int option = 0;
		Scanner input = new Scanner(System.in);
		try {
			option = input.nextInt();
		} catch (InputMismatchException e) {
		}
		return option;
	}

	public Map<Integer,Book> fetchFromFile() throws IOException {
		String book;
		List<String> listOfBooks = new ArrayList<String>();
		FileReader reader = new FileReader("/Users/atulk/Desktop/Assignment/booklist.txt");
		BufferedReader buffer = new BufferedReader(reader);
		while ((book = buffer.readLine()) != null) {
			listOfBooks.add(book);
		}

			return (new parseInput().createMapOfBooks(listOfBooks));
	}
}