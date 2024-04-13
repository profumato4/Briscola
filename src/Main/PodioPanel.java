package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PodioPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Database db;
	private ArrayList<String> nomi;
	private int y = 200;
	
	/**
	 * Create the panel.
	 */
	public PodioPanel(Database db) {
		
		this.db = db;
		
		setSize(1178, 861);
		setLayout(null);
		
		
		JLabel copyright = new JLabel("Copyright (c) 2024 Leonardo Belli");
		copyright.setFont(new Font("Serif", Font.PLAIN, 14));
		copyright.setBounds(960, 793, 428, 30);
		copyright.setForeground(new Color(51,51,51));
		add(copyright);
		
		players();
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("res/Background/background4.png").getImage(), 0, 0, null);
	}
	
	private void players() {
		nomi = db.topPlayers();
		
		for(String nome : nomi) {
			JLabel label = new JLabel(nome);
			label.setFont(new Font("Tahoma", Font.PLAIN, 50));
			label.setBounds(430, y, 500 ,55);
			y += 100;
			add(label);
		}
		
	}
	
}
