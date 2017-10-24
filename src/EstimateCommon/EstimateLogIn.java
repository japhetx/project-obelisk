package EstimateCommon;

import java.sql.*;

public class EstimateLogIn {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/systemdb1";

	static final String USER = "root";
	static final String PASS = "";
	
	public static void main(String[] args) {
	   Connection conn = null;
	   try{    
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	   }catch(SQLException se){ 
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }finally{
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	   System.out.println("Goodbye!");
	}
}
