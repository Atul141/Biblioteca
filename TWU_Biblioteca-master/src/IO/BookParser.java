package IO;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * For Parsing Book
 */
public class BookParser {

public Map<Integer,Item> getBookFromDB(Connection connection){
	Map<Integer,Item> books=new HashMap<Integer,Item>();
	Statement statement=null;
	ResultSet set=null;
	try{
		statement= connection.createStatement();
		set=statement.executeQuery("Select * from Book;");
		while(set.next()){
			int id=set.getInt("id");
			String name=set.getString("name");
			String author=set.getString("author");
			int year=set.getInt("year");
			books.put(id,new Book(id,name,author,year));
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
