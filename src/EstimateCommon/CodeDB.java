/*import java.sql.*;
import java.util.Scanner;

class TestDB {
	
	public static void main(String[] args) {
		
		System.out.println("-------- MySQL JDBC Connection Testing ------------");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/systemdb","root","");  
			System.out.println("You made it, take control your database now!");
			
			/*
			System.out.println("Creating statement...");
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM workersinfo";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Output Query...");
			while (rs.next()) {
				  String lastName = rs.getString("WorkersLN");
				  Double salary = rs.getDouble("WorkersSalr");
				  System.out.println(lastName + "\n" + salary + "0");
			}
			*/
			
			/*
			System.out.println("Creating statement...");
			Statement stmt = con.createStatement();	
			String sql = "INSERT INTO workersinfo " + 
						 "VALUES (NULL, 'Japhet Mert', 'C', 'Obsioma'," +
						 "'Arrieta Subd Batangas City', 'Programmers', '1200')";
			stmt.executeUpdate(sql);
			System.out.println("Successful...");
			*/
			
			/*
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter First Name: ");
			String FN = scan.nextLine();
			 
			System.out.println("Enter Middle Initial: ");
			String MI = scan.nextLine();
			 
			System.out.println("Enter Last Name: ");
			String LN = scan.nextLine();
			 
			System.out.println("Enter Address: ");
			String AD = scan.nextLine();
			 
			System.out.println("Enter Your Work Role: ");
			String WR = scan.nextLine();
			 
			System.out.println("Enter Your Work Salary: ");
			int WS = scan.nextInt();
			 
			scan.close();
			
			System.out.println("Creating statement...");
			Statement stmt = con.createStatement();	
			String sql = "INSERT INTO workersinfo " + 
						 "VALUES (NULL, '" + FN + "', '" + MI + "', '" + LN + "'," +
						 "'" + AD + "', '" + WR + "', '" + WS + "')";
			stmt.executeUpdate(sql);
			System.out.println("Successful...");
			*/
			
			/*
			System.out.println("Creating statement...");
			Statement stmt = con.createStatement();	
			String sql = "UPDATE workersinfo " + 
						 "SET WorkersFN = 'CHECHEVAR FOREVER LODI PETMALU' WHERE WorkersID = '1'" ;
			stmt.executeUpdate(sql);
			System.out.println("Successful...");
			*/
			
			/*
			System.out.println("Creating statement...");
			Statement stmt = con.createStatement();
			Statement stmttwo = con.createStatement();
			String sql = "SELECT * FROM workersinfo";;
			ResultSet rs = stmt.executeQuery(sql);
			
			int x = 1;
			while(rs.next()) {
				  int workid = rs.getInt("WorkersID");
				  System.out.println(workid + " " + x);
				  sql = "UPDATE workersinfo" + " SET WorkersID = '" +
						x + "' WHERE WorkersID = '" + workid + "'";
				  stmttwo.executeUpdate(sql);
				  x++;
			}
			System.out.println("Successful...");
			*/
			
			/*
			System.out.println("Creating statement...");
			Statement stmt = con.createStatement();
			String sql = "DELETE FROM workersinfo " +
						 "WHERE WorkersID = 2";
			stmt.executeUpdate(sql);
			System.out.println("Successful...");
			*/
			
			/*
			Scanner scan = new Scanner(System.in);
			System.out.println("Search First Name: ");
			String Search = scan.nextLine();
			
			System.out.println("Creating statement...");
			Statement stmt = con.createStatement();
			String sql = "SELECT WorkersID, WorkersFN, WorkersMI, WorkersLN  FROM workersinfo" +
	                   " WHERE WorkersFN LIKE '%"+ Search +"%' ";
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    if(rs.next()) {
		    	int WD = rs.getInt("WorkersID");
		    	String FN = rs.getString("WorkersFN");
		    	String MI = rs.getString("WorkersMI");
		    	String LN = rs.getString("WorkersLN");
		    	
		        System.out.print("ID: " + WD + "\n");
		        System.out.print("First Name: " + FN + "\n");
		        System.out.print("Middle Initial: " + MI + "\n");
		        System.out.println("Last Name: " + LN + "\n");
		    } else {
		    	System.out.println("First Name not found" + "\n");
		    }
		    
		    System.out.println("Successful...");
		    rs.close();
		    
		    
			con.close();
		} catch(Exception e){ 
				System.out.println(e);
		}
		
	}  
	
}*/