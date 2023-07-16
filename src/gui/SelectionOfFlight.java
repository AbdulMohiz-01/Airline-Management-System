package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import launcher.Functions;

public class SelectionOfFlight {

	private JFrame frame;

	private JFrame frmTimeTable;
	private JButton btnNewButton;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void run(String departure,String arrival) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectionOfFlight window = new SelectionOfFlight(departure, arrival);
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
	public SelectionOfFlight(String departure,String arrival) {
		initialize( departure, arrival);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String departure,String arrival) {
		frame = new JFrame();
		frame.setTitle("Time Table");
		frame.setBounds(100, 100, 490, 324);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("            Time Table");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(102, 11, 234, 14);
		panel.add(lblNewLabel);
			
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				HomeGui.run();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(102, 250, 89, 23);
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
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) {
					UserDataGUI.indexOfRow = table.getSelectedRow();
					frame.setVisible(false);
					UserDataGUI.run();
				}
				else
					new JOptionPane().showMessageDialog(null, "Select Routes!");
			}
		});
		btnSelect.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSelect.setBounds(308, 250, 89, 23);
		panel.add(btnSelect);
		
		
		
		
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
				Functions.getSelectIndexes().add(i);
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
