package com.twu.biblioteca;

// Represents a Movie
public class Movie implements Item{

	private int id;
	private String name;
	private int year;
	private String director;
	private int rating;

	public Movie(int id,String name,String director,int year, int rating){
		this.id = id;
		this.name = name;
		this.year = year;
		this.director = director;
		this.rating = rating;
	}

	@Override
	public String getDetails() {
		return String.format("%-5d%-25s%-25s%-7d%-1d\n",id, name,director,year,rating);
	}

	@Override
	public String[] getDetailsForDB() {
		String movieDetails=id+" "+name+" "+director+" "+year+" "+rating;
		return movieDetails.split(" ");
	}
}
