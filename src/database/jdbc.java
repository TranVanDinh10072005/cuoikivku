package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
	public static Connection getConnection() {
		Connection c= null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String url = "jdbc:mySQL://localhost:3306/thuebao";
			String username = "root";
			String pass = "";
			
			c = DriverManager.getConnection(url, username, pass);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}
    public static void closeConnection(Connection c) {
    	try {
    		if(c!=null) {
    			c.close();
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
}
