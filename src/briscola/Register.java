package briscola;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * The Register class represents the user registration interface.
 * It allows users to register by providing a username and password.
 */

public class Register {

	private JFrame frame;
	private JTextField txtCcc;
	private JPasswordField textField;
	private JPasswordField textField_1;
	private boolean hide = true;
	private boolean hide2 = true;
	private Database db;
	private ImageLoader imgLoad = new ImageLoader();

	/**
	 * Constructs a new Register object.
	 * @param login The login instance associated with the registration process.
	 * @param db The database instance used for user registration.
	 */

	public Register(Login login, Database db) {
		this.db = db;
		initialize(login);
	}

	/**
	 * Initializes the user registration interface.
	 * @param login The login instance associated with the registration process.
	 */

	private void initialize(Login login) {
        frame = new JFrame();
		frame.setBounds(100, 100, 416, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton eye1 = new JButton(imgLoad.loadImage("res/Login/hide2.png"));
		eye(eye1);
		eye1.setBounds(280, 190, 20, 20);
		frame.getContentPane().add(eye1);
		frame.getContentPane().setComponentZOrder(eye1, 0);

		JButton eye2 = new JButton(imgLoad.loadImage("res/Login/hide2.png"));
		eye(eye2);
		eye2.setBounds(280, 245, 20, 20);
		frame.getContentPane().add(eye2);
		frame.getContentPane().setComponentZOrder(eye2, 0);

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

		textField = new JPasswordField();
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
		btnNewButton.addActionListener(e -> {
            String username = txtCcc.getText();
            char[] chars1 = textField.getPassword();
            String password1 = new String(chars1);
            char[] chars2 = textField_1.getPassword();
            String password2 = new String(chars2);

            if (password1.equals(password2)) {
                db.registerUser(username, password1);
                txtCcc.setText("");
                textField.setText("");
                textField_1.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Le password non coincidono", "Register",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        });
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(78, 300, 229, 23);
		btnNewButton.setFocusPainted(false);
		frame.getContentPane().add(btnNewButton);

		JButton btnRegister = new JButton("Back to login");
		btnRegister.addActionListener(e -> {
            if (login.isLogged()) {
                JOptionPane.showMessageDialog(frame, "Utente già loggato", "Login",
                        JOptionPane.INFORMATION_MESSAGE);
                login.getBriscolaFrame().setVisible(true);
                frame.setVisible(false);
            } else{
                login.getFrame().setVisible(true);
                frame.setVisible(false);
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

		textField_1 = new JPasswordField();
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

	/**
	 * Retrieves the frame associated with the registration interface.
	 * @return The JFrame instance representing the registration interface.
	 */

	private void eye(JButton eye){
		eye.setBorderPainted(false);
		eye.setContentAreaFilled(false);
		eye.setFocusPainted(false);
		eye.addActionListener(e -> {
			if (hide) {
				eye.setIcon(imgLoad.loadImage("res/Login/view2.png"));
				eye.repaint();
				textField.setEchoChar((char) 0);
				hide = false;
			} else {
				eye.setIcon(imgLoad.loadImage("res/Login/hide2.png"));
				eye.repaint();
				textField.setEchoChar('\u2022');
				hide = true;
			}

		});
	}

	public JFrame getFrame() {
		return frame;
	}


}
