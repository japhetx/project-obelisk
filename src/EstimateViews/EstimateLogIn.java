package EstimateViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;
import java.sql.*;
import java.util.Scanner;

public class EstimateLogIn extends JFrame {

	private JPanel pnlLogIn;
	private JTextField txtUsername;
	private JPasswordField psfPassword;
	private JButton btnLogIn;
	private static Connection conn;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstimateLogIn frame = new EstimateLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EstimateLogIn() {
		initComponents();
		createEvents();
	
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 393);
		pnlLogIn = new JPanel();
		pnlLogIn.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlLogIn);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(132, 200, 289, 34);
		txtUsername.setColumns(10);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(223, 292, 108, 41);
		
		JPanel pnlLogo = new JPanel();
		pnlLogo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlLogo.setBounds(109, 19, 335, 150);
		GroupLayout gl_pnlLogo = new GroupLayout(pnlLogo);
		gl_pnlLogo.setHorizontalGroup(
			gl_pnlLogo.createParallelGroup(Alignment.LEADING)
				.addGap(0, 335, Short.MAX_VALUE)
		);
		gl_pnlLogo.setVerticalGroup(
			gl_pnlLogo.createParallelGroup(Alignment.LEADING)
				.addGap(0, 127, Short.MAX_VALUE)
		);
		pnlLogo.setLayout(gl_pnlLogo);
		pnlLogIn.setLayout(null);
		pnlLogIn.add(txtUsername);
		pnlLogIn.add(btnLogIn);
		pnlLogIn.add(pnlLogo);
		
		psfPassword = new JPasswordField();
		psfPassword.setBounds(132, 246, 289, 34);
		pnlLogIn.add(psfPassword);
		setResizable(false);
	}
	
	private void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			conn = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/systemdb","root","");  
			System.out.println("You made it, take control your database now!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private void createEvents() {
		
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username = txtUsername.getText().toString();
				char[] charPassword = psfPassword.getPassword();
				
				connectDB();
				//getusername and password
				//create query for username to verify that theres something like that
				//verify the password of queried username and password
				
				
				try {
					System.out.println("Creating statement...");
					Statement stmt = conn.createStatement();
					String sql = "SELECT * FROM useraccount WHERE UserName LIKE '%" + Username + "%' ";
					ResultSet rs = stmt.executeQuery(sql);
					
					if(rs.next()){
						String password = rs.getString("UserPassword");
						char[] charUserpassword = password.toCharArray();
						
						if (Arrays.equals(charPassword, charUserpassword)) {
						    System.out.println("Password is correct");
						    dispose();
						    new EstimateProjectList().setVisible(true);
						} else {
						    System.out.println("Incorrect password");
						}
					}
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}

}