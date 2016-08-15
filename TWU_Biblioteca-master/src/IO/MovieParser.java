package IO;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Parses Movies from db
 */
public class MovieParser {

	public Map<Integer,Item> getMovieFromDB(Connection connection){
		Map<Integer,Item> books=new HashMap<Integer,Item>();
		Statement statement=null;
		ResultSet set=null;
		try{
			statement= connection.createStatement();
			set=statement.executeQuery("Select * from Movie;");
			while(set.next()){
				int id=set.getInt("ID");
				String name=set.getString("name");
				String director=set.getString("director");
				int year=set.getInt("year");
				int rating=set.getInt("rating");
				books.put(id,new Movie(id,name,director,year,rating));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeStatement(statement);
			closeResultSet(set);
		}

		return books;
	}

	private void closeResultSet(ResultSet set) {
		if(set!=null)
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	private void closeStatement(Statement statement) {
		if(statement!=null)
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
