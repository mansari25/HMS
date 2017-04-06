import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuestInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestInfo frame = new GuestInfo();
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
	public GuestInfo() {
		conn=SQLconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guest Options");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setBounds(150, 18, 167, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		lblNewLabel_1.setBackground(Color.CYAN);
		lblNewLabel_1.setBounds(111, 69, 219, 40);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText("Welcome " + logIn.getUser()+"!");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Schedule Room Service");
		rdbtnNewRadioButton_1.setBounds(123, 247, 202, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Book a Room");
		rdbtnNewRadioButton_3.setBounds(123, 212, 141, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonGroup bg=new ButtonGroup();
				bg.add(rdbtnNewRadioButton_1);
				bg.add(rdbtnNewRadioButton_3);
				
				if(bg.getSelection()==null){
					JOptionPane.showMessageDialog(null, "Please select an option.");
				}
				
			}
		});
		btnNewButton.setBounds(137, 318, 117, 29);
		contentPane.add(btnNewButton);
		
		
		
	}
}
