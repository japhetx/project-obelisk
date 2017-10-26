package EstimateCommon;

import java.sql.*;

public class ConnectDatabase {
	
	private static Connection conn;
	
	 public static Connection getConnection() {
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	   String url = "jdbc:mysql://localhost:3306/systemdb";
	   String name = "root";
	   String password = "";
	   
	   try {
		   conn = DriverManager.getConnection(url, name, password);
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return conn;
	 }
}