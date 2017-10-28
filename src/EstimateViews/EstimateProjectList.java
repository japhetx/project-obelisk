package EstimateViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Color;

public class EstimateProjectList extends JFrame {

	private JPanel contentPane;
	private static Connection conn;
	private DefaultListModel<String> modelAddList = new DefaultListModel();
	private JList list;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstimateProjectList frame = new EstimateProjectList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EstimateProjectList() {
		initComponents();
		createEvents();
		
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList();
		list.setBounds(59, 42, 447, 378);
		contentPane.add(list);
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
		connectDB();
		
		
		list.setModel(modelAddList);
		JList<String> jAddList = new JList<>(modelAddList);
		
		try {
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM projectinfo";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String PNAME = rs.getString("ProjName");
				modelAddList.addElement(PNAME);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}