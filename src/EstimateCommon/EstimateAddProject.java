package EstimateCommon;

import java.sql.*;
import java.util.Scanner;

public class EstimateAddProject extends ConnectDatabase {

	public static void main(String[] args) {
		Connection conn = getConnection();
	    Statement stmt = null;
	    
	    try {
	    	Scanner scan = new Scanner(System.in);
	    	
	    	System.out.println("Enter Project Name:");
	    	String InputProjName = scan.nextLine();
	    	
	    	System.out.println("Enter Project Address:");
	    	String InputProjAddr = scan.nextLine();
	    	
	    	System.out.println("Enter Project Description:");
	    	String InputProjDesc = scan.nextLine();
	    	
	    	System.out.println("Enter Project Cost:");
	    	Double InputProjCost = scan.nextDouble();
	    	
	    	Scanner newscan = new Scanner(System.in);
	    	
	    	System.out.println("Enter Customer First Name:");
	    	String InputProjCustFN = newscan.nextLine();
	    	
	    	System.out.println("Enter Customer Middle Initial:");
	    	String InputProjCustMI = newscan.nextLine();
	    	
	    	System.out.println("Enter Customer Last Name:");
	    	String InputProjCustLN = newscan.nextLine();
	    	
	    	System.out.println("Enter Customer Email:");
	    	String InputProjEmail = newscan.nextLine();

			stmt = conn.createStatement();  
			String sql = "INSERT INTO projectinfo " +
	                     "VALUES (NULL, '"+ InputProjName +"', '"+ InputProjAddr +"', '"+ InputProjDesc +"', '" +
	                     		 InputProjCustFN +"', '" + InputProjCustMI + "', '" + InputProjCustLN + "', '" +
	                     		 InputProjEmail + "', NULL, " + InputProjCost + " )";
			stmt.executeUpdate(sql);

			scan.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
