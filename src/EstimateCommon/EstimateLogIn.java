/*package EstimateCommon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EstimateLogIn extends ConnectDatabase{

	public static void main(String[] args) {
		Connection conn = getConnection();
	    Statement stmt = null;
	   	      
      try {
    	  Scanner scan = new Scanner(System.in);
		  System.out.println("Username: ");
		  String InputUserName = scan.nextLine();
		  System.out.println("Password: ");
		  String InputPassword = scan.nextLine();
		
    	  
		  stmt = conn.createStatement();  
		  String sql = "SELECT * FROM useraccount " +
		           "WHERE UserName = '" + InputUserName + "' AND UserPassword = '" + InputPassword +"'";
		  ResultSet rs = stmt.executeQuery(sql);
		
		  if(rs.next()) {
			System.out.println("Welcome User!");
		  } else {
			System.out.println("Invalid Username and Password!");
		  }
		  
		  scan.close();
		  rs.close();
      } catch (SQLException e) {
    	  e.printStackTrace();
      }
	      
	   System.out.println("Goodbye!");
	}
}*/
