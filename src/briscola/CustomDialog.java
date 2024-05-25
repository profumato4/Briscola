package briscola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A custom dialog window used for selecting a card type in the Briscola game.
 * This dialog allows the user to choose between different card types, displaying
 * an image corresponding to the selected type.
 */

class CustomDialog extends JDialog {

	private static final Logger logger = LoggerFactory.getLogger(CustomDialog.class);

	private static final long serialVersionUID = 1L;
	private String carte;
	private Color color = Color.decode("#7fc7c2");
	private FileManager fm = new FileManager("res/CardsType/cardsType.txt");
	private JLabel text;
	private ImageLoader imgLoad = new ImageLoader();
	
	public CustomDialog() {
		LogbackConfigurator.configure("res/logs/logback.xml");
	}

	/**
	 * Constructs a new instance of the CustomDialog class.
	 * @param parent The parent JFrame to which the dialog is attached.
	 */

	public CustomDialog(JFrame parent) {
		super(parent, true);

		LogbackConfigurator.configure("res/logs/logback.xml");

		// panel setup

		JPanel panel = new JPanel(new BorderLayout());

		// text label setup

		text = new JLabel();
		text.setFont(new Font("Arial", Font.BOLD, 26));
		text.setBounds(130, 0, 140, 50);

		// image label setup

		JLabel imageLabel = new JLabel(imgLoad.loadImage("res/Cards/card2.jpg"));
		imageLabel.setBounds(200, 200, 100, 172);

		updateImageLabel(imageLabel, readCardType());

		// buttons setup

		JButton left = getLeftButton(text, imageLabel);

		JButton right = getRightButton(text, imageLabel);

		JButton conferma = getConfermaButton(text);

		JButton annulla = getAnnullaButton();

		// Adding components to the panel

		panel.add(annulla);
		panel.add(conferma);
		panel.add(left);
		panel.add(right);
		panel.add(text);
		panel.add(imageLabel);
		getContentPane().add(panel);

		// Dialog window setup

		setSize(400, 400);
		setLocationRelativeTo(parent);
	}

	/**
	 * Updates the image label based on the selected card type.
	 * If an error occurs while loading the image, it is logged.
	 * @param imageLabel The JLabel to update.
	 * @param cardType The selected card type.
	 */
	private void updateImageLabel(JLabel imageLabel, String cardType) {
		String imagePath = "";
		switch (cardType) {
			case "Napoletane":
				text.setText("Napoletane");
				imagePath = "res/Cards/card1.jpg";
				break;
			case "Piacentine":
				text.setText("Piacentine");
				imagePath = "res/Cards/card2.jpg";
				break;
			case "Siciliane":
				text.setText("Siciliane");
				imagePath = "res/Cards/card3.jpg";
				break;
			default:
				// Default case: do nothing
				return;
		}

		imageLabel.setIcon(imgLoad.loadImage(imagePath));

	}

	/**
	 * Loads an image from the specified path and sets it as the icon of the given JButton.
	 *
	 * @param button The JButton to set the image icon to.
	 * @param path   The path of the image file to load.
	 */

	private void loadImageToButton(JButton button, String path){

		button.setIcon(imgLoad.loadImage(path));

	}

	/**
	 * Loads an image from the specified path and sets it as the icon of the given JLabel.
	 *
	 * @param label The JLabel to set the image icon to.
	 * @param path  The path of the image file to load.
	 */

	private void loadImageToLabel(JLabel label, String path){

		label.setIcon(imgLoad.loadImage(path));

	}

	/**
	 * Creates and configures the "Right" button.
	 * This button allows the user to navigate to the next card type option.
	 * @param text The label displaying the selected card type.
	 * @param imageLabel The label displaying the card image.
	 * @return The configured "Right" button.
	 */

