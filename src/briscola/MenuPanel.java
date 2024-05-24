package briscola;

import javax.swing.JPanel;


import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * MenuPanel is a JPanel subclass that provides a customizable menu interface with options
 * such as resume, restart, and home. Each option is represented by a JLabel that triggers
 * an action when clicked.
 */

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;


	/**
	 * Constructs a MenuPanel with the specified cardButtons, ResumeButtonListener, and Briscola instance.
	 *
	 * @param cardButtons an array of JButton objects representing card buttons
	 * @param listener    a ResumeButtonListener to handle resume button clicks
	 * @param b           the Briscola instance associated with this menu panel
	 */

	public MenuPanel(JButton[] cardButtons, ResumeButtonListener listener, Briscola b) {
		setSize(1178, 861);
		setLayout(null);
		setOpaque(false);

		// Resume Label

		JLabel resume = new JLabel("Resume");
		resume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(JButton card : cardButtons) {
					card.setEnabled(true);
				}
				setVisible(false);
				
				if(listener != null) {
					listener.onResumeClicked((byte) 0); 
				}
				
			}
		});
		resume.setFont(new Font("Maiandra GD", Font.PLAIN, 200));
		resume.setBounds(301, 11, 756, 199);
		resume.setOpaque(false);
		add(resume);

		// Restart Label

		JLabel restart = new JLabel("Restart");
		restart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				b.getPanel().removeAll();
				b.game();
				b.getPanel().repaint();
			}
		});
		restart.setFont(new Font("Maiandra GD", Font.PLAIN, 200));
		restart.setBounds(301, 282, 756, 199);
		restart.setOpaque(false);
		add(restart);

		// Home Label

		JLabel home = new JLabel("Home");
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				b.getPanel().removeAll();
				b.setN(10);
				b.inizialize2(b.getDb());
				b.getPanel().repaint();
			}
		});
		home.setFont(new Font("Maiandra GD", Font.PLAIN, 200));
		home.setBounds(364, 580, 756, 199);
		home.setOpaque(false);
		add(home);
	}
}
