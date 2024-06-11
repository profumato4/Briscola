package utils;

import briscola.Carta;
import briscola.Giocatore;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SelectCardManager {

    private String briscola;
    private JButton[] cardsButtons;

    public SelectCardManager(String briscola, JButton[] cardsButtons) {
        this.cardsButtons = cardsButtons;
        this.briscola = briscola;
    }

    public int selectCard(Giocatore g2, Giocatore g1) {
        if (g1.isLanciata()) {
            int thrownCardIndex = findThrownCard();
            if (thrownCardIndex != -1) {
                return selectBestResponseCard(g2, g1.getMano().get(thrownCardIndex).getCarta());
            }
        }
        return selectBestStartingCard(g2, g1);
    }

    private int selectBestResponseCard(Giocatore g2, Carta thrownCard) {
        ArrayList<Integer> punti = new ArrayList<>(Arrays.asList(0, 0, 0));

        for (int i = 0; i < g2.getMano().size(); i++) {
            Carta cartaG2 = g2.getMano().get(i).getCarta();
            if (!thrownCard.comparaCarte(thrownCard, cartaG2, briscola)) {
                System.out.println(cartaG2 + " vince : " + thrownCard);
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

    private int selectBestStartingCard(Giocatore g2, Giocatore g1) {
        int maxPunti = -1;
        int bestIndex = -1;

        for (int i = 0; i < g2.getMano().size(); i++) {
            int puntiAttuali = 0;
            Carta cartaG2 = g2.getMano().get(i).getCarta();

            for (int j = 0; j < g1.getMano().size(); j++) {
                Carta cartaG1 = g1.getMano().get(j).getCarta();
                if (cartaG2.comparaCarte(cartaG2, cartaG1, briscola)) {
                    puntiAttuali += cartaG1.getValore() + cartaG2.getValore();
                }
            }

            if (puntiAttuali > maxPunti) {
                maxPunti = puntiAttuali;
                bestIndex = i;
            }
        }

        if (bestIndex == -1) {
            return new Random().nextInt(g2.getMano().size());
        }

        return bestIndex;
    }

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

    private int findThrownCard() {
        for (int i = 0; i < cardsButtons.length; i++) {
            if (cardsButtons[i].getLocation().x == 548 && cardsButtons[i].getLocation().y == 300) {
                return i;
            }
        }
        return -1;
    }
}
