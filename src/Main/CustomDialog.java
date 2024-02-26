package Main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CustomDialog extends JDialog {

	private String carte;
	
	public CustomDialog() {
		
	}
	
	public CustomDialog(JFrame parent) {
		super(parent, true);
		

		JPanel panel = new JPanel(new BorderLayout());

		JLabel text = new JLabel(readCardType());
		text.setFont(new Font("Arial", Font.BOLD, 26));
		text.setBounds(130, 0, 140, 50);
		
		JLabel imageLabel = new JLabel(new ImageIcon("res/Cards/card2.jpg"));
		imageLabel.setBounds(200, 200, 100, 172);
		
		if(readCardType().equals("Napoletane")) {
			text.setText("Napoletane");
			imageLabel.setIcon(new ImageIcon("res/Cards/card1.jpg"));
		}else if(readCardType().equals("Piacentine")) {
			text.setText("Piacentine");
			imageLabel.setIcon(new ImageIcon("res/Cards/card2.jpg"));
		}else if(readCardType().equals("Siciliane")){
			text.setText("Siciliane");
			imageLabel.setIcon(new ImageIcon("res/Cards/card3.jpg"));
		}


		JButton left = new JButton(new ImageIcon("res/Arrows/left2.png"));
		left.setBounds(10, 120, 120, 120);
		left.setBorderPainted(false);
		left.setContentAreaFilled(false);
		left.setFocusPainted(false);

		left.addActionListener(e -> {

			if (text.getText().equals("Siciliane")) {
				text.setText("Napoletane");
				imageLabel.setIcon(new ImageIcon("res/Cards/card1.jpg"));
			} else if (text.getText().equals("Napoletane")) {
				text.setText("Piacentine");
				imageLabel.setIcon(new ImageIcon("res/Cards/card2.jpg"));
			}else if(text.getText().equals("Piacentine")){
				text.setText("Siciliane");
				imageLabel.setIcon(new ImageIcon("res/Cards/card3.jpg"));
			}

        });

		JButton right = new JButton(new ImageIcon("res/Arrows/right2.png"));
		right.setBounds(260, 120, 120, 120);
		right.setBorderPainted(false);
		right.setContentAreaFilled(false);
		right.setFocusPainted(false);

		right.addActionListener(e -> {

			if (text.getText().equals("Siciliane")) {
				text.setText("Piacentine");
				imageLabel.setIcon(new ImageIcon("res/Cards/card2.jpg"));
			} else if (text.getText().equals("Piacentine")) {
				text.setText("Napoletane");
				imageLabel.setIcon(new ImageIcon("res/Cards/card1.jpg"));
			}else if(text.getText().equals("Napoletane")){
				text.setText("Siciliane");
				imageLabel.setIcon(new ImageIcon("res/Cards/card3.jpg"));
			}
		});
		
		JButton conferma = new JButton("Conferma");
		conferma.setFont(new Font("Arial", Font.BOLD, 26));
		conferma.setBounds(190, 320, 180, 40);
		conferma.setFocusPainted(false);
		
		conferma.addActionListener(e -> {

            carte = text.getText();
            System.out.println(carte);
            try {
                writeCardType(carte);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            dispose();
        });
		
		JButton annulla = new JButton("Annulla");
		annulla.setFont(new Font("Arial", Font.BOLD, 26));
		annulla.setBounds(10, 320, 180, 40);
		annulla.setFocusPainted(false);
		
		annulla.addActionListener(e -> dispose());
		
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
	
	private void writeCardType(String cardType) throws IOException {
		FileWriter file = new FileWriter("res/CardsType/cardsType.txt");
		file.append(cardType);
		file.close();
	}
	
	public String readCardType(){
		try {
			FileReader file = new FileReader("res/CardsType/cardsType.txt");
			BufferedReader reader = new BufferedReader(file);
			carte = reader.readLine();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return carte;
	}
	
}