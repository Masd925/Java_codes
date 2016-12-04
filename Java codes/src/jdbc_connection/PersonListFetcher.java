package jdbc_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonListFetcher {
	
	public List<Person> fetch () {
		List<Person> list = null;
		Connection conn = null;
		String sql = "SELECT * FROM person";
		try {
	        conn = new Connector().connect();
	        if (conn != null) {
	        	PreparedStatement ps = conn.prepareStatement(sql);
	        	ResultSet rs = ps.executeQuery();
	        	if (rs.isBeforeFirst()) {
	        		list = new ArrayList<Person>();
	        		while(rs.next()) {
	        			list.add(new Person(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("phone_number")));
	        		}
	        	}
	        	ps.close();
	        	conn.close();
	        }
		}
		catch (SQLException sqlE) {
			System.out.println("Problem executing sql query.");
		}
		finally {
			
		}
		return list;
	}
	
	
	
}

/*

	
	
*/