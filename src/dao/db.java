package dao;

import java.sql.*;

public class db {

	public static Connection getCon() throws ClassNotFoundException, SQLException  {
		

		String dbUrl = "jdbc:mysql://localhost:3306/abay";
		String dbUname = "root";
		String dbPassword ="root";
	
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection	con=DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			return con;
		
		
	}
}