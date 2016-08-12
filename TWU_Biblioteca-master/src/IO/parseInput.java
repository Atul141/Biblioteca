package IO;


import com.twu.biblioteca.Book;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Parses the input file
public class parseInput {


	Map<Integer,Item> createMapOfBooks(List<String> listOfBooks) {
		Map<Integer,Item> mapOfBooks = new HashMap<Integer,Item>();
		for (String bookString : listOfBooks) {
			String[] bookDetails = bookString.split(",");
			int ISBN = Integer.parseInt(bookDetails[0]);
			int year = Integer.parseInt(bookDetails[3]);
			String bookName = bookDetails[1];
			String authorName = bookDetails[2];
			mapOfBooks.put(ISBN, new Book(ISBN, bookName, authorName, year));
		}
		return mapOfBooks;
	}

	Map<Integer,Movie> createMapOfMovies(List<String> listOfMovie){
		Map<Integer,Movie>  movies=new HashMap<Integer, Movie>();
		for(String movieString:listOfMovie){
			String[] movieDetails=movieString.split(",");
			int id=Integer.parseInt(movieDetails[0]);
			int year=Integer.parseInt(movieDetails[3]);
			int rating=Integer.parseInt(movieDetails[4]);
			String movieName=movieDetails[1];
			String movieDirector=movieDetails[2];
			movies.put(id,new Movie(id,movieName,movieDirector,year,rating));
		}
	return movies;
	}
}
