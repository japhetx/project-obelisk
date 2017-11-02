package NewGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PayrollNewGUI extends JFrame {
	
	public static void main(String[] args) {
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
		setTitle("Payroll Management System");
		initComponents();
		createEvents();
	}

	private void initComponents() {
		
		//Main Panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 650);
		JPanel ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		ctpMain.setLayout(new BorderLayout(0, 0));
		setContentPane(ctpMain);
		
		
	}

	private void createEvents() {
		
		
	}

}