	private JButton getRightButton(JLabel text, JLabel imageLabel) {
		JButton right = new JButton();
		loadImageToButton(right, "res/arrows/right2.png");
		right.setBounds(260, 120, 120, 120);
		right.setBorderPainted(false);
		right.setContentAreaFilled(false);
		right.setFocusPainted(false);

		right.addActionListener(e -> {

			if (text.getText().equals("Siciliane")) {
				text.setText("Piacentine");
				loadImageToLabel(imageLabel,"res/Cards/card2.jpg" );
			} else if (text.getText().equals("Piacentine")) {
				text.setText("Napoletane");
				loadImageToLabel(imageLabel,"res/Cards/card1.jpg" );
			}else if(text.getText().equals("Napoletane")){
				text.setText("Siciliane");
				loadImageToLabel(imageLabel,"res/Cards/card3.jpg" );
			}
		});
		return right;
	}

	/**
	 * Creates and configures the "Left" button.
	 * This button allows the user to navigate to the previous card type option.
	 * @param text The label displaying the selected card type.
	 * @param imageLabel The label displaying the card image.
	 * @return The configured "Left" button.
	 */

	private JButton getLeftButton(JLabel text, JLabel imageLabel) {
		JButton left = new JButton();
		loadImageToButton(left, "res/arrows/left2.png");
		left.setBounds(10, 120, 120, 120);
		left.setBorderPainted(false);
		left.setContentAreaFilled(false);
		left.setFocusPainted(false);

		left.addActionListener(e -> {

			if (text.getText().equals("Siciliane")) {
				text.setText("Napoletane");
				loadImageToLabel(imageLabel,"res/Cards/card1.jpg" );
			} else if (text.getText().equals("Napoletane")) {
				text.setText("Piacentine");
				loadImageToLabel(imageLabel,"res/Cards/card2.jpg" );
			}else if(text.getText().equals("Piacentine")){
				text.setText("Siciliane");
				loadImageToLabel(imageLabel,"res/Cards/card3.jpg" );
			}

        });
		return left;
	}

	/**
	 * Creates and configures the "Annulla" button.
	 * This button cancels the selection and closes the dialog.
	 * @return The configured "Annulla" button.
	 */

	private JButton getAnnullaButton() {
		JButton annulla = new JButton("Annulla");
		annulla.setFont(new Font("Arial", Font.BOLD, 26));
		annulla.setBounds(10, 320, 180, 40);
		buttonListener(annulla);

		annulla.addActionListener(e -> dispose());
		return annulla;
	}

	/**
	 * Creates and configures the "Conferma" button.
	 * This button confirms the selection of the card type.
	 * @param text The label displaying the selected card type.
	 * @return The configured "Conferma" button.
	 */

	private JButton getConfermaButton(JLabel text) {
		JButton conferma = new JButton("Conferma");
		conferma.setFont(new Font("Arial", Font.BOLD, 26));
		conferma.setBounds(190, 320, 180, 40);
		buttonListener(conferma);

		conferma.addActionListener(e -> {

            carte = text.getText();
            writeCardType(carte);
            dispose();
        });
		return conferma;
	}

	/**
	 * Configures the mouse listener for the provided button to change its background color on hover.
	 * @param button The button to which the mouse listener is added.
	 */

	private void buttonListener(JButton button) {
		g(button, color);
	}

	/**
	 * Configures the mouse listener for the provided button to change its background color on hover.
	 * @param button The button to which the mouse listener is added.
	 * @param color  The color to use for the button background on hover.
	 */

	static void g(JButton button, Color color) {
		button.setFocusPainted(false);

		button.setBackground(Color.white);

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(color);
				button.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(Color.white);
				button.repaint();
			}

		});
	}

	/**
	 * Retrieves the selected card type.
	 * @return The selected card type.
	 */

	public String getCarteType() {
		return carte;
	}

	/**
	 * Writes the selected card type to a file.
	 * @param cardType The selected card type to be written.
	 */

	private void writeCardType(String cardType){
		fm.append(cardType);
	}

	/**
	 * Reads the previously selected card type from a file.
	 * @return The previously selected card type.
	 */

	public String readCardType(){
		carte = fm.readString();
		
		return carte;
	}
	
}