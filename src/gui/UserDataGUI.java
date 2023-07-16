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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserDataGUI {

	private JFrame frame;
	private JTextField textFieldname;
	private JTextField textFieldCountry;
	private JTextField textFieldCity;
	private JTextField textFieldHouseNo;
	private JTextField textFieldStreetNo;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldCNIC;
	private JTextField textFieldNumberOfTickets;
	static  int indexOfRow;
	

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDataGUI window = new UserDataGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserDataGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 390, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("      Flight Boking Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(59, 30, 237, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(69, 69, 100, 20);
		panel.add(lblNewLabel_1);
		
		textFieldname = new JTextField();
		textFieldname.setBounds(179, 70, 111, 20);
		panel.add(textFieldname);
		textFieldname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Country");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(69, 100, 100, 20);
		panel.add(lblNewLabel_1_1);
		
		textFieldCountry = new JTextField();
		textFieldCountry.setColumns(10);
		textFieldCountry.setBounds(179, 101, 111, 20);
		panel.add(textFieldCountry);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("City");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(69, 131, 100, 20);
		panel.add(lblNewLabel_1_1_1);
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(179, 132, 111, 20);
		panel.add(textFieldCity);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("House No.");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(69, 162, 100, 20);
		panel.add(lblNewLabel_1_1_2);
		
		textFieldHouseNo = new JTextField();
		textFieldHouseNo.setColumns(10);
		textFieldHouseNo.setBounds(179, 163, 111, 20);
		panel.add(textFieldHouseNo);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Street No.");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1_3.setBounds(69, 193, 100, 20);
		panel.add(lblNewLabel_1_1_3);
		
		textFieldStreetNo = new JTextField();
		textFieldStreetNo.setColumns(10);
		textFieldStreetNo.setBounds(179, 194, 111, 20);
		panel.add(textFieldStreetNo);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Phone No.");
		lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1_4.setBounds(69, 224, 100, 20);
		panel.add(lblNewLabel_1_1_4);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setColumns(10);
		textFieldPhoneNumber.setBounds(179, 225, 111, 20);
		panel.add(textFieldPhoneNumber);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("CNIC");
		lblNewLabel_1_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1_5.setBounds(69, 255, 100, 20);
		panel.add(lblNewLabel_1_1_5);
		
		textFieldCNIC = new JTextField();
		textFieldCNIC.setColumns(10);
		textFieldCNIC.setBounds(179, 256, 111, 20);
		panel.add(textFieldCNIC);
		
		JButton btnBACK = new JButton("Back");
		btnBACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				HomeGui.run();
			}
		});
		btnBACK.setBounds(59, 375, 89, 23);
		panel.add(btnBACK);
		JComboBox comboBoxTicketType = new JComboBox();
		comboBoxTicketType.setModel(new DefaultComboBoxModel(new String[] {"--Select Ticket--", "Business Class", "Economy Clas", "First Class"}));
		comboBoxTicketType.setBounds(69, 287, 227, 22);
		panel.add(comboBoxTicketType);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Functions.Accounts(2, textFieldname.getText(), textFieldCountry.getText(), textFieldCity.getText(), textFieldHouseNo.getText(), textFieldStreetNo.getText(), textFieldCNIC.getText(), textFieldPhoneNumber.getText(), null, null);
				Functions.selectTicketType(indexOfRow,Integer.parseInt(textFieldNumberOfTickets.getText()),comboBoxTicketType.getSelectedIndex() );
				new JOptionPane().showMessageDialog(null, "Information added Successfully!");
				
				
			}
		});
		btnSubmit.setBounds(207, 375, 89, 23);
		panel.add(btnSubmit);
		
		JLabel lblNewLabel_1_1_5_1 = new JLabel("No. of Tickets");
		lblNewLabel_1_1_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1_5_1.setBounds(69, 325, 100, 20);
		panel.add(lblNewLabel_1_1_5_1);
		
		textFieldNumberOfTickets = new JTextField();
		textFieldNumberOfTickets.setColumns(10);
		textFieldNumberOfTickets.setBounds(179, 326, 111, 20);
		panel.add(textFieldNumberOfTickets);
	}

//	public int getIndexOfRow() {
//		return indexOfRow;
//	}
//
//	public void setIndexOfRow(int indexOfRow) {
//		this.indexOfRow = indexOfRow;
//	}
	
}
