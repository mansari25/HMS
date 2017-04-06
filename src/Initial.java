import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Initial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Initial frame = new Initial();
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
	public Initial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("GUEST");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				logIn lg=new logIn();
				lg.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(135, 46, 156, 51);
		contentPane.add(btnNewButton);
		
		JButton btnEmployee = new JButton("EMPLOYEE");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Employee emp=new Employee();
				emp.setVisible(true);
				}
		});
		btnEmployee.setBounds(135, 156, 156, 51);
		contentPane.add(btnEmployee);
		
		JLabel lblNewLabel = new JLabel("OR");
		lblNewLabel.setBounds(202, 117, 30, 16);
		contentPane.add(lblNewLabel);
	}
}
