package IO;

import com.twu.biblioteca.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

// Parses DB
public class DBParser {

	private Connection connection = null;

	public void connectToDB() throws SQLException {
		String url = "jdbc:sqlite:/Users/atulk/Desktop/Assignment/biblioteca/TWU_Biblioteca-master/library.db3";
		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException execption) {
			new Writer().printMessage("Connection failed");

		}
	}
	public Map<Integer,Item> getItemsFromDb(){
		Map<Integer,Item> items=new HashMap<Integer,Item>();
		items .putAll(new BookParser().getBookFromDB(connection));
		items.putAll(new MovieParser().getMovieFromDB(connection));
		return items;
	}

	public Connection getConnection() {
		try {
			connectToDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(connection==null)
			System.out.print("no connection");
		return connection;
	}
}