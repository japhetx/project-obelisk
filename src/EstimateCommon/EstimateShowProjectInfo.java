package EstimateCommon;

import java.sql.*;
import java.util.Scanner;

public class EstimateShowProjectInfo extends ConnectDatabase {

	public static void main(String[] args) {
		Connection conn = getConnection();
	    Statement stmt = null;
	    
  	  	try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter project name: ");
			String InputProjName = scan.nextLine();
			
			stmt = conn.createStatement();  
			String sql = "SELECT * FROM projectinfo WHERE ProjName LIKE '%" + InputProjName + "%' ";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String PNAME = rs.getString("ProjName");
				String PADDR = rs.getString("ProjAddr");
				
				String PCFN = rs.getString("ProjCustFN");
				String PCMI = rs.getString("ProjCustMI");
				String PCLN = rs.getString("ProjCustLN");
				String PCEM = rs.getString("ProjEmail");
				
				Double PCOST = rs.getDouble("ProjectCost");
				
				System.out.println("Project Info: \n");
				
				System.out.println("Project Name: " + PNAME);
				System.out.println("Project Address: " + PADDR);
				System.out.println("Project Cost: " + PCOST);
				
				System.out.println("\nCustomer Info: \n");
				
				System.out.println("Customer Name: " + PCFN + " " + PCMI + " " + PCLN);
				System.out.println("Customer Email: " + PCEM);
			} else {
				System.out.println("Invalid project name!");
			}
			scan.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
