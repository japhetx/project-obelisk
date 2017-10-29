package EstimateViews;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PayrollMain extends JFrame {

	private JPanel ctpMainPane;
	private JTextField txtDate;
	private JTable tblAttendance;
	private JTextField txtBeginDate;
	private JTextField txtEndDate;
	private JTable tblAPayroll;
	private JTable tblWorkers;
	private JButton btnCurrentDate;
	private JButton btnSearch;
	private JButton btnAttendanceSave;
	public static String Input;
	public static Connection conn;
	public static Statement stmt;
	public static String sql;
	public static ResultSet rs;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollMain frame = new PayrollMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PayrollMain() {
		initComponents();
		createEvents();
	}

	private void initComponents() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			conn = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/systemdb","root","");  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 734);
		ctpMainPane = new JPanel();
		ctpMainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMainPane);
		ctpMainPane.setLayout(null);
		
		JTabbedPane tbPane = new JTabbedPane(JTabbedPane.TOP);
		tbPane.setBounds(16, 15, 772, 643);
		ctpMainPane.add(tbPane);
		
		JPanel pnlAttendance = new JPanel();
		pnlAttendance.setBackground(new Color(179, 200, 219));
		tbPane.addTab("Attendance", null, pnlAttendance, null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String GetDate = txtDate.getText().toString();
				System.out.println(GetDate);
				try {
					sql = "SELECT workersattendance.*, workersinfo.* FROM workersattendance "
							+ "INNER JOIN workersinfo ON workersattendance.WorkersID = workersinfo.WorkersID "
							+ "WHERE workersattendance.AttendDate = '"+ GetDate+"'";
					rs = stmt.executeQuery(sql);
					
					while(rs.next()){
						String WorkersName = rs.getString("WorkerName");
						System.out.println(WorkersName);
						int WorkAM = rs.getInt("WorkAM");
						boolean AM;
						boolean PM;
						if (WorkAM == 1){ 
							AM = Boolean.TRUE;
						} else {
							AM = Boolean.FALSE;
						}
						
						int WorkPM = rs.getInt("WorkPM");
						if (WorkPM == 1){ 
							PM = Boolean.TRUE;
						} else {
							PM = Boolean.FALSE;
						}
						
						System.out.println(AM);
						System.out.println(PM);

						// Clear Table
						DefaultTableModel model = (DefaultTableModel)tblAttendance.getModel();
						model.setRowCount(0);
						model.addRow(new Object[]{WorkersName, AM, PM});
						// Show to table
						
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDate.setColumns(10);
		
		// SHOW CURRENT DATE
		
		Date myDate = new Date();
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dmy = dmyFormat.format(myDate);
		txtDate.setText(dmy);
		
		// FIN
		
		
		btnCurrentDate = new JButton("Current Date");

		
		JScrollPane scrAttendance = new JScrollPane();
		
		btnAttendanceSave = new JButton("Save");
		btnAttendanceSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Name = null;
				Name = (String) tblAttendance.getValueAt(0, 0);
				System.out.println(Name);
				
				Input = "HI";
				boolean test = Boolean.TRUE;
				tblAttendance.setModel(new DefaultTableModel(
						new Object[][] {
							{Input, test, Boolean.TRUE},
						},
						new String[] {
							"Workers Name", "AM", "PM"
						}
					){
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
						Object.class, Boolean.class, Boolean.class
					};
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						false, true, true
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				
			}
		});
		
		GroupLayout gl_pnlAttendance = new GroupLayout(pnlAttendance);
		gl_pnlAttendance.setHorizontalGroup(
			gl_pnlAttendance.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlAttendance.createSequentialGroup()
					.addContainerGap(50, Short.MAX_VALUE)
					.addGroup(gl_pnlAttendance.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlAttendance.createSequentialGroup()
							.addComponent(lblDate)
							.addGap(20)
							.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(btnCurrentDate))
						.addGroup(gl_pnlAttendance.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnAttendanceSave)
							.addComponent(scrAttendance, GroupLayout.PREFERRED_SIZE, 681, GroupLayout.PREFERRED_SIZE)))
					.addGap(36))
		);
		gl_pnlAttendance.setVerticalGroup(
			gl_pnlAttendance.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAttendance.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_pnlAttendance.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlAttendance.createSequentialGroup()
							.addGap(4)
							.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlAttendance.createSequentialGroup()
							.addGap(1)
							.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnSearch)
						.addComponent(btnCurrentDate))
					.addGap(28)
					.addComponent(scrAttendance, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAttendanceSave)
					.addGap(19))
		);
		
		tblAttendance = new JTable();
		tblAttendance.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Workers Name", "AM", "PM"
			}
		));
		tblAttendance.getColumnModel().getColumn(0).setResizable(false);
		tblAttendance.getColumnModel().getColumn(1).setResizable(false);
		tblAttendance.getColumnModel().getColumn(2).setResizable(false);
		scrAttendance.setViewportView(tblAttendance);
		pnlAttendance.setLayout(gl_pnlAttendance);
		
		
		JPanel pnlPayroll = new JPanel();
		pnlPayroll.setBackground(new Color(179, 200, 219));
		tbPane.addTab("Payroll", null, pnlPayroll, null);
		
		JLabel lblPeriodCovered = new JLabel("Period Covered");
		
		txtBeginDate = new JTextField();
		txtBeginDate.setText("Monday, 23 October 2017");
		txtBeginDate.setColumns(10);
		
		txtEndDate = new JTextField();
		txtEndDate.setText("Saturday, 28 October 2017");
		txtEndDate.setColumns(10);
		
		JScrollPane scrPayroll = new JScrollPane();
		GroupLayout gl_pnlPayroll = new GroupLayout(pnlPayroll);
		gl_pnlPayroll.setHorizontalGroup(
			gl_pnlPayroll.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPayroll.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_pnlPayroll.createParallelGroup(Alignment.LEADING)
						.addComponent(scrPayroll, GroupLayout.PREFERRED_SIZE, 666, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlPayroll.createSequentialGroup()
							.addComponent(lblPeriodCovered)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtBeginDate, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(txtEndDate, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		gl_pnlPayroll.setVerticalGroup(
			gl_pnlPayroll.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPayroll.createSequentialGroup()
					.addGroup(gl_pnlPayroll.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlPayroll.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_pnlPayroll.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPeriodCovered)
								.addComponent(txtBeginDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlPayroll.createSequentialGroup()
							.addGap(49)
							.addComponent(txtEndDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrPayroll, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		tblAPayroll = new JTable();
		tblAPayroll.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Workers Name", "Gross Salary", "Net Salary"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblAPayroll.getColumnModel().getColumn(0).setResizable(false);
		tblAPayroll.getColumnModel().getColumn(1).setResizable(false);
		tblAPayroll.getColumnModel().getColumn(2).setResizable(false);
		scrPayroll.setViewportView(tblAPayroll);
		pnlPayroll.setLayout(gl_pnlPayroll);
		
		JPanel pnlWorkers = new JPanel();
		pnlWorkers.setBackground(new Color(179, 200, 219));
		tbPane.addTab("Workers", null, pnlWorkers, null);
		
		JScrollPane scrWorkers = new JScrollPane();
		
		JButton btnDelete = new JButton("Delete");
		
		JButton btnEdit = new JButton("Edit");
		
		JButton btnNew = new JButton("New");
		GroupLayout gl_pnlWorkers = new GroupLayout(pnlWorkers);
		gl_pnlWorkers.setHorizontalGroup(
			gl_pnlWorkers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlWorkers.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_pnlWorkers.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrWorkers, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlWorkers.createSequentialGroup()
							.addComponent(btnNew)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEdit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_pnlWorkers.setVerticalGroup(
			gl_pnlWorkers.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlWorkers.createSequentialGroup()
					.addGap(41)
					.addComponent(scrWorkers, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_pnlWorkers.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(btnEdit)
						.addComponent(btnNew))
					.addGap(26))
		);
		
		tblWorkers = new JTable();
		tblWorkers.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Workers Name", "Position", "Rate"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblWorkers.getColumnModel().getColumn(0).setResizable(false);
		tblWorkers.getColumnModel().getColumn(1).setResizable(false);
		tblWorkers.getColumnModel().getColumn(2).setResizable(false);
		scrWorkers.setViewportView(tblWorkers);
		pnlWorkers.setLayout(gl_pnlWorkers);
		
		JPanel pnlReport = new JPanel();
		pnlReport.setBackground(new Color(179, 200, 219));
		tbPane.addTab("Report", null, pnlReport, null);
		
		JComboBox cmbSelectReport = new JComboBox();
		cmbSelectReport.setModel(new DefaultComboBoxModel(new String[] {"Attendance", "Payroll"}));
		
		JButton btnShowReport = new JButton("Show Report");
		
		JLabel lblReportView = new JLabel("Report View");
		
		JScrollPane scrReportView = new JScrollPane();
		
		JButton btnEmail = new JButton("Send via Email");
		
		JButton btnPrint = new JButton("Print");
		
		JButton btnSave = new JButton("Save");
		GroupLayout gl_pnlReport = new GroupLayout(pnlReport);
		gl_pnlReport.setHorizontalGroup(
			gl_pnlReport.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlReport.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_pnlReport.createParallelGroup(Alignment.LEADING)
						.addComponent(lblReportView)
						.addGroup(gl_pnlReport.createSequentialGroup()
							.addComponent(cmbSelectReport, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnShowReport))
						.addGroup(gl_pnlReport.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_pnlReport.createSequentialGroup()
								.addComponent(btnSave)
								.addGap(18)
								.addComponent(btnPrint)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnEmail))
							.addComponent(scrReportView, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		gl_pnlReport.setVerticalGroup(
			gl_pnlReport.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlReport.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_pnlReport.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbSelectReport, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShowReport))
					.addGap(29)
					.addComponent(lblReportView)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrReportView, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_pnlReport.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEmail)
						.addComponent(btnPrint)
						.addComponent(btnSave))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		JPanel pnlReporView = new JPanel();
		scrReportView.setViewportView(pnlReporView);
		pnlReport.setLayout(gl_pnlReport);
		
	}

	private void createEvents() {
		btnCurrentDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// SHOW CURRENT DATE
				
				Date myDate = new Date();
				SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dmy = dmyFormat.format(myDate);
				txtDate.setText(dmy);
				
				// FIN
				
				
				
			}
		});
		
		
	}
}
