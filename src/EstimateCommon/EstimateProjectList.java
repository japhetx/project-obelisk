package EstimateCommon;

import java.sql.*;

public class EstimateProjectList extends ConnectDatabase {

	public static void main(String[] args) {
		Connection conn = getConnection();
	    Statement stmt = null;	
	    
	    try {
			System.out.println("Show the list of projects: \n\n");
			
			stmt = conn.createStatement();  
			String sql = "SELECT * FROM projectinfo ";
			ResultSet rs = stmt.executeQuery(sql);
			
	      while(rs.next()){
	          String PNAME = rs.getString("ProjName");
	          String PADDR = rs.getString("ProjAddr");
	
	          String PCFN = rs.getString("ProjCustFN");
	          String PCMI = rs.getString("ProjCustMI");
	          String PCLN = rs.getString("ProjCustLN");
	          
	          System.out.println("Project Name: " + PNAME);
	          System.out.println("Project Address: " + PADDR);
	          System.out.println("Customer Name: " + PCFN + " " + PCMI + " " + PCLN);
	      }
	      rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
