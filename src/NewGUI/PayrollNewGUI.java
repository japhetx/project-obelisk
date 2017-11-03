package NewGUI;

import java.awt.BorderLayout;
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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PayrollNewGUI extends JFrame {
	
	private final JPanel pnlMenu = new JPanel();
	
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
		setTitle("Payroll Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 650);
		
		//Top Menu Bar
		JMenuBar mnbTopMenubar = new JMenuBar();
		setJMenuBar(mnbTopMenubar);
		
		JMenu mnAccount = new JMenu("Account");
		mnAccount.setBorderPainted(true);
		mnbTopMenubar.add(mnAccount);
		
		JMenuItem mntmSwitchAccount = new JMenuItem("Switch Account");
		mnAccount.add(mntmSwitchAccount);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mnAccount.add(mntmLogOut);
		
		JMenu mnProject = new JMenu("Project");
		mnbTopMenubar.add(mnProject);
		
		JMenuItem mntmSwitchProject = new JMenuItem("Switch Project");
		mnProject.add(mntmSwitchProject);
		
		JMenu mnSettings = new JMenu("Settings");
		mnbTopMenubar.add(mnSettings);
		
		JMenuItem mntmSettingsGoesHere = new JMenuItem("Settings Goes Here");
		mnSettings.add(mntmSettingsGoesHere);
		
		JMenu mnAbout = new JMenu("Help");
		mnbTopMenubar.add(mnAbout);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnAbout.add(mntmAbout);
		JPanel ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);
		ctpMain.setLayout(null);
		
		//User Info Panel
		JPanel pnlUserInfo = new JPanel();
		pnlUserInfo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlUserInfo.setBounds(-6, -8, 218, 129);
		ctpMain.add(pnlUserInfo);
		pnlUserInfo.setLayout(null);
		
		JLabel lblUsername = new JLabel("Japhet Mert Obsioma");
		lblUsername.setBounds(22, 83, 173, 16);
		pnlUserInfo.add(lblUsername);
		
		JLabel lblUserEmail = new JLabel("jpmrobsioma@gmail.com");
		lblUserEmail.setBounds(22, 99, 173, 16);
		pnlUserInfo.add(lblUserEmail);
		pnlMenu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlMenu.setBounds(-3, 119, 215, 472);
		ctpMain.add(pnlMenu);
		
		//Menu Panel Buttons
		JButton btnAttendance = new JButton("Attendance");
	
		JButton btnPayroll = new JButton("Payroll");
		
		JButton btnWorkers = new JButton("Workers");
		
		JButton btnReport = new JButton("Report");
		
		//Group Layout
		GroupLayout gl_pnlMenu = new GroupLayout(pnlMenu);
		gl_pnlMenu.setHorizontalGroup(
			gl_pnlMenu.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlMenu.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addGroup(gl_pnlMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlMenu.createSequentialGroup()
							.addComponent(btnAttendance, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(4))
						.addGroup(Alignment.TRAILING, gl_pnlMenu.createSequentialGroup()
							.addComponent(btnReport, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addGap(5)))
					.addGap(10))
				.addGroup(Alignment.LEADING, gl_pnlMenu.createSequentialGroup()
					.addGap(14)
					.addComponent(btnPayroll, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_pnlMenu.createSequentialGroup()
					.addGap(14)
					.addComponent(btnWorkers, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_pnlMenu.setVerticalGroup(
			gl_pnlMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlMenu.createSequentialGroup()
					.addGap(14)
					.addComponent(btnAttendance, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnPayroll, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btnWorkers, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnReport, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(232, Short.MAX_VALUE))
		);
		gl_pnlMenu.linkSize(SwingConstants.VERTICAL, new Component[] {btnAttendance, btnPayroll, btnWorkers, btnReport});
		gl_pnlMenu.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnAttendance, btnPayroll, btnWorkers, btnReport});
		pnlMenu.setLayout(gl_pnlMenu);
		
		//Tabbed Panel
		JTabbedPane tbpView = new JTabbedPane(JTabbedPane.LEFT);
		tbpView.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tbpView.setBounds(117, -6, 951, 597);
		ctpMain.add(tbpView);
		
		//Attendance Panel
		JPanel pnlAttendance = new JPanel();
		tbpView.addTab("Attendance", null, pnlAttendance, null);
		
		//Payroll Panel
		JPanel pnlPayroll = new JPanel();
		tbpView.addTab("Payroll", null, pnlPayroll, null);
		
		//Workers Panel
		JPanel pnlWorkers = new JPanel();
		tbpView.addTab("Workers", null, pnlWorkers, null);
		
		//Report Panel
		JPanel pnlReport = new JPanel();
		tbpView.addTab("Report", null, pnlReport, null);
		
	}

	private void createEvents() {
		
		
	}
}
