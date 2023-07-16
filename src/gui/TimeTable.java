package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import launcher.Functions;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TimeTable {

	private JFrame frmTimeTable;
	private JButton btnNewButton;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeTable window = new TimeTable();
					window.frmTimeTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void run(String departure,String arrival) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeTable window = new TimeTable( departure, arrival);
					window.frmTimeTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TimeTable() {
		initialize();
	}
	/*
	 * User with argument
	 */
	public TimeTable(String departure,String arrival) {
		initialize( departure, arrival);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmTimeTable = new JFrame();
		frmTimeTable.setTitle("Time Table");
		frmTimeTable.setBounds(100, 100, 490, 324);
		frmTimeTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		frmTimeTable.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("            Time Table");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(102, 11, 234, 14);
		panel.add(lblNewLabel);
			
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTimeTable.setVisible(false);
				AdminGUI.run();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(170, 249, 89, 23);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 454, 204);
		panel.add(scrollPane);
		
		table = new JTable();
		
		
		model = new DefaultTableModel();
		Object columnName[] = {"Departure","Arival","Date","Time"," PLane"};
		Object row[] = new Object[5];
		model.setColumnIdentifiers(columnName);
		table.setModel(model);
				
		scrollPane.setViewportView(table);
		
		
		
//		for(int i=0;i<4;i++)
//		{
//			row[i] = "1";
//		}
		for(int i=0;i<Functions.getRoutes().size();i++) {
		row[0]=Functions.getRoutes().get(i).getDeparture();
		row[1]=Functions.getRoutes().get(i).getArrival();
		row[2]= Functions.getRoutes().get(i).getDate().getDate()+"/"+Functions.getRoutes().get(i).getDate().getMonth()+"/"+Functions.getRoutes().get(i).getDate().getYear();
		row[3]=Functions.getRoutes().get(i).getTime().getHours()+":"+Functions.getRoutes().get(i).getTime().getMins();
		row[4]=Functions.getRoutes().get(i).getPlane().getPlaneName();
		model.addRow(row);
		}
		
		
		
		
		
		
		
		
		
//		JTable table;
//		
//		Object [][] data = {{101,"Talal",21},{101,"mohiz",21},{101,"Taha",21}};
//		String columnName[] = {"Roll No","Names","Age"};
//		
//		DefaultTableModel model = new DefaultTableModel (data,columnName);
//		
//		table = new JTable (model);
//		
//		panel.add(new JScrollPane(table));
//		
		
	}
	private void initialize(String departure,String arrival) {
		frmTimeTable = new JFrame();
		frmTimeTable.setTitle("Time Table");
		frmTimeTable.setBounds(100, 100, 490, 324);
		frmTimeTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		frmTimeTable.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("            Time Table");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(102, 11, 234, 14);
		panel.add(lblNewLabel);
			
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTimeTable.setVisible(false);
				HomeGui.run();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(170, 249, 89, 23);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 454, 204);
		panel.add(scrollPane);
		
		table = new JTable();
		
		
		model = new DefaultTableModel();
		Object columnName[] = {"Departure","Arival","Date","Time"," PLane"};
		Object row[] = new Object[5];
		model.setColumnIdentifiers(columnName);
		table.setModel(model);
				
		scrollPane.setViewportView(table);
		
		
		
		
//		for(int i=0;i<4;i++)
//		{
//			row[i] = "1";
//		}
		for(int i=0;i<Functions.getRoutes().size();i++) {
			String tempD = Functions.getRoutes().get(i).getDeparture();
			String tempA = Functions.getRoutes().get(i).getArrival();
			if(departure.equals(tempD) && arrival.equals(tempA)) {
				row[0]=Functions.getRoutes().get(i).getDeparture();
				row[1]=Functions.getRoutes().get(i).getArrival();
				row[2]= Functions.getRoutes().get(i).getDate().getDate()+"/"+Functions.getRoutes().get(i).getDate().getMonth()+"/"+Functions.getRoutes().get(i).getDate().getYear();
				row[3]=Functions.getRoutes().get(i).getTime().getHours()+":"+Functions.getRoutes().get(i).getTime().getMins();
				row[4]=Functions.getRoutes().get(i).getPlane().getPlaneName();
				model.addRow(row);
			}
//			table.getSelectionModel().is
		}
		
		
		
		
		
		
		
		
		
//		JTable table;
//		
//		Object [][] data = {{101,"Talal",21},{101,"mohiz",21},{101,"Taha",21}};
//		String columnName[] = {"Roll No","Names","Age"};
//		
//		DefaultTableModel model = new DefaultTableModel (data,columnName);
//		
//		table = new JTable (model);
//		
//		panel.add(new JScrollPane(table));
//		
		
		
	}
}

