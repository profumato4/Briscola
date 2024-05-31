package briscola;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.Timer;

/**
 * This class represents a player in the game.
 */

public class Giocatore {

	private final String nickName; // The nickname of the player
	private final ArrayList<Carta> mano; // The player's hand of cards
	private int punteggio; // The player's score
	private boolean lanciata = false; // Flag indicating whether the player has thrown a card


	/**
	 * Constructor for the Giocatore class.
	 *
	 * @param nickName The nickname of the player
	 */

	public Giocatore(String nickName) {
		this.nickName = nickName;
		this.mano = new ArrayList<>();
		this.punteggio = 0;
	}

	/**
	 * Gets the player's hand of cards.
	 *
	 * @return The player's hand of cards
	 */

	public ArrayList<Carta> getMano() {
		return mano;
	}

	/**
	 * Gets the nickname of the player.
	 *
	 * @return The nickname of the player
	 */

	public String getNickName() {
		return nickName;
	}

	/**
	 * Throws a card from the player's hand.
	 *
	 * @param button The JButton representing the card to be thrown
	 * @param giocatore The player who is throwing the card
	 * @param carta The card to be thrown
	 */

	public void lancia(JButton button, Giocatore giocatore, Carta carta) {
		// Create a Timer to animate the card throwing action
		Timer timer = new Timer(10, new ActionListener() {
			// Initialize the initial position of the card
			private int y = button.getLocation().y;
			private int x = button.getLocation().x;
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// Mark the card as thrown
				lanciata = true;

				// If the card is above the desired position

				if (y > 300) {
					// Move the card upwards
					y -= 20;
					button.setBounds(x, y, 89, 168);
					button.repaint();
				}

				// If the card reaches the desired vertical position
				if(y == 300) {
					// If the card is to the right of the desired position
					if (button.getLocation().x > 548) {
						// Move the card to the left
						x -= 10;
						button.setBounds(x, y, 89, 168);
						button.repaint();
						// If the card is to the left of the desired position
					} else if (button.getLocation().x < 548) {
						// Move the card to the right
						x += 10;
						button.setBounds(x, y, 89, 168);
						button.repaint();
						// If the card reaches the desired position (both horizontally and vertically)
					} else if (button.getLocation().x == 548 && button.getLocation().y == 300) {
						((Timer) e.getSource()).stop(); // Stop the Timer
					}
				}
				
			}
		});

		timer.start(); // Start the Timer to animate the card throwing action
	}

	/**
	 * Sets the player's score.
	 *
	 * @param punteggio The score to set
	 */

	public void setPunteggio(int punteggio){
		this.punteggio = punteggio;
	}

	/**
	 * Gets the player's score.
	 *
	 * @return The player's score
	 */

	public int getPunteggio(){
		return  punteggio;
	}

	/**
	 * Checks if a card has been thrown by the player.
	 *
	 * @return True if a card has been thrown, otherwise false
	 */

	public boolean isLanciata() {
		return lanciata;
	}

	/**
	 * Sets the flag indicating whether a card has been thrown by the player.
	 *
	 * @param lanciata The value to set for the flag
	 */

	public void setLanciata(boolean lanciata) {
		this.lanciata = lanciata;
	}
	
}
