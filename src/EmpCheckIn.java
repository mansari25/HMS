import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpCheckIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpCheckIn frame = new EmpCheckIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection conn=null;
	public EmpCheckIn() {
		conn=SQLconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 558);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check-In ");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setBounds(159, 19, 81, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guest's First Name:");
		lblNewLabel_1.setBounds(30, 82, 131, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblGuestsLastName = new JLabel("Guest's Last Name:");
		lblGuestsLastName.setBounds(30, 121, 131, 16);
		contentPane.add(lblGuestsLastName);
		
		textField = new JTextField();
		textField.setBounds(159, 77, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 116, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel resPanel = new JPanel();
		resPanel.setVisible(false);
		resPanel.setBounds(48, 231, 375, 111);
		contentPane.add(resPanel);
		resPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Room Number:");
		lblNewLabel_2.setBounds(18, 22, 104, 16);
		resPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(118, 22, 61, 16);
		resPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("No. of Guests:");
		lblNewLabel_4.setBounds(18, 42, 104, 16);
		resPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(118, 42, 61, 16);
		resPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Check-out:");
		lblNewLabel_6.setBounds(18, 62, 80, 16);
		resPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(118, 62, 61, 16);
		resPanel.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Lookup Reservation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try{
					String firstname=textField.getText();
					System.out.println(firstname);
					String lastname=textField_1.getText();
					System.out.println(lastname);
					String query="Select * from Guests where firstname=? and lastname=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, firstname);
					pst.setString(2, lastname);
					ResultSet rs=pst.executeQuery();
					int room=rs.getInt(6);
					String rm=Integer.toString(room);
					lblNewLabel_3.setText(rm);
					resPanel.setVisible(true);
					
					System.out.println(room);
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, "No booking available for Guest.");
					
				}
				
				
			}
		});
		btnNewButton.setBounds(134, 172, 192, 29);
		contentPane.add(btnNewButton);
		
		
	}
}
