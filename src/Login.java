import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Login {

	private JFrame frame;
	private JTextField txtCcc;
	private JPasswordField textField;
	@SuppressWarnings("unused")
	private Briscola briscola;
	private boolean logged = false;
	Register register = new Register(this);
	private boolean hide = true;

	public Login(Briscola briscola) {
		this.briscola = briscola;
		initialize(briscola);
	}

	private void initialize(Briscola briscola) {
		frame = new JFrame();
		frame.setBounds(100, 100, 416, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton eye = new JButton(new ImageIcon("C:/Users/Utente/Desktop/codici/java/Briscola/res/Login/hide2.png"));
		eye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hide) {
					eye.setIcon(new ImageIcon("C:/Users/Utente/Desktop/codici/java/Briscola/res/Login/view2.png"));
					eye.repaint();
					textField.setEchoChar((char)0);
					hide = false;
				} else {
					eye.setIcon(new ImageIcon("C:/Users/Utente/Desktop/codici/java/Briscola/res/Login/hide2.png"));
					eye.repaint();
					textField.setEchoChar('\u2022');
					hide = true;
				}

			}
		});
		eye.setBounds(280, 208, 20, 20);
		eye.setBorderPainted(false);
		eye.setContentAreaFilled(false);
		frame.getContentPane().add(eye);

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
		frame.getContentPane().add(textField);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(78, 185, 68, 14);
		frame.getContentPane().add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(78, 269, 229, 23);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				if (!logged) {
					String userName = txtCcc.getText();
					char[] chars = textField.getPassword();
					String password = new String(chars);

					try {
						FileReader file = new FileReader(
								"C:\\Users\\Utente\\Desktop\\codici\\java\\Briscola\\res\\Login\\Login.txt");
						BufferedReader reader = new BufferedReader(file);

						String str;

						try {
							while ((str = reader.readLine()) != null) {
								String[] split = str.split(";");

								if (userName.equals(split[0]) && password.equals(split[1])) {
									logged = true;
									briscola.getFrame().setVisible(true);
									frame.setVisible(false);
									System.out.println(isLogged());
									break;
								}

							}

							if (!logged) {
								JOptionPane.showMessageDialog(frame, "Utente non registrato", "Login",
										JOptionPane.INFORMATION_MESSAGE);
							}

						} catch (IOException e1) {
							e1.printStackTrace();
						}

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(frame, "Utente già loggato", "Login",
							JOptionPane.INFORMATION_MESSAGE);
					briscola.getFrame().setVisible(true);
					frame.setVisible(false);
				}
			}

		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnNewButton);

		JButton btnRegister = new JButton("Register now");
		btnRegister.setBounds(67, 332, 229, 23);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnRegister.setForeground(Color.BLUE);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBackground(new Color(240, 240, 240));
		btnRegister.setBorderPainted(false);
		btnRegister.setContentAreaFilled(true);
		btnRegister.setFocusPainted(false);
		frame.getContentPane().add(btnRegister);

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
	
	
}
