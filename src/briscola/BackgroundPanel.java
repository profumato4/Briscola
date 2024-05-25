package briscola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A JPanel class for displaying a background image with additional components.
 */

public class BackgroundPanel extends JPanel {

	private static final Logger logger = LoggerFactory.getLogger(BackgroundPanel.class);


	private static final long serialVersionUID = 1L;
	private String path;


	/**
	 * Constructs a BackgroundPanel with the specified background image path.
	 *
	 * @param path The path to the background image
	 */

	public BackgroundPanel(String path ) {

		LogbackConfigurator.configure("res/logs/logback.xml");

		// Set the background image path
		this.path = path;

		// Set panel size and layout
		setSize(1178, 861);
		setLayout(null);

		// Add copyright label
		JLabel copyright = new JLabel("Copyright (c) 2024 Leonardo Belli");
		copyright.setFont(new Font("Serif", Font.PLAIN, 14));
		copyright.setBounds(960, 793, 428, 30);
		copyright.setForeground(new Color(51,51,51));
		add(copyright);
		
	}

	/**
	 * Overrides the paintComponent method to draw the background image.
	 *
	 * @param g The Graphics context to draw on
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Draw the background image
		try{
			ImageIcon background = new ImageIcon(path);
			g.drawImage(background.getImage(), 0, 0, null);
		}catch(Exception e){
			logger.error("Error loading background image", e);
		}

	}
	
}
