package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

//
public class LibraryItem {
	enum Type {
		BOOK, MOVIE;
	}

	private Type type;
	private Menu menu;
	Map<Integer, Item> availableItems;
	Map<Integer, Item> checkedOutItems= new HashMap<Integer,Item>();

	public LibraryItem(Menu menu, Map<Integer, Item> availableItems, Type type) {
		this.menu = menu;
		this.availableItems = availableItems;
		this.type = type;
	}
	public Item checkout(int ISBN) throws BookNotFoundExemption {
		if (availableItems.containsKey(ISBN)) {
			Item item = availableItems.remove(ISBN);
			checkedOutItems.put(ISBN,item);
			return item;
		}
		throw new BookNotFoundExemption();
	}

}