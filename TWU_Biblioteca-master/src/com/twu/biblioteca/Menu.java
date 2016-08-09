package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Represents the I/O operations
public class Menu {

	Library library = new Library();
	Output output = new Output();

	public Menu() {
		output.printMessage(library.getWelcomeMessage());
	}

	List<String> listOfBooks = new ArrayList<String>();
	private int option;

	public void printBookList() {
		output.printMessage(String.format("ISBN Book Name      Author         Year\n"));
		listOfBooks = library.printBookList();
		for (String bookDetails : listOfBooks) {
			output.printMessage(bookDetails);
		}
	}

	public void mainMenu() {

		while (true) {
			output.printMessage("1.List OF Books\n2.CheckoutBooks\n3.Return Book\n4.Exit");
			Scanner input = new Scanner(System.in);
		try {
			option = input.nextInt();
		}catch (InputMismatchException e){
		}
				applyOptions(option);
		}
	}

	private void applyOptions(int option) {

		switch (option) {
			case 1:
				printBookList();
				break;
			case 2:
				checkoutBook();
				break;
			case 3:returnBook();break;
			case 4:	systemExit();

			default:
				invalidInput();
		}
	}
	private void returnBook() {

		output.printMessage("Enter the ISBN Number");
		Scanner input = new Scanner(System.in);
		int ISBN;
		try {
			ISBN=	input.nextInt();
		}catch (InputMismatchException e){
			output.printMessage("Invalid ISBN");
			return;
		}
		library.returnBook(ISBN);
	}

	private void checkoutBook() {
		printBookList();
		output.printMessage("Enter the ISBN Number");
		Scanner input = new Scanner(System.in);
		int ISBN;
		try {
			ISBN=	input.nextInt();

		}catch (InputMismatchException e){
		output.printMessage("Invalid ISBN");
			return;
		}
			output.printMessage(library.checkout(ISBN));
	}

	private void systemExit() {
		output.printMessage("Thanks For Using");
		System.exit(0);
	}

	private void invalidInput() {
		output.printMessage("Invalid Output");

	}
}
