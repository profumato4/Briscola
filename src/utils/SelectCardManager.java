package utils;

import briscola.Carta;
import briscola.Giocatore;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * The SelectCardManager class manages the selection of cards for a player in the game of Briscola.
 * It determines the best card to play based on the current game state and the opponent's actions.
 */

public class SelectCardManager {

    private final String briscola;
    private final JButton[] cardsButtons;

    /**
     * Constructor for the SelectCardManager class.
     *
     * @param briscola the briscola suit for the current game
     * @param cardsButtons the array of buttons representing the player's cards
     */

    public SelectCardManager(String briscola, JButton[] cardsButtons) {
        this.cardsButtons = cardsButtons;
        this.briscola = briscola;
    }

    /**
     * Selects the best card to play for the current player.
     *
     * @param g2 the current player
     * @param g1 the opponent player
     * @return the index of the selected card
     */

    public int selectCard(Giocatore g2, Giocatore g1) {
        if (g1.isLanciata()) {
            int thrownCardIndex = findThrownCard();
            if (thrownCardIndex != -1) {
                return selectBestResponseCard(g2, g1.getMano().get(thrownCardIndex).getCarta());
            }
        }
        return selectBestStartingCard(g2, g1);
    }

    /**
     * Selects the best response card for the current player based on the opponent's thrown card.
     *
     * @param g2 the current player
     * @param thrownCard the card thrown by the opponent
     * @return the index of the selected card
     */

    private int selectBestResponseCard(Giocatore g2, Carta thrownCard) {
        ArrayList<Integer> punti = new ArrayList<>(Arrays.asList(0, 0, 0));

        for (int i = 0; i < g2.getMano().size(); i++) {
            Carta cartaG2 = g2.getMano().get(i).getCarta();
            if (!thrownCard.comparaCarte(thrownCard, cartaG2, briscola)) {
                punti.set(i, thrownCard.getValore() + cartaG2.getValore());
            }
        }

        int maxPunti = Collections.max(punti);
        int maxIndex = punti.indexOf(maxPunti);

        if (maxPunti == 0) {
            return selectLowestValueCard(g2);
        }
        return maxIndex;
    }

    /**
     * Selects the best starting card for the current player.
     *
     * @param g2 the current player
     * @param g1 the opponent player
     * @return the index of the selected card
     */

    private int selectBestStartingCard(Giocatore g2, Giocatore g1) {
        int maxPunti = -1;
        int bestIndex = -1;

        for (int i = 0; i < g2.getMano().size(); i++) {
            int puntiAttuali = 0;
            Carta cartaG2 = g2.getMano().get(i).getCarta();
            boolean cartaG2Briscola = cartaG2.isBriscola(briscola);

            for (int j = 0; j < g1.getMano().size(); j++) {
                Carta cartaG1 = g1.getMano().get(j).getCarta();
                boolean cartaG1Briscola = cartaG1.isBriscola(briscola);

                //if both are briscole or if neither is a briscola
                if (cartaG2Briscola == cartaG1Briscola) {
                    if (cartaG2.comparaCarte(cartaG2, cartaG1, briscola)) {
                        puntiAttuali += cartaG1.getValore() + cartaG2.getValore();
                    }
                }
                // If only the opponent's card is a briscola
                else if (cartaG1Briscola) {
                    puntiAttuali -= cartaG1.getValore();
                }
                // If only the bot's card is a trump
                else if (cartaG2Briscola) {
                    puntiAttuali += cartaG1.getValore();
                }
            }

            if (puntiAttuali > maxPunti) {
                maxPunti = puntiAttuali;
                bestIndex = i;
            }
        }

        if (bestIndex == -1) {
            return selectLowestValueCard(g2);
        }

        return bestIndex;
    }

    /**
     * Selects the card with the lowest value from the current player's hand.
     *
     * @param g2 the current player
     * @return the index of the selected card
     */

    private int selectLowestValueCard(Giocatore g2) {
        int minPunti = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < g2.getMano().size(); i++) {
            int valoreCarta = g2.getMano().get(i).getCarta().getValore();
            if (valoreCarta < minPunti) {
                minPunti = valoreCarta;
                minIndex = i;
            }
        }

        if (g2.getMano().get(minIndex).getCarta().isBriscola(briscola) && minPunti > 4) {
            for (int i = 0; i < g2.getMano().size(); i++) {
                if (!g2.getMano().get(i).getCarta().isBriscola(briscola) || g2.getMano().get(i).getCarta().getValore() <= 4) {
                    return i;
                }
            }
        }

        return minIndex;
    }



    /**
     * Finds the index of the thrown card based on the location of the card buttons.
     *
     * @return the index of the thrown card or -1 if no card is found
     */

    private int findThrownCard() {
        for (int i = 0; i < cardsButtons.length; i++) {
            if (cardsButtons[i].getLocation().x == 548 && cardsButtons[i].getLocation().y == 300) {
                return i;
            }
        }
        return -1;
    }
}
