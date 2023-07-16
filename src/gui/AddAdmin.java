package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import launcher.Functions;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class AddAdmin {

	private JFrame frmNewAdmin;
	private JTextField textFieldCNIC;
	private JTextField textFieldName;
	private JTextField textFieldCountry;
	private JTextField textFieldCity;
	private JTextField textFieldHouseNo;
	private JTextField textFieldStreetNo;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldUserName;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdmin window = new AddAdmin();
					window.frmNewAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewAdmin = new JFrame();
		frmNewAdmin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\taha\\Downloads\\AirLine Booking System\\airpic.png"));
		frmNewAdmin.setTitle("New Admin");
		frmNewAdmin.setBounds(100, 100, 415, 450);
		frmNewAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		frmNewAdmin.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(129, 31, 186, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("CNIC");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(90, 220, 98, 14);
		panel.add(lblNewLabel_1_1);
		
		textFieldCNIC = new JTextField();
		textFieldCNIC.setColumns(10);
		textFieldCNIC.setBounds(198, 217, 111, 20);
		panel.add(textFieldCNIC);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblName.setBounds(90, 80, 98, 14);
		panel.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(198, 77, 111, 20);
		panel.add(textFieldName);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCountry.setBounds(90, 108, 98, 14);
		panel.add(lblCountry);
		
		textFieldCountry = new JTextField();
		textFieldCountry.setColumns(10);
		textFieldCountry.setBounds(198, 105, 111, 20);
		panel.add(textFieldCountry);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCity.setBounds(90, 136, 98, 14);
		panel.add(lblCity);
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(198, 133, 111, 20);
		panel.add(textFieldCity);
		
		JLabel lblNewLabel_1 = new JLabel("House No.");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(90, 164, 98, 14);
		panel.add(lblNewLabel_1);
		
		textFieldHouseNo = new JTextField();
		textFieldHouseNo.setColumns(10);
		textFieldHouseNo.setBounds(198, 161, 111, 20);
		panel.add(textFieldHouseNo);
		
		JLabel lblNewLabel_1_2 = new JLabel("Street No.");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(90, 192, 98, 14);
		panel.add(lblNewLabel_1_2);
		
		textFieldStreetNo = new JTextField();
		textFieldStreetNo.setColumns(10);
		textFieldStreetNo.setBounds(198, 189, 111, 20);
		panel.add(textFieldStreetNo);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone Number");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(90, 249, 98, 14);
		panel.add(lblNewLabel_1_3);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setColumns(10);
		textFieldPhoneNumber.setBounds(198, 246, 111, 20);
		panel.add(textFieldPhoneNumber);
		
		JLabel lblNewLabel_1_4 = new JLabel("Username");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(90, 280, 98, 14);
		panel.add(lblNewLabel_1_4);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(198, 277, 111, 20);
		panel.add(textFieldUserName);
		
		JLabel lblNewLabel_1_5 = new JLabel("Password");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(90, 308, 98, 14);
		panel.add(lblNewLabel_1_5);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(198, 305, 111, 20);
		panel.add(textFieldPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Functions.Accounts(1, textFieldName.getText(),textFieldCountry.getText() , textFieldCity.getText(), textFieldHouseNo.getText(),textFieldStreetNo.getText(),textFieldCNIC.getText(), textFieldPhoneNumber.getText(), textFieldUserName.getText(), textFieldPassword.getText());
				new JOptionPane().showMessageDialog(null, "Admin Added Successfully");
			}
		});
		btnRegister.setBounds(235, 365, 98, 32);
		panel.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNewAdmin.setVisible(false);
				AdminGUI.run();
			}
		});
		btnBack.setBounds(66, 365, 98, 32);
		panel.add(btnBack);
	}
}
