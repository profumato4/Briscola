import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;

public class Login {

	private JFrame frame;
	private JTextField txtCcc;
	private JPasswordField textField;
	@SuppressWarnings("unused")
	private Briscola briscola;
	private boolean logged = false;
	Register register = new Register(this);
	private boolean hide = true;
	private String userName;
	private boolean macAddressFound = false;
	private JCheckBox chckbxNewCheckBox;
	private String currentMacAddress;

	public Login(Briscola briscola) {
		this.briscola = briscola;
		initialize(briscola);
	}

	private void initialize(Briscola briscola) {
		frame = new JFrame();
		frame.setBounds(100, 100, 416, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		checkMacAddress();
		if (macAddressFound) {
			logged = true;
			
			this.userName = getUserNameByMacAddress();
		}

		JButton eye = new JButton(new ImageIcon("res/Login/hide2.png"));
		eye.setBorderPainted(false);
		eye.setContentAreaFilled(false);
		eye.setFocusPainted(false);
		eye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					userName = txtCcc.getText();
					char[] chars = textField.getPassword();
					String password = new String(chars);

					try {
						FileReader file = new FileReader("res\\Login\\Login.txt");
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

				if (chckbxNewCheckBox.isSelected()) {
					checkMacAddress();
					if (!macAddressFound) {
						try {
							FileWriter file2 = new FileWriter("res\\Login\\MacAddress.txt", true);
							file2.append(currentMacAddress + ";");
							file2.append(txtCcc.getText());
							file2.append("\n");
							file2.close();
							System.out.println("Scritto");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}

		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setFocusPainted(false);
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

	public String getMacAddress() {
		StringBuilder macAddress = new StringBuilder();
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localhost);

			byte[] macAddressBytes = networkInterface.getHardwareAddress();

			for (int i = 0; i < macAddressBytes.length; i++) {
				macAddress.append(
						String.format("%02X%s", macAddressBytes[i], (i < macAddressBytes.length - 1) ? "-" : ""));
			}

		} catch (UnknownHostException | SocketException e) {
			e.printStackTrace();
		}

		return macAddress.toString();
	}

	private void checkMacAddress() {
		try {
			FileReader file = new FileReader("res\\Login\\MacAddress.txt");
			BufferedReader reader = new BufferedReader(file);

			currentMacAddress = getMacAddress();

			String str;
			while ((str = reader.readLine()) != null) {
				String storedMacAddress[] = str.trim().split(";");

				if (currentMacAddress.equals(storedMacAddress[0])) {
					macAddressFound = true;
					break;
				}
			}

			reader.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private String getUserNameByMacAddress() {
		String username = "";
		try {
			FileReader file = new FileReader("res\\Login\\MacAddress.txt");
			BufferedReader reader = new BufferedReader(file);
			
			currentMacAddress = getMacAddress();

			String str;
			while ((str = reader.readLine()) != null) {
				String storedMacAddress[] = str.trim().split(";");

				if (currentMacAddress.equals(storedMacAddress[0])) {
					macAddressFound = true;
					username = storedMacAddress[1];
					break;
				}
			}

			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return username;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}
	
	
	
}
