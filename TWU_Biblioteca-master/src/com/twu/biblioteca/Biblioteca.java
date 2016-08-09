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
			System.out.println("1.List Of Books\n2Exit");
			Scanner input = new Scanner(System.in);
			option = input.nextInt();
			applyOptions(option);
		}
	}
	private  void applyOptions(int option) {

		switch(option){
			case 1:printBookList();break;
			case 2:systemExit();
				default:invalidInput();
		}
	}

	private void systemExit() {
		printMessage("Thanks For Using");
		System.exit(0);

	}
	private  void invalidInput() {
	printMessage("Invalid Input");

	}
}
