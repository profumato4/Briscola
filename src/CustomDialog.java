import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

class CustomDialog extends JDialog {

	private int i = 0;
	private String carte = "Piacentine";

	public CustomDialog(JFrame parent) {
		super(parent, true);

		JLabel imageLabel = new JLabel(new ImageIcon("res/Cards/card2.jpg"));
		imageLabel.setBounds(200, 200, 100, 172);

		JPanel panel = new JPanel(new BorderLayout());

		JLabel text = new JLabel("Piacentine");
		text.setFont(new Font("Arial", Font.BOLD, 26));
		text.setBounds(130, 0, 140, 50);

		JButton left = new JButton(new ImageIcon("res/Arrows/left2.png"));
		left.setBounds(10, 120, 120, 120);
		left.setBorderPainted(false);
		left.setContentAreaFilled(false);
		left.setFocusPainted(false);

		left.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (i == 0) {
					text.setText("Piacentine");
					imageLabel.setIcon(new ImageIcon("res/Cards/card2.jpg"));
					i = 1;
				} else if (i == 1) {
					text.setText("Napoletane");
					imageLabel.setIcon(new ImageIcon("res/Cards/card1.jpg"));
					i = 0;
				}

			}
		});

		JButton right = new JButton(new ImageIcon("res/Arrows/right2.png"));
		right.setBounds(260, 120, 120, 120);
		right.setBorderPainted(false);
		right.setContentAreaFilled(false);
		right.setFocusPainted(false);

		right.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (i == 0) {
					text.setText("Piacentine");
					imageLabel.setIcon(new ImageIcon("res/Cards/card2.jpg"));

					i = 1;
				} else if (i == 1) {
					text.setText("Napoletane");
					imageLabel.setIcon(new ImageIcon("res/Cards/card1.jpg"));
					i = 0;
				}

			}
		});
		
		JButton conferma = new JButton("Conferma");
		conferma.setFont(new Font("Arial", Font.BOLD, 26));
		conferma.setBounds(190, 320, 180, 40);
		conferma.setFocusPainted(false);
		
		conferma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				carte = text.getText();
				System.out.println(carte);
				dispose();
			}
		});
		
		JButton annulla = new JButton("Annulla");
		annulla.setFont(new Font("Arial", Font.BOLD, 26));
		annulla.setBounds(10, 320, 180, 40);
		annulla.setFocusPainted(false);
		
		annulla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		panel.add(annulla);
		panel.add(conferma);
		panel.add(left);
		panel.add(right);
		panel.add(text);
		panel.add(imageLabel);
		getContentPane().add(panel);

		setSize(400, 400);

		setLocationRelativeTo(parent);
	}
	
	public String getCarteType() {
		return carte;
	}
	
}