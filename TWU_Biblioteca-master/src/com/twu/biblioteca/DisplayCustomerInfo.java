package com.twu.biblioteca;

import IO.Writer;

// Displays Customer info
public class DisplayCustomerInfo implements MenuItem {
	private User user;

	public DisplayCustomerInfo(User user) {
		this.user = user;
	}

	@Override
	public OperationStatus execute(Library library) throws ItemNotFound {
		new Writer().printMessage("Name           Email                    PhoneNo");
		new Writer().printMessage(user.getUserDetails());
		return OperationStatus.SUCCESSFUL_DISPLAY;
	}
}
