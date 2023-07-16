package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JFormattedTextField;
import javax.swing.ScrollPaneConstants;

import launcher.Functions;

import javax.swing.JSpinner;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class RoutesGui {

	private JFrame frame;
	private JTextField textFieldDeparture;
	private JTextField textFieldArrival;
	private JTextField textFlightTimeInHour;
	private JTextField textFieldFlightTimeInMins;
	private JTextField textFieldDate;
	private JTextField textFieldmonth;
	private JTextField textFieldYear;
	private JTextField textFieldFlightDuration;
	private JOptionPane jop;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoutesGui window = new RoutesGui();
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
	public RoutesGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\taha\\Downloads\\AirLine Booking System\\airpic.png"));
		frame.setBounds(100, 100, 401, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("     Routes Information");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(89, 11, 285, 28);
		panel.add(lblNewLabel);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDeparture.setBounds(56, 63, 85, 17);
		panel.add(lblDeparture);
		
		textFieldDeparture = new JTextField();
		textFieldDeparture.setBounds(172, 62, 123, 20);
		panel.add(textFieldDeparture);
		textFieldDeparture.setColumns(10);
		
		JLabel lblArrival = new JLabel("Arrival");
		lblArrival.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblArrival.setBounds(56, 92, 85, 17);
		panel.add(lblArrival);
		
		textFieldArrival = new JTextField();
		textFieldArrival.setColumns(10);
		textFieldArrival.setBounds(172, 93, 123, 20);
		panel.add(textFieldArrival);
		
		JLabel lblFlightDuritation = new JLabel("Flight Time");
		lblFlightDuritation.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFlightDuritation.setBounds(56, 153, 92, 17);
		panel.add(lblFlightDuritation);
		
		textFlightTimeInHour = new JTextField();
		textFlightTimeInHour.setColumns(10);
		textFlightTimeInHour.setBounds(172, 153, 28, 20);
		panel.add(textFlightTimeInHour);
		
		JLabel lblMm = new JLabel("hh");
		lblMm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMm.setBounds(206, 153, 28, 17);
		panel.add(lblMm);
		
		textFieldFlightTimeInMins = new JTextField();
		textFieldFlightTimeInMins.setColumns(10);
		textFieldFlightTimeInMins.setBounds(229, 152, 28, 20);
		panel.add(textFieldFlightTimeInMins);
		
		JLabel lblHh = new JLabel("mm");
		lblHh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHh.setBounds(267, 153, 28, 17);
		panel.add(lblHh);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(56, 182, 92, 17);
		panel.add(lblDate);
		
		textFieldDate = new JTextField();
		textFieldDate.setColumns(10);
		textFieldDate.setBounds(172, 182, 28, 20);
		panel.add(textFieldDate);
		
		JLabel lblslash = new JLabel("/");
		lblslash.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblslash.setBounds(206, 182, 12, 17);
		panel.add(lblslash);
		
		textFieldmonth = new JTextField();
		textFieldmonth.setColumns(10);
		textFieldmonth.setBounds(216, 181, 28, 20);
		panel.add(textFieldmonth);
		
		JLabel lblHh_1 = new JLabel("/");
		lblHh_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHh_1.setBounds(254, 183, 12, 17);
		panel.add(lblHh_1);
		
		textFieldYear = new JTextField();
		textFieldYear.setColumns(10);
		textFieldYear.setBounds(267, 181, 37, 20);
		panel.add(textFieldYear);
		
		JLabel lblDdmmyy = new JLabel("  dd           mm          yyyy");
		lblDdmmyy.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDdmmyy.setBounds(172, 198, 132, 17);
		panel.add(lblDdmmyy);
		
		JComboBox comboBoxPlane = new JComboBox();
		comboBoxPlane.setModel(new DefaultComboBoxModel());
		comboBoxPlane.setBounds(172, 226, 123, 22);
		panel.add(comboBoxPlane);
		for(int i=0;i<Functions.getPlanes().size();i++) {
			if(Functions.getPlanes().get(i).isAvailable()) {
			String display = Functions.getPlanes().get(i).getPlaneName()+","+ Functions.getPlanes().get(i).getPlaneID();
			comboBoxPlane.addItem(display);
			}
			}		
		JLabel lblSelectPlane = new JLabel("Select Plane");
		lblSelectPlane.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSelectPlane.setBounds(56, 228, 92, 17);
		panel.add(lblSelectPlane);
		
		JLabel lblSelectPilot = new JLabel("Select Pilot");
		lblSelectPilot.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSelectPilot.setBounds(56, 261, 92, 17);
		panel.add(lblSelectPilot);
		
		JComboBox comboBoxPilot = new JComboBox();
		comboBoxPilot.setBounds(172, 259, 123, 22);
		panel.add(comboBoxPilot);
		for(int i=0;i<Functions.getPilots().size();i++) {
			if(Functions.getPilots().get(i).isAvailable()) {
			String display = Functions.getPilots().get(i).getName()+","+ Functions.getPilots().get(i).getEmpID();
			comboBoxPilot.addItem(display);
			}
		}
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String departure=textFieldDeparture.getText();
				String arrival = textFieldArrival.getText();
				int flightDuration = Integer.parseInt(textFieldFlightDuration.getText());
				int flightTimeinhours = Integer.parseInt(textFlightTimeInHour.getText());
				int flightTimeInMins =  Integer.parseInt(textFieldFlightTimeInMins.getText());
				int date = Integer.parseInt(textFieldDate.getText());
				int month =Integer.parseInt( textFieldmonth.getText());
				int year = Integer.parseInt(textFieldYear.getText());
				int indexofPlane=comboBoxPlane.getSelectedIndex();
				int indexOfPilot = comboBoxPilot.getSelectedIndex();
				Functions.addNewRoute(departure, arrival, flightTimeinhours, flightTimeInMins, date, month, year,flightDuration , indexofPlane, indexOfPilot);
				 new JOptionPane().showMessageDialog(null,"Route added Successfully!");
				
			}
		});
		btnNewButton.setBounds(206, 328, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminGUI.run();
			}
		});
		btnBack.setBounds(56, 328, 89, 23);
		panel.add(btnBack);
		
		JLabel lblFlightduration = new JLabel("Flight Duration");
		lblFlightduration.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFlightduration.setBounds(56, 120, 85, 17);
		panel.add(lblFlightduration);
		
		textFieldFlightDuration = new JTextField();
		textFieldFlightDuration.setColumns(10);
		textFieldFlightDuration.setBounds(172, 121, 123, 20);
		panel.add(textFieldFlightDuration);
	}
}
