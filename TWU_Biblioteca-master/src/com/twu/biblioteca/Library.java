package com.twu.biblioteca;

import com.sun.javafx.collections.MappingChange;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//
public class Library {

	private Map<Integer, Item> checkOutedItems;

	public Map<Integer,Item> getItems() {
		return availableItems;
	}

	public Map<Integer, Item> getCheckOutedItems() {
		return checkOutedItems;
	}


	public enum Type {
		BOOK, MOVIE;
	}

	Map<Integer, Item> availableItems;
	Map<Integer, Item> checkedOutItems = new HashMap<Integer, Item>();
	Map<Book, User> checkedOutbooks = new HashMap<Book, User>();

	public Library(Map<Integer, Item> availableItems) {
		this.availableItems = availableItems;
	}
	public List<String> printItems(Type type) {

		List<String> itemDetails = new ArrayList<String>();
		for (Item item : availableItems.values()) {
			if (type == Type.BOOK) {
				if (item.getClass() == Book.class)
					itemDetails.add(item.getDetails());
			}
			if (type == Type.MOVIE) {
				if (item.getClass() == Movie.class)
					itemDetails.add(item.getDetails());
			}
		}
		return itemDetails;
	}

	public Item checkout(int id, User user) throws ItemNotFound {
		if (availableItems.containsKey(id)) {
			Item item = availableItems.remove(id);
			checkedOutItems.put(id, item);
			try {
				mapUserWIthBook(user, (Book) item);
			} catch (ClassCastException e) {

			}
			return item;
		}
		throw new ItemNotFound();
	}
	private void mapUserWIthBook(User user, Book item) {
		try {
			checkedOutbooks.put(item, user);
		} catch (ClassCastException e) {
		}
	}

	public Item returnBook(int id) throws ItemNotFound {
		if (checkedOutItems.containsKey(id)) {
			Item item = checkedOutItems.remove(id);
			availableItems.put(id, item);
			return item;
		}
		throw new ItemNotFound();
	}

	public Map<Book, User> getCheckedOutbooks() {

		return checkedOutbooks;
	}

}
