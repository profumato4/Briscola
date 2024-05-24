package main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class Login {

	private JFrame frame;
	private JTextField txtCcc;
	private JPasswordField textField;
	private boolean logged = checkLogin();
	Register register;
	private boolean hide = true;
	private String userName;
	private JCheckBox chckbxNewCheckBox;
	private Database db;

	public Login(Briscola briscola, Database db) {
		this.db = db;
		register = new Register(this, db);
		initialize(briscola);
	}

	private void initialize(Briscola briscola) {
		frame = new JFrame();
		frame.setBounds(100, 100, 416, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		if(logged) {
			this.userName = db.getUsername();
		}

		JButton eye = new JButton(new ImageIcon("res/Login/hide2.png"));
		eye.setBorderPainted(false);
		eye.setContentAreaFilled(false);
		eye.setFocusPainted(false);
		eye.addActionListener(e -> {
            if (hide) {
                eye.setIcon(new ImageIcon("res/Login/view2.png"));
                eye.repaint();
                eye.validate();
                textField.setEchoChar((char) 0);
                hide = false;
            } else {
                eye.setIcon(new ImageIcon("res/Login/hide2.png"));
                eye.repaint();
                eye.validate();
                textField.setEchoChar('\u2022');
                hide = true;
            }

        });
		eye.setBounds(280, 208, 20, 20);
		frame.getContentPane().add(eye);
		frame.getContentPane().setComponentZOrder(eye, 0);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(148, 11, 105, 69);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		frame.getContentPane().add(lblNewLabel);

		txtCcc = new JTextField();
		txtCcc.setBounds(78, 126, 229, 26);
		txtCcc.setBackground(new Color(255, 255, 255));
		txtCcc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCcc.setColumns(10);
		txtCcc.setBorder(new LineBorder(Color.CYAN));
		frame.getContentPane().add(txtCcc);

		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setBounds(78, 107, 68, 14);
		frame.getContentPane().add(lblNewLabel_1);
		textField = new JPasswordField();
		textField.setBounds(78, 204, 229, 26);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.CYAN));
		textField.setBackground(Color.WHITE);

		textField.addActionListener(e -> {
            frame.repaint();
            frame.revalidate();
        });

		frame.getContentPane().add(textField);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(78, 185, 68, 14);
		frame.getContentPane().add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(78, 269, 229, 23);
		btnNewButton.addActionListener(e -> {
			if (!logged) {
				String username = txtCcc.getText();
				char[] chars = textField.getPassword();
				String password = new String(chars);

                try {
                    if(db.loginUser(username, password)){
						logged = true;
						Briscola.getFrame().setVisible(true);
						Briscola.getFrame().repaint();
						Briscola.getFrame().revalidate();
						frame.setVisible(false);
						System.out.println(isLogged());
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                if (!logged) {
					JOptionPane.showMessageDialog(frame, "Utente non registrato", "Login",
							JOptionPane.INFORMATION_MESSAGE);
				}


			} else {
				JOptionPane.showMessageDialog(frame, "Utente già loggato", "Login",
						JOptionPane.INFORMATION_MESSAGE);
				Briscola.getFrame().setVisible(true);
				Briscola.getFrame().repaint();
				Briscola.getFrame().revalidate();
				frame.setVisible(false);
			}

			if (chckbxNewCheckBox.isSelected()) {
				
				writeLogin(true);
				
			}else {
				writeLogin(false);
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setFocusPainted(false);
		frame.getContentPane().add(btnNewButton);

		JButton btnRegister = new JButton("Register now");
		btnRegister.setBounds(67, 332, 229, 23);
		btnRegister.addActionListener(e -> {
			register.getFrame().setVisible(true);
			frame.setVisible(false);
		});
		btnRegister.setForeground(Color.BLUE);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBackground(new Color(240, 240, 240));
		btnRegister.setBorderPainted(false);
		btnRegister.setContentAreaFilled(true);
		btnRegister.setFocusPainted(false);
		frame.getContentPane().add(btnRegister);

		chckbxNewCheckBox = new JCheckBox("Ricorda");
		chckbxNewCheckBox.setBounds(78, 237, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
	}

	public JFrame getFrame() {
		return frame;
	}

	public boolean isLogged() {
		return logged;
	}

	public JFrame getBriscolaFrame() {
		return Briscola.getFrame();
	}

	public String getUserName() {
		return userName;
	}

	private boolean checkLogin() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("res/Login/remember.txt")); 
			
			String str;
			
			while((str = br.readLine()) != null) {
				System.out.println(str + " " + Boolean.valueOf(br.readLine()));
				return Boolean.valueOf(str);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private void writeLogin(boolean value) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("res/Login/remember.txt", false);
			fw.append(String.valueOf(value));
			System.out.println("scritto");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public Database getDb() {
		return db;
	}
	
}
