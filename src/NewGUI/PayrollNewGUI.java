package NewGUI;	

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class PayrollNewGUI extends JFrame {
	
	private final JPanel pnlMenu = new JPanel();
	private JMenu mnAccount;
	private JMenu mnProject;
	private JMenu mnSettings;
	private JMenu mnAbout;
	private JMenuItem mntmSwitchAccount;
	private JMenuItem mntmLogOut;
	private JMenuItem mntmSwitchProject;
	private JMenuItem mntmSettingsGoesHere;
	private JMenuItem mntmAbout;
	private JButton btnAttendance;
	private JButton btnReport;
	private JButton btnPayroll;
	private JButton btnWorkers;
	private JTabbedPane tbpView;
	private JPanel pnlAttendanceTitle;
	private JLabel lblAttendance;
	private JPanel pnlPayrollTitle;
	private JLabel lblPayroll;
	private JPanel pnlWorkersTitle;
	private JLabel lblWorkers;
	private JPanel pnlReportTitle;
	private JLabel lblReport;
	private JPanel pnlAttendanceMain;
	private JPanel pnlDate;
	private JLabel lblJun;
	private JLabel lblNewLabel;
	private JPanel pnlWorkersTable;
	private JScrollPane scrollPane;
	private JButton btnSave;
	private JTable tblWorkersTable;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollNewGUI frame = new PayrollNewGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PayrollNewGUI() {
		
		initComponents();
		createEvents();
		
	}

	private void initComponents() {
		
		//Main Panel
		setTitle("Payroll Management System • Attendance");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1080, 650);
		setLocationRelativeTo(null);
		
		//Top Menu Bar
		JMenuBar mnbTopMenubar = new JMenuBar();
		setJMenuBar(mnbTopMenubar);
		
		mnAccount = new JMenu("Account");
		mnAccount.setBorderPainted(true);
		mnbTopMenubar.add(mnAccount);
		
		mntmSwitchAccount = new JMenuItem("Switch Account");
		mnAccount.add(mntmSwitchAccount);
		
		mntmLogOut = new JMenuItem("Log Out");
		mnAccount.add(mntmLogOut);
		
		mnProject = new JMenu("Project");
		mnbTopMenubar.add(mnProject);
		
		mntmSwitchProject = new JMenuItem("Switch Project");
		mnProject.add(mntmSwitchProject);
		
		mnSettings = new JMenu("Settings");
		mnbTopMenubar.add(mnSettings);
		
		mntmSettingsGoesHere = new JMenuItem("Settings Goes Here");
		mnSettings.add(mntmSettingsGoesHere);
		
		mnAbout = new JMenu("Help");
		mnbTopMenubar.add(mnAbout);
		
		mntmAbout = new JMenuItem("About");
		mnAbout.add(mntmAbout);
		JPanel ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);
		ctpMain.setLayout(null);
		
		//User Info Panel
		JPanel pnlUserInfo = new JPanel();
		pnlUserInfo.setBackground(new Color(238,238,238));
		pnlUserInfo.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlUserInfo.setBounds(-6, -8, 218, 196);
		ctpMain.add(pnlUserInfo);
		pnlUserInfo.setLayout(null);
		
		JLabel lblUsername = new JLabel("Japhet Mert Obsioma");
		lblUsername.setBackground(Color.DARK_GRAY);
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setBounds(31, 154, 173, 16);
		pnlUserInfo.add(lblUsername);
		
		JLabel lblUserEmail = new JLabel("jpmrobsioma@gmail.com");
		lblUserEmail.setBackground(Color.LIGHT_GRAY);
		lblUserEmail.setForeground(Color.GRAY);
		lblUserEmail.setBounds(31, 170, 173, 16);
		pnlUserInfo.add(lblUserEmail);
		
		JLabel lblUserPicture = new JLabel("");
		lblUserPicture.setIcon(new ImageIcon(PayrollNewGUI.class.getResource("/resources/UserPhoto_Men.png")));
		lblUserPicture.setBackground(Color.LIGHT_GRAY);
		lblUserPicture.setForeground(Color.GRAY);
		lblUserPicture.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblUserPicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPicture.setBounds(31, 27, 120, 120);
		pnlUserInfo.add(lblUserPicture);
		
		//Menu Panel
		pnlMenu.setBackground(new Color(238,238,238));
		pnlMenu.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlMenu.setBounds(-3, 187, 215, 404);
		ctpMain.add(pnlMenu);
		
		//Menu Panel Buttons
		btnAttendance = new JButton("Attendance");
		btnAttendance.setSelected(true);
		btnAttendance.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAttendance.setMargin(new Insets(0, 10, 0, 0));
		btnAttendance.setHorizontalAlignment(SwingConstants.LEADING);
		btnAttendance.setIconTextGap(20);
		btnAttendance.setIcon(new ImageIcon(PayrollNewGUI.class.getResource("/resources/attendance.png")));
		btnAttendance.setBackground(new Color(46,125,50));
		btnAttendance.setForeground(Color.WHITE);
	
		btnPayroll = new JButton("Payroll");
		btnPayroll.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnPayroll.setMargin(new Insets(0, 10, 0, 0));
		btnPayroll.setHorizontalAlignment(SwingConstants.LEADING);
		btnPayroll.setIconTextGap(20);
		btnPayroll.setIcon(new ImageIcon(PayrollNewGUI.class.getResource("/resources/payroll.png")));
		btnPayroll.setBackground(new Color(198,40,40));
		btnPayroll.setForeground(Color.WHITE);
		
		btnWorkers = new JButton("Workers");
		btnWorkers.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnWorkers.setMargin(new Insets(0, 10, 0, 0));
		btnWorkers.setHorizontalAlignment(SwingConstants.LEADING);
		btnWorkers.setIconTextGap(20);
		btnWorkers.setIcon(new ImageIcon(PayrollNewGUI.class.getResource("/resources/workers.png")));
		btnWorkers.setBackground(new Color(21,101,192));
		btnWorkers.setForeground(Color.WHITE);
		
		btnReport = new JButton("Report");
		btnReport.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnReport.setMargin(new Insets(0, 10, 0, 0));
		btnReport.setHorizontalAlignment(SwingConstants.LEADING);
		btnReport.setIconTextGap(20);
		btnReport.setIcon(new ImageIcon(PayrollNewGUI.class.getResource("/resources/report.png")));
		btnReport.setBackground(new Color(40,53,147));
		btnReport.setForeground(Color.WHITE);

		
		//Group Layout
		GroupLayout gl_pnlMenu = new GroupLayout(pnlMenu);
		gl_pnlMenu.setHorizontalGroup(
			gl_pnlMenu.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlMenu.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addGroup(gl_pnlMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlMenu.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnAttendance, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnReport, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnPayroll, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnWorkers, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);
		gl_pnlMenu.setVerticalGroup(
			gl_pnlMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlMenu.createSequentialGroup()
					.addGap(12)
					.addComponent(btnAttendance, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnPayroll, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btnWorkers, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnReport, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(181, Short.MAX_VALUE))
		);
		gl_pnlMenu.linkSize(SwingConstants.VERTICAL, new Component[] {btnAttendance, btnPayroll, btnWorkers, btnReport});
		gl_pnlMenu.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnAttendance, btnPayroll, btnWorkers, btnReport});
		pnlMenu.setLayout(gl_pnlMenu);
		
		//Tabbed Panel
		tbpView = new JTabbedPane(JTabbedPane.LEFT);
		tbpView.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tbpView.setBounds(113, -6, 955, 597);
		ctpMain.add(tbpView);
		
		//Attendance Panel
		JPanel pnlAttendance = new JPanel();
		pnlAttendance.setBackground(new Color(245,245,245));
		tbpView.addTab("Attendance", null, pnlAttendance, null);
		
		pnlAttendanceTitle = new JPanel();
		pnlAttendanceTitle.setBackground(new Color(76,175,80));
		pnlAttendanceTitle.setBorder(null);
		
		pnlAttendanceMain = new JPanel();
		
		GroupLayout gl_pnlAttendance = new GroupLayout(pnlAttendance);
		gl_pnlAttendance.setHorizontalGroup(
			gl_pnlAttendance.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlAttendance.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlAttendance.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlAttendanceTitle, GroupLayout.PREFERRED_SIZE, 876, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_pnlAttendance.createSequentialGroup()
							.addComponent(pnlAttendanceMain, GroupLayout.PREFERRED_SIZE, 763, GroupLayout.PREFERRED_SIZE)
							.addGap(56))))
		);
		gl_pnlAttendance.setVerticalGroup(
			gl_pnlAttendance.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAttendance.createSequentialGroup()
					.addComponent(pnlAttendanceTitle, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(pnlAttendanceMain, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		pnlAttendanceMain.setLayout(null);
		
		pnlDate = new JPanel();
		pnlDate.setBackground(new Color(76,175,80));
		pnlDate.setBounds(0, 0, 322, 471);
		pnlAttendanceMain.add(pnlDate);
		
		lblJun = new JLabel("November", SwingConstants.CENTER);
		lblJun.setFont(new Font("SansSerif", Font.PLAIN, 50));
		lblJun.setForeground(Color.WHITE);
		
		lblNewLabel = new JLabel("30", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 200));
		lblNewLabel.setForeground(Color.WHITE);
		GroupLayout gl_pnlDate = new GroupLayout(pnlDate);
		gl_pnlDate.setHorizontalGroup(
			gl_pnlDate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDate.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_pnlDate.createParallelGroup(Alignment.LEADING)
						.addComponent(lblJun, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlDate.createSequentialGroup()
							.addGap(33)
							.addComponent(lblNewLabel)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_pnlDate.setVerticalGroup(
			gl_pnlDate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDate.createSequentialGroup()
					.addGap(68)
					.addComponent(lblJun)
					.addGap(17)
					.addComponent(lblNewLabel)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		pnlDate.setLayout(gl_pnlDate);
		
		pnlWorkersTable = new JPanel();
		pnlWorkersTable.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlWorkersTable.setBounds(316, 0, 447, 471);
		pnlAttendanceMain.add(pnlWorkersTable);
		pnlWorkersTable.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 25, 418, 402);
		pnlWorkersTable.add(scrollPane);
		
		tblWorkersTable = new JTable();
		tblWorkersTable.setShowHorizontalLines(true);
		tblWorkersTable.setShowVerticalLines(true);
		tblWorkersTable.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tblWorkersTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"No.", "Workers Name", "Position", "AM", "PM"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, String.class, Boolean.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblWorkersTable.getColumnModel().getColumn(0).setResizable(false);
		tblWorkersTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblWorkersTable.getColumnModel().getColumn(1).setResizable(false);
		tblWorkersTable.getColumnModel().getColumn(1).setPreferredWidth(125);
		tblWorkersTable.getColumnModel().getColumn(2).setResizable(false);
		tblWorkersTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblWorkersTable.getColumnModel().getColumn(3).setResizable(false);
		tblWorkersTable.getColumnModel().getColumn(3).setPreferredWidth(30);
		tblWorkersTable.getColumnModel().getColumn(4).setResizable(false);
		tblWorkersTable.getColumnModel().getColumn(4).setPreferredWidth(30);
		tblWorkersTable.getColumnModel().getColumn(4).setMinWidth(30);
		scrollPane.setViewportView(tblWorkersTable);
		
		
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSave.setBackground(new Color(46,125,50));
		btnSave.setForeground(Color.WHITE);
		btnSave.setBounds(347, 437, 90, 28);
		pnlWorkersTable.add(btnSave);
		pnlAttendanceTitle.setLayout(null);
		
		lblAttendance = new JLabel("Attendance");
		lblAttendance.setForeground(Color.WHITE);
		lblAttendance.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblAttendance.setBounds(33, 14, 126, 27);
		pnlAttendanceTitle.add(lblAttendance);
		pnlAttendance.setLayout(gl_pnlAttendance);
		
		//Payroll Panel
		JPanel pnlPayroll = new JPanel();
		pnlPayroll.setBackground(new Color(245,245,245));
		tbpView.addTab("Payroll", null, pnlPayroll, null);
		
		pnlPayrollTitle = new JPanel();
		pnlPayrollTitle.setBackground(new Color(244,67,54));
		pnlPayrollTitle.setBorder(null);
		
		GroupLayout gl_pnlPayrollTitle = new GroupLayout(pnlPayroll);
		gl_pnlPayrollTitle.setHorizontalGroup(
			gl_pnlPayrollTitle.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnlPayrollTitle.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(pnlPayrollTitle, GroupLayout.PREFERRED_SIZE, 861, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlPayrollTitle.setVerticalGroup(
			gl_pnlPayrollTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPayrollTitle.createSequentialGroup()
					.addComponent(pnlPayrollTitle, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(537, Short.MAX_VALUE))
		);
		pnlPayrollTitle.setLayout(null);
		
		lblPayroll = new JLabel("Payroll");
		lblPayroll.setForeground(Color.WHITE);
		lblPayroll.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblPayroll.setBounds(33, 14, 126, 27);
		pnlPayrollTitle.add(lblPayroll);
		pnlPayroll.setLayout(gl_pnlPayrollTitle);
		
		//Workers Panel
		JPanel pnlWorkers = new JPanel();
		pnlWorkers.setBackground(new Color(245,245,245));
		tbpView.addTab("Workers", null, pnlWorkers, null);
		
		pnlWorkersTitle = new JPanel();
		pnlWorkersTitle.setBackground(new Color(33,150,243));
		pnlWorkersTitle.setBorder(null);
		
		GroupLayout gl_pnlWorkersTitle = new GroupLayout(pnlWorkers);
		gl_pnlWorkersTitle.setHorizontalGroup(
			gl_pnlWorkersTitle.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnlWorkersTitle.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(pnlWorkersTitle, GroupLayout.PREFERRED_SIZE, 861, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlWorkersTitle.setVerticalGroup(
			gl_pnlWorkersTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlWorkersTitle.createSequentialGroup()
					.addComponent(pnlWorkersTitle, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(537, Short.MAX_VALUE))
		);
		pnlWorkersTitle.setLayout(null);
		
		lblWorkers = new JLabel("Workers");
		lblWorkers.setForeground(Color.WHITE);
		lblWorkers.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblWorkers.setBounds(33, 14, 126, 27);
		pnlWorkersTitle.add(lblWorkers);
		pnlWorkers.setLayout(gl_pnlWorkersTitle);
		
		//Report Panel
		JPanel pnlReport = new JPanel();
		pnlReport.setBackground(new Color(245,245,245));
		tbpView.addTab("Report", null, pnlReport, null);
		
		pnlReportTitle = new JPanel();
		pnlReportTitle.setBackground(new Color(63,81,181));
		pnlReportTitle.setBorder(null);
		
		GroupLayout gl_pnlReportTitle = new GroupLayout(pnlReport);
		gl_pnlReportTitle.setHorizontalGroup(
			gl_pnlReportTitle.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnlReportTitle.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(pnlReportTitle, GroupLayout.PREFERRED_SIZE, 861, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlReportTitle.setVerticalGroup(
			gl_pnlReportTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlReportTitle.createSequentialGroup()
					.addComponent(pnlReportTitle, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(537, Short.MAX_VALUE))
		);
		pnlReportTitle.setLayout(null);
		
		lblReport = new JLabel("Report");
		lblReport.setForeground(Color.WHITE);
		lblReport.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblReport.setBounds(33, 14, 126, 27);
		pnlReportTitle.add(lblReport);
		pnlReport.setLayout(gl_pnlReportTitle);
		
	}

	private void createEvents() {
		
		//Event Button x Tabbed Panel
		btnAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbpView.setSelectedIndex(0);
				setTitle("Payroll Management System • Attendance");
			}
		});
		
		btnPayroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbpView.setSelectedIndex(1);
				setTitle("Payroll Management System • Payroll");
			}
		});
		
		btnWorkers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbpView.setSelectedIndex(2);
				setTitle("Payroll Management System • Workers");
			}
		});
		
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbpView.setSelectedIndex(3);
				setTitle("Payroll Management System • Report");
			}
		});
		
	}
}