package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Represents the I/O operations
public class Biblioteca {

	Library library=new Library();


	Biblioteca(){
		printMessage(library.getWelcomeMessage());
	}
List<String > listOfBooks=new ArrayList<String>();
	private int option;
	public void welcomeMessage(){
		library.getWelcomeMessage();
	}
	public void printBookList(){
		printMessage(String.format("ISBN Book Name      Author         Year\n"));
		listOfBooks=		library.printBookList();
	for(String bookDetails:listOfBooks){
		printMessage(bookDetails);
	}
	}

	private void printMessage(String bookDetails) {
	System.out.println(bookDetails);

	}
	public void mainMenu(){

		while (true) {
			printMessage("1.List OF Books\n2.CheckoutBooks\n3.Exit");
			Scanner input = new Scanner(System.in);
			option = input.nextInt();
			applyOptions(option);
		}
	}
	private  void applyOptions(int option) {

		switch(option){
			case 1:printBookList();break;
			case 2:checkoutBook();break;
				case 3:systemExit();
				default:invalidInput();
		}
	}

	private void checkoutBook() {
printBookList();
		Scanner input=new Scanner(System.in);
		library.checkout(input.nextInt());

	}


	private void systemExit() {
		printMessage("Thanks For Using");
		System.exit(0);

	}
	private  void invalidInput() {
	printMessage("Invalid Input");

	}
}
