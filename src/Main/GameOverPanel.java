package Main;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public GameOverPanel() {
		setSize(1178, 861);
		setLayout(null);
		setOpaque(false);
				
		lose();
	}
	
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
	
}
