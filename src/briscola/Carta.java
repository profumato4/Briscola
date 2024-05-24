package briscola;


import javax.swing.ImageIcon;


/**
 * This class represents a playing card in a card game.
 */

public class Carta {

	private String seme; // The suit of the card
	private String nome; // The name of the card
	private int valore; // The value of the card
	private ImageIcon img; // The image representing the card

	/**
	 * Constructor for the Carta class.
	 *
	 * @param seme The suit of the card
	 * @param nome The name of the card
	 * @param valore The value of the card
	 * @param img The image representing the card
	 */

    public Carta(String seme, String nome, int valore, ImageIcon img) {
        String[] semi = {"Spade", "Denara", "Coppe", "Bastoni"};
        for (String seme1 : semi) {
			if (seme.equals(seme1)) {
				this.seme = seme;
				break;
			} else {
				this.seme = "Nessun seme";
			}
		}

		this.nome = nome;
		
		if (valore == 11 || valore == 10 || valore == 4 || valore == 3 || valore == 2) {
			this.valore = valore;
		}else {
			this.valore = 0;
		}
		
		this.img = img;
		
	}

	/**
	 * Checks if the card is of the specified briscola suit.
	 *
	 * @param briscola The briscola suit to check against
	 * @return True if the card is of the specified briscola suit, otherwise false
	 */

    public boolean isBriscola(String briscola){
        return (this.seme.equalsIgnoreCase(briscola));
	}

	/**
	 * Compares two cards to determine the winner based on the specified briscola suit.
	 *
	 * @param c1 The first card to compare
	 * @param c2 The second card to compare
	 * @param briscola The briscola suit
	 * @return True if the first card wins, otherwise false
	 */

    public boolean comparaCarte(Carta c1, Carta c2, String briscola){
		// If both cards are briscola
        if(c1.isBriscola(briscola) && c2.isBriscola(briscola)) {
			// Check if the first card has a greater value
        	if(c1.getValore() > c2.getValore()) {
        		return true;
				// If both cards are briscola and their value is 0
        	}else if(c1.getValore() == 0  && c2.getValore() == 0) {
				// Then compare their names
        		if(Integer.valueOf(c1.getNome()) > Integer.valueOf(c2.getNome())) {
        			return true;
        		}
        	}
			// If the first card is a briscola but the second is not, the first card wins
        }else if(c1.isBriscola(briscola) && !c2.isBriscola(briscola)){
        	return true;
			// If the first card is not a briscola but the second is, the second card wins
        }else if(!c1.isBriscola(briscola) && c2.isBriscola(briscola)) {
        	return false;
			// If both cards have the same suit and are not briscole
        }else if(c1.getSeme().equals(c2.getSeme()) && !(c1.isBriscola(briscola) && c2.isBriscola(briscola))) {
			// Then check if the first card has a greater value
        	if(c1.getValore() > c2.getValore()) {
        		return true;
				// If both cards have a value of 0
        	}else if(c1.getValore() == 0  && c2.getValore() == 0) {
				// Then compare their names
        		if(Integer.valueOf(c1.getNome()) > Integer.valueOf(c2.getNome())) {
        			return true;
        		}
        	}
			// If the two cards have different suits and neither is a briscola, the first card thrown wins
        }else if(!(c1.getSeme().equals(c2.getSeme())) && !(c1.isBriscola(briscola) && c2.isBriscola(briscola))) {
        	return true;
        }
    	return false;
      }

	/**
	 * Gets the suit of the card.
	 *
	 * @return The suit of the card
	 */

	public String getSeme() {
		return seme;
	}

	/**
	 * Gets the name of the card.
	 *
	 * @return The name of the card
	 */

	public String getNome() {
		return nome;
	}

	/**
	 * Gets the image representing the card.
	 *
	 * @return The image representing the card
	 */

	public ImageIcon getImg() {
		return img;
	}

	/**
	 * Gets the value of the card.
	 *
	 * @return The value of the card
	 */
	
	public int getValore() {
		return valore;
	}

	/**
	 * Sets the image representing the card.
	 *
	 * @param img The image to set
	 */

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	/**
	 * Gets the card itself.
	 *
	 * @return The card
	 */

	public Carta getCarta() {
		return this;
	}

	/**
	 * Returns a string representation of the card.
	 */

	@Override
	public String toString() {
		return "[seme:" + seme + ", nome:" + nome + ", valore:" + valore + "]";
	}

}
