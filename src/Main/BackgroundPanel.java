package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public BackgroundPanel() {
		
		setSize(1178, 861);
		setLayout(null);
		
		JLabel copyright = new JLabel("Copyright (c) 2024 Leonardo Belli");
		copyright.setFont(new Font("Serif", Font.PLAIN, 14));
		copyright.setBounds(960, 793, 428, 30);
		copyright.setForeground(new Color(51,51,51));
		add(copyright);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("res/Background/background4.png").getImage(), 0, 0, null);
	}
	
}
