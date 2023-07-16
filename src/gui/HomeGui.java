package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

import launcher.App;
import launcher.Functions;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class HomeGui extends JFrame {

	private JFrame frmAirlineBookingSystem;
	private JPasswordField textFieldPassword;
	private JTextField textFieldUserName;
	private JOptionPane jOptionPane;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeGui window = new HomeGui();
					window.frmAirlineBookingSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jOptionPane = new JOptionPane();
		frmAirlineBookingSystem = new JFrame();
		frmAirlineBookingSystem.setLocationRelativeTo(null);
		frmAirlineBookingSystem.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\taha\\Downloads\\AirLine Booking System\\airpic.png"));
		frmAirlineBookingSystem.getContentPane().setForeground(UIManager.getColor("Button.background"));
		frmAirlineBookingSystem.getContentPane().setBackground(new Color(135, 206, 250));
		frmAirlineBookingSystem.setTitle("Airline Booking System");
		frmAirlineBookingSystem.setBounds(100, 100, 601, 359);
		frmAirlineBookingSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAirlineBookingSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(10, 11, 565, 298);
		frmAirlineBookingSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelAdmin = new JPanel();
		panelAdmin.setBackground(new Color(173, 216, 230));
		panelAdmin.setBounds(0, 0, 181, 298);
		panel.add(panelAdmin);
		panelAdmin.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel(" Admin Login");
		lblAdminLogin.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblAdminLogin.setBounds(30, 11, 115, 46);
		panelAdmin.add(lblAdminLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPassword.setBounds(10, 155, 161, 30);
		panelAdmin.add(lblPassword);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblUserName.setBounds(10, 79, 161, 30);
		panelAdmin.add(lblUserName);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setToolTipText("Enter Password");
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPassword.setBounds(10, 190, 161, 30);
		panelAdmin.add(textFieldPassword);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setToolTipText("Enter User Name");
		textFieldUserName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldUserName.setBounds(10, 114, 161, 30);
		panelAdmin.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Functions.accessed(textFieldUserName.getText(),textFieldPassword.getText())) {
					frmAirlineBookingSystem.setVisible(false);
					AdminGUI.run();
				}
				else
				{
					jOptionPane.showMessageDialog(null, "Invalid Username or Password");
				}
			}
		});
		btnLogin.setBackground(UIManager.getColor("Button.shadow"));
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnLogin.setBounds(46, 264, 78, 23);
		panelAdmin.add(btnLogin);
		
		JPanel panelUser = new JPanel();
		panelUser.setBackground(new Color(173, 216, 230));
		panelUser.setBounds(191, 0, 374, 298);
		panel.add(panelUser);
		panelUser.setLayout(null);
		
		JLabel lblAirlineSystem = new JLabel("Airline System");
		lblAirlineSystem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAirlineSystem.setBounds(115, 11, 130, 46);
		panelUser.add(lblAirlineSystem);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDeparture.setBounds(10, 85, 161, 30);
		panelUser.add(lblDeparture);
		
		JLabel lblArrival = new JLabel("Arrival");
		lblArrival.setToolTipText("\r\n");
		lblArrival.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblArrival.setBounds(10, 142, 161, 30);
		panelUser.add(lblArrival);
		
		JComboBox comboBoxDeparture = new JComboBox();
		comboBoxDeparture.setBounds(118, 90, 127, 22);
		JComboBox comboBoxArrival = new JComboBox();
		comboBoxArrival.setBounds(115, 147, 130, 22);
		
		ArrayList<String> departure = new ArrayList<String>();
		ArrayList<String> arrival = new ArrayList<String>();
		
		for(int i=0;i<Functions.getRoutes().size();i++) {
			if(checkAndAdd(departure,Functions.getRoutes().get(i).getDeparture())) {
				departure.add(Functions.getRoutes().get(i).getDeparture());
			}
			if(checkAndAdd(arrival,Functions.getRoutes().get(i).getArrival())) {
				arrival.add(Functions.getRoutes().get(i).getArrival());
			}
			
		}
		for(int i=0;i<departure.size();i++)
		comboBoxDeparture.addItem(departure.get(i));
		for(int i=0;i<arrival.size();i++)
		comboBoxArrival.addItem(arrival.get(i));

		panelUser.add(comboBoxArrival);
		panelUser.add(comboBoxDeparture);
		
		JCheckBox chkAvailableFlight = new JCheckBox("Available Flights");
		chkAvailableFlight.setBackground(SystemColor.activeCaption);
		chkAvailableFlight.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		chkAvailableFlight.setBounds(213, 204, 123, 23);
		panelUser.add(chkAvailableFlight);
		
		JCheckBox chkBookAFlight = new JCheckBox("Book a Flight");
		chkBookAFlight.setBackground(SystemColor.activeCaption);
		chkBookAFlight.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		chkBookAFlight.setBounds(33, 204, 115, 23);
		panelUser.add(chkBookAFlight);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkBookAFlight.isSelected()) {
					frmAirlineBookingSystem.setVisible(false);
					SelectionOfFlight.run(comboBoxDeparture.getSelectedItem().toString(),comboBoxArrival.getSelectedItem().toString());
				}
				else if(chkAvailableFlight.isSelected()) {
					frmAirlineBookingSystem.setVisible(false);
					TimeTable.run(comboBoxDeparture.getSelectedItem().toString(), comboBoxArrival.getSelectedItem().toString());
				}
				else
				{
					new JOptionPane().showMessageDialog(null, "Atlease Select one Option");
				}
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSubmit.setBackground(UIManager.getColor("Button.shadow"));
		btnSubmit.setBounds(258, 264, 78, 23);
		panelUser.add(btnSubmit);
	}
	private boolean checkAndAdd(ArrayList<String> arr,String word) {
		for(int i=0;i<arr.size();i++)
			if(arr.get(i).equals(word))return false;
		return true;
	}
}
