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

public class NewPlaneGUI {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldID;
	private JTextField textFieldModelNo;
	private JTextField textFieldEconomySeats;
	private JTextField textFieldBusinessSeats;
	private JTextField textFieldFirstSeats;
	private JTextField textFieldFuelCost;
	private JOptionPane jop;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPlaneGUI window = new NewPlaneGUI();
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
	public NewPlaneGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\taha\\Downloads\\AirLine Booking System\\airpic.png"));
		frame.setBounds(100, 100, 376, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelPlaneInformation = new JPanel();
		panelPlaneInformation.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(panelPlaneInformation, BorderLayout.CENTER);
		panelPlaneInformation.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("         Information of Plane");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(58, 25, 228, 30);
		panelPlaneInformation.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblName.setBounds(58, 98, 52, 17);
		panelPlaneInformation.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldName.setBounds(162, 96, 124, 20);
		panelPlaneInformation.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblID.setBounds(58, 127, 52, 17);
		panelPlaneInformation.add(lblID);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldID.setColumns(10);
		textFieldID.setBounds(162, 128, 124, 20);
		panelPlaneInformation.add(textFieldID);
		
		JLabel lblModel = new JLabel("Model No");
		lblModel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblModel.setBounds(58, 155, 63, 17);
		panelPlaneInformation.add(lblModel);
		
		textFieldModelNo = new JTextField();
		textFieldModelNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldModelNo.setColumns(10);
		textFieldModelNo.setBounds(162, 157, 124, 20);
		panelPlaneInformation.add(textFieldModelNo);
		
		JLabel lblEconomySeats = new JLabel("Economy Seats");
		lblEconomySeats.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEconomySeats.setBounds(58, 187, 94, 17);
		panelPlaneInformation.add(lblEconomySeats);
		
		textFieldEconomySeats = new JTextField();
		textFieldEconomySeats.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldEconomySeats.setColumns(10);
		textFieldEconomySeats.setBounds(162, 185, 124, 20);
		panelPlaneInformation.add(textFieldEconomySeats);
		
		JLabel lblBusinessSeats = new JLabel("Business Seats");
		lblBusinessSeats.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblBusinessSeats.setBounds(58, 217, 94, 17);
		panelPlaneInformation.add(lblBusinessSeats);
		
		textFieldBusinessSeats = new JTextField();
		textFieldBusinessSeats.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldBusinessSeats.setColumns(10);
		textFieldBusinessSeats.setBounds(162, 215, 124, 20);
		panelPlaneInformation.add(textFieldBusinessSeats);
		
		JLabel lblFirstSeats = new JLabel("First Seats");
		lblFirstSeats.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFirstSeats.setBounds(58, 247, 94, 17);
		panelPlaneInformation.add(lblFirstSeats);
		
		textFieldFirstSeats = new JTextField();
		textFieldFirstSeats.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldFirstSeats.setColumns(10);
		textFieldFirstSeats.setBounds(162, 245, 124, 20);
		panelPlaneInformation.add(textFieldFirstSeats);
		
		JLabel lblFuelCost = new JLabel("Fuel Cost");
		lblFuelCost.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFuelCost.setBounds(58, 277, 94, 17);
		panelPlaneInformation.add(lblFuelCost);
		
		textFieldFuelCost = new JTextField();
		textFieldFuelCost.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldFuelCost.setColumns(10);
		textFieldFuelCost.setBounds(162, 275, 124, 20);
		panelPlaneInformation.add(textFieldFuelCost);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldName.getText();
				String id = textFieldID.getText();
				String modelNumber = textFieldModelNo.getText();
				int businessSeats = Integer.parseInt(textFieldBusinessSeats.getText());
				int economSeats = Integer.parseInt(textFieldEconomySeats.getText());
				int firstSeats = Integer.parseInt(textFieldFirstSeats.getText());
				int fuelCost = Integer.parseInt(textFieldFuelCost.getText());
				Functions.addNewPlane(name, id, modelNumber, businessSeats, economSeats, firstSeats, fuelCost);
				jop = new JOptionPane();
				jop.showMessageDialog(null, "Plane Added Successfully");
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSubmit.setBounds(197, 320, 89, 23);
		panelPlaneInformation.add(btnSubmit);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminGUI.run();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(58, 320, 89, 23);
		panelPlaneInformation.add(btnNewButton_1);
	}
}
