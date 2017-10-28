package EstimateViews;

import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class PayrollMain extends JFrame {

	private JPanel ctpMainPane;
	private JTextField txtDate;
	private JTable tblWorkers;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		pnlAttendance.setBackground(Color.WHITE);
		tbPane.addTab("Attendance", null, pnlAttendance, null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnGo = new JButton("Go");
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDate.setText("Saturday, 28 October 2017");
		txtDate.setColumns(10);
		
		JButton btnCurrentDate = new JButton("Current Date");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlAttendance = new GroupLayout(pnlAttendance);
		gl_pnlAttendance.setHorizontalGroup(
			gl_pnlAttendance.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAttendance.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_pnlAttendance.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 681, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlAttendance.createSequentialGroup()
							.addComponent(lblDate)
							.addGap(20)
							.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(btnGo, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(btnCurrentDate)))
					.addGap(34))
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
						.addComponent(btnGo)
						.addComponent(btnCurrentDate))
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
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
			},
			new String[] {
				"Workers Name", "AM", "PM"
			}
		));
		scrollPane.setViewportView(tblWorkers);
		pnlAttendance.setLayout(gl_pnlAttendance);
		
		JPanel pnlPayroll = new JPanel();
		pnlPayroll.setBackground(Color.WHITE);
		tbPane.addTab("Payroll", null, pnlPayroll, null);
		
		JPanel pnlWorkers = new JPanel();
		pnlWorkers.setBackground(Color.WHITE);
		tbPane.addTab("Workers", null, pnlWorkers, null);
		
		JPanel pnlReport = new JPanel();
		pnlReport.setBackground(Color.WHITE);
		tbPane.addTab("Report", null, pnlReport, null);
		
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
}
