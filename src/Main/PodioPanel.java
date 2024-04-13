package Main;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

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
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("res/Background/background4.png").getImage(), 0, 0, null);
	}
}
