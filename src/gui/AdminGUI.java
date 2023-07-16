package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

import launcher.Functions;

import java.awt.Toolkit;

public class AdminGUI	extends JFrame {

	private JFrame frmAdminMenu;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI window = new AdminGUI();
					window.frmAdminMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame.setLocationRelativeTo(null);
		frmAdminMenu = new JFrame();
		frmAdminMenu.setLocationRelativeTo(null);
		frmAdminMenu.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\taha\\Downloads\\AirLine Booking System\\airpic.png"));
		frmAdminMenu.setResizable(false);
		frmAdminMenu.setTitle("Admin menu\r\n");
		frmAdminMenu.setBounds(100, 100, 217, 330);
		frmAdminMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminMenu.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 201, 291);
		frmAdminMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Functions.getAdmins().get(Functions.getIndexofAdmin()).getName());
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setToolTipText("Admin Name\r\n");
		lblNewLabel.setBounds(10, 21, 105, 20);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Plane");
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminMenu.setVisible(false);
				NewPlaneGUI.run();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(47, 74, 112, 23);
		panel.add(btnNewButton);
		
		JButton btnAddRoute = new JButton("Add Route");
		btnAddRoute.setBackground(UIManager.getColor("Button.shadow"));
		btnAddRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminMenu.setVisible(false);
				RoutesGui.run();
				
			}
		});
		btnAddRoute.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAddRoute.setBounds(47, 117, 112, 23);
		panel.add(btnAddRoute);
		
		JButton btnTimeTable = new JButton("Time Table");
		btnTimeTable.setBackground(UIManager.getColor("Button.shadow"));
		btnTimeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminMenu.setVisible(false);
				TimeTable.run();
			}
		});
		btnTimeTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnTimeTable.setBounds(47, 163, 112, 23);
		panel.add(btnTimeTable);
		
		JButton btnAddAdmin = new JButton("Add Admin");
		btnAddAdmin.setBackground(UIManager.getColor("Button.shadow"));
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminMenu.setVisible(false);
				AddAdmin.run();
			}
		});
		btnAddAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAddAdmin.setBounds(47, 212, 112, 23);
		panel.add(btnAddAdmin);
	}
}
