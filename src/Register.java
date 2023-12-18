import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Register {

	private JFrame frame;
	private JTextField txtCcc;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Register() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 416, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(123, 11, 159, 69);
		frame.getContentPane().add(lblNewLabel);
		
		txtCcc = new JTextField();
		txtCcc.setBackground(new Color(255, 255, 255));
		txtCcc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCcc.setBounds(78, 126, 229, 26);
		txtCcc.setColumns(10);
		txtCcc.setBorder(new LineBorder(Color.CYAN));
		frame.getContentPane().add(txtCcc);
		
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setBounds(78, 107, 68, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.CYAN));
		textField.setBackground(Color.WHITE);
		textField.setBounds(78, 187, 229, 26);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(78, 168, 68, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = txtCcc.getText() + ";";				
				String password1 = textField.getText();
				String password2 = textField_1.getText();
				
				if(password1.equals(password2)) {
					try {
						FileWriter  file = new FileWriter("C:\\Users\\Utente\\Desktop\\codici\\java\\Briscola\\res\\Login\\Login.txt", true);
						file.append(userName);
						file.append(password1);
						file.append("\n");
						file.close();
						System.out.println("fatto");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					txtCcc.setText("");
					textField.setText("");
					textField_1.setText("");
				}
				
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(78, 300, 229, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Back to login");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnRegister.setForeground(Color.BLUE);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBackground(new Color(240, 240, 240));
		btnRegister.setBounds(78, 352, 229, 23);
		btnRegister.setBorderPainted(false);
		btnRegister.setContentAreaFilled(true);
		btnRegister.setFocusPainted(false);
		frame.getContentPane().add(btnRegister);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(Color.CYAN));
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(78, 242, 229, 26);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm password");
		lblNewLabel_1_1_1.setBounds(78, 224, 159, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
	}


	public JFrame getFrame() {
		return frame;
	}
	
	
	
}
