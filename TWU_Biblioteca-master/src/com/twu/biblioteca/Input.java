package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

// Takes Input
public class Input {

	public int receiveInput(){
		int option=0;
		Scanner input = new Scanner(System.in);
		try {
			option = input.nextInt();
		}catch (InputMismatchException e){
		}
	return option;
	}
}
