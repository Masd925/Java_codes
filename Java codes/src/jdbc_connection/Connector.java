package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
	public Connection connect() throws SQLException {
		Connection conn = null;
		String JDBCdriver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/person_info";
	    
		try {
			Class.forName(JDBCdriver);
			conn = DriverManager.getConnection(url, "USER", "salainen"); // Would not be stored on the code really.
		}
		catch (SQLException sqlE) {
			System.err.println("Problem opening database connection.");
			throw(sqlE);
		}
		catch (ClassNotFoundException cnf) {
			System.err.println("Database driver not found.");
			throw (new SQLException("Database driver not found."));
		}
		return conn;
	}
}
