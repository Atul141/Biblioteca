package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//
public class Library {

	public enum Type {
		BOOK, MOVIE;
	}
	Map<Integer,Item> availableItems;
	Map<Integer,Item> checkedOutItems=new HashMap<Integer, Item>();


	public Library(Map<Integer,Item> availableItems) {
		this.availableItems = availableItems;
		addMovies();
	}

	private void addMovies() {

		Movie movie1=new Movie(1,"2012","Roland",2011,6);
		Movie movie2=new Movie(2,"White House Down","Roland",2008,7);
		Movie movie3=new Movie(3,"Black Hawk Down","Rediley",2005,8);

		availableItems.put(11,movie1);
		availableItems.put(12,movie2);
		availableItems.put(13,movie3);
	}

	public List<String> printBookList(Type type) {

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


	public Item checkout(int id) throws ItemNotFound {
		if (availableItems.containsKey(id)) {
			Item item = availableItems.remove(id);
			checkedOutItems.put(id,item);
			return item;
		}
		throw new ItemNotFound();
	}

	public Item returnBook(int id) throws ItemNotFound {
		if (checkedOutItems.containsKey(id)) {
			Item item = checkedOutItems.remove(id);
			availableItems.put(id,item);

			return item;
		}
		throw new ItemNotFound();
	}

}