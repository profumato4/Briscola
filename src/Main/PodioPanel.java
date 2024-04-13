package Main;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class PodioPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PodioPanel() {
		setSize(1178, 861);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Work in progress");
		lblNewLabel.setBounds(614, 355, 266, 14);
		add(lblNewLabel);
		
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
