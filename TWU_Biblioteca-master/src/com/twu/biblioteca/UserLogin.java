package com.twu.biblioteca;

import  IO.Writer;
import IO.Reader;
//
public class UserLogin implements MenuItem {

	private static int USER_ID=0000;
	private static String PASSWORD="Hello";
	private Writer writer=new Writer();
	private Reader reader=new Reader();


	private void authenticatePassword() {
		writer.printMessage("Enter your Password");
		String password = reader.receiveString();
		if(password==PASSWORD){
		new subMenu();
		}
		else{
			writer.printMessage("Wrong password");
			System.exit(0);
		}
	}

	@Override
	public OperationStatus execute(Library library) throws ItemNotFound {

			writer.printMessage("Enter your User Id");
			int userId=reader.receiveInput();
			if(USER_ID==userId) {
				authenticatePassword();
			}
			else
			{
				writer.printMessage("Invalid UserID");
				System.exit(0);
			}

		return OperationStatus.SUCCESSFUL_LOGIN;
	}
}
