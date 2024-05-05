package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class PodioPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Database db;
	private ArrayList<String> nomi;
	private int y = 200;
	private JPanel panel;
	private BackgroundPanel bp;
	
	/**
	 * Create the panel.
	 */
	public PodioPanel(Database db, JPanel panel) {
		
		this.db = db;
		this.panel = panel;
		
		setSize(1178, 861);
		setLayout(null);
		
		bp = new BackgroundPanel("res/Background/background4.png");
		add(bp, BorderLayout.CENTER);
		
		players();
		keyBindings();
		
	}	

	
	private void players() {
		nomi = db.topPlayers();
		
		for(String nome : nomi) {
			JLabel label = new JLabel(nome);
			label.setFont(new Font("Tahoma", Font.PLAIN, 50));
			label.setBounds(430, y, 500 ,55);
			y += 100;
			bp.add(label);
		}
		
	}
	
	private void keyBindings() {
		InputMap inputMap = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = this.getActionMap();

		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "esc");

		actionMap.put("esc", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				panel.setVisible(true);
			}
		});
	}
	
}
