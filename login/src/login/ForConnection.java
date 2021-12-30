package login;

import java.sql.*;

public class ForConnection {
	
	String url = "jdbc:mysql:/connectdb";
	Connection connection = null;
	Statement statement = null;
	ResultSet result = null;
	
	ForConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root", "47TYdndryj");
		}
		catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
