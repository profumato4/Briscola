package briscola;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Represents the panel displayed when the game is over, showing the result (win, lose, tie).
 * It allows the user to restart the game by clicking on the panel.
 */

public class GameOverPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a GameOverPanel object.
	 *
	 * @param b The Briscola object representing the game
	 */

	public GameOverPanel(Briscola b) {
		// Add a mouse listener to the panel to handle restart when clicked
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Remove all components from the main panel
				b.getPanel().removeAll();
				// Initialize the game again
				b.inizialize2(b.getDb());
				// Repaint the main panel
				b.getPanel().repaint();
			}
		});
		setSize(1178, 861);
		setLayout(null);
		setOpaque(false);
				
		
	}

	/**
	 * Displays the "Win" message and emoji.
	 */

	public void wins() {
		JLabel text = new JLabel("Vinto");
		text.setFont(new Font("Maiandra GD", Font.PLAIN, 180));
		text.setBounds(153, 359, 523, 199);
		text.setOpaque(false);
		add(text);
		
		JLabel emoji = new JLabel("\uD83D\uDE01!");
		emoji.setOpaque(false);
		emoji.setFont(new Font("Noto Emoji", Font.PLAIN, 180));
		emoji.setBounds(623, 357, 271, 199);
		add(emoji);
		
		JLabel text2 = new JLabel("Hai");
		text2.setOpaque(false);
		text2.setFont(new Font("Maiandra GD", Font.PLAIN, 180));
		text2.setBounds(337, 160, 430, 199);
		add(text2);
	}

	/**
	 * Displays the "Lose" message and emoji.
	 */

	public void lose() {
		JLabel text = new JLabel("Perso");
		text.setFont(new Font("Maiandra GD", Font.PLAIN, 180));
		text.setBounds(221, 362, 510, 199);
		text.setOpaque(false);
		add(text);
		
		JLabel emoji = new JLabel("\uD83D\uDE21");
		emoji.setOpaque(false);
		emoji.setFont(new Font("Noto Emoji", Font.PLAIN, 180));
		emoji.setBounds(661, 360, 271, 199);
		add(emoji);
		
		JLabel text2 = new JLabel("Hai");
		text2.setOpaque(false);
		text2.setFont(new Font("Maiandra GD", Font.PLAIN, 180));
		text2.setBounds(356, 160, 430, 199);
		add(text2);
	}

	/**
	 * Displays the "Tie" message and emoji.
	 */

	public void tie() {
		JLabel text = new JLabel("Pareggiato");
		text.setOpaque(false);
		text.setFont(new Font("Maiandra GD", Font.PLAIN, 130));
		text.setBounds(90, 322, 836, 199);
		add(text);
		
		JLabel emoji = new JLabel("\uD83D\uDE0A");
		emoji.setOpaque(false);
		emoji.setFont(new Font("Dialog", Font.PLAIN, 130));
		emoji.setBounds(730, 322, 271, 199);
		add(emoji);
		
		JLabel text2 = new JLabel("Avete");
		text2.setOpaque(false);
		text2.setFont(new Font("Maiandra GD", Font.PLAIN, 130));
		text2.setBounds(262, 165, 607, 199);
		add(text2);
	}
}
