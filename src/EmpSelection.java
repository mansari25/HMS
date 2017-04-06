import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpSelection frame = new EmpSelection();
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
	public EmpSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 381);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Selection Page");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setBounds(110, 18, 230, 29);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Check-In Guest");
		rdbtnNewRadioButton.setBounds(58, 77, 141, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Check-Out Guest");
		rdbtnNewRadioButton_1.setBounds(58, 112, 155, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Order Guest Room Service");
		rdbtnNewRadioButton_2.setBounds(58, 147, 205, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Make Guest Reservation");
		rdbtnNewRadioButton_3.setBounds(58, 182, 182, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonGroup bg=new ButtonGroup();
				bg.add(rdbtnNewRadioButton);
				bg.add(rdbtnNewRadioButton_1);
				bg.add(rdbtnNewRadioButton_2);
				bg.add(rdbtnNewRadioButton_3);
				
				if(bg.getSelection()==null){
					JOptionPane.showMessageDialog(null, "Please select an option.");
				}else if(rdbtnNewRadioButton.isSelected()){
					setVisible(false);
					EmpCheckIn ci=new EmpCheckIn();
					ci.setVisible(true);
					
				}else if(rdbtnNewRadioButton_1.isSelected()){
					JOptionPane.showMessageDialog(null, "Please select an option2.");
				}else if(rdbtnNewRadioButton_2.isSelected()){
					JOptionPane.showMessageDialog(null, "Please select an option3.");
				}else{
					JOptionPane.showMessageDialog(null, "Please select an option4.");
				}
			}
		});
		btnNewButton.setBounds(145, 259, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Initial i=new Initial();
				i.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(6, 324, 99, 29);
		contentPane.add(btnNewButton_1);
	}
}
