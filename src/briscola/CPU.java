package briscola;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 * This class represents a CPU player in the game, inheriting from the Giocatore class.
 */

public class CPU extends Giocatore{

	/**
	 * Constructor for the CPU class.
	 * Initializes the CPU player with the nickname "CPU".
	 */

	public CPU() {
		super("CPU");
	}

	/**
	 * Overrides the lancia method to simulate CPU player's card throwing action.
	 *
	 * @param button The JButton representing the card to be thrown
	 * @param giocatore The player who is throwing the card (in this case, the CPU player)
	 * @param carta The card to be thrown
	 */

	@Override
	public void lancia(JButton button, Giocatore giocatore, Carta carta) {
		// Set the icon of the button to the image of the card
		button.setIcon(carta.getImg());
		button.repaint();

		// Create a timer to animate the card throwing action
		Timer timer = new Timer(10, new ActionListener() {
			// Initialize the initial position of the card
			private int y = button.getLocation().y;
			private int x = button.getLocation().x;
			@Override
			public void actionPerformed(ActionEvent e) {
				// If the card is not yet thrown to the desired position
				if (y < 200) {
					// Move the card diagonally towards the desired position
					if(button.getLocation().x > 598) {
						y += 10;
						x -= 10;
						button.setBounds(x, y, 89, 168);
						button.repaint();
					}else if(button.getLocation().x < 598) {
						y += 10;
						x += 10;
						button.setBounds(x, y, 89, 168);
						button.repaint();
					}else if(button.getLocation().x == 598) {
						y += 10;
						button.setBounds(x, y, 89, 168);
						button.repaint();
					}
				}

				// If the card reaches the desired position
				if(y == 200 && x == 598){
					((Timer) e.getSource()).stop(); // Stop the timer
				}

			}
		});

		timer.start();  // Start the timer to animate the card throwing action
	}
	
}
