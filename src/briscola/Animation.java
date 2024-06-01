package briscola;

import log.ColorLogger;
import utils.ImageLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles animations for card movements and transitions in the game.
 */

public class Animation {

    private final ColorLogger log = new ColorLogger(Animation.class);

    private final ImageLoader imgLoad = new ImageLoader();
    private final JLabel label = new JLabel(imgLoad.loadImage("res/Cards/Rotate/back.png"));
    private final JLabel label2 = new JLabel(imgLoad.loadImage("res/Cards/Rotate/back.png"));

    /**
     * Constructs an Animation object.
     */

    public Animation(){
        label.setBounds(950, 430, 168, 89);
        label2.setBounds(950, 215, 168, 89);
    }

    /**
     * Initiates the animation for distributing a card to the player.
     *
     * @param card The JButton representing the card
     * @param img The ImageIcon of the card
     * @param x1 The final x-coordinate of the card
     */

    public void distribuisciAnimation(JButton card, ImageIcon img, int x1) {

        log.info("Start of the card dealing animation..");

        Timer timerDistribuisci = new Timer(5, new ActionListener() {
            private int y = 90;
            private int x = 158;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == x1 && y == 600) {
                    card.setIcon(img);
                    log.info("The card dealing animation is finished");
                    ((Timer) e.getSource()).stop();
                }


                if (y < 600) {
                    y = Math.min(y + 20, 600);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                    if (card.getLocation().x < x1) {
                        x = Math.min(x + 20, x1);
                        card.setBounds(x, y, 89, 168);
                        card.repaint();
                    }
                }

            }
        });

        timerDistribuisci.start();
        log.info("The card dealing animation has started");
    }

    /**
     * Initiates the animation for distributing a card to the CPU.
     *
     * @param card The JButton representing the card
     * @param x1 The final x-coordinate of the card
     */

    public void distribuisciAnimationBack(JButton card, int x1) {

        log.info("Start of the card dealing animation for the CPU..");

        Timer timerDistribuisciBack = new Timer(5, new ActionListener() {
            private int y = 90;
            private int x = 158;

            @Override
            public void actionPerformed(ActionEvent e) {


                if (card.getLocation().x < x1) {
                    x = Math.min(x + 20, x1);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

                if (y > 0) {
                    y = Math.min(y - 20, 0);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

                if (y == 0 && x == x1) {
                    log.info("The card dealing animation for the CPU is finished");
                    ((Timer) e.getSource()).stop();
                }

            }
        });

        timerDistribuisciBack.start();

        log.info("The card dealing animation has started for the CPU");

    }

    /**
     * Initiates the animation for taking cards from the table and placing them into the CPU's deck.
     *
     * @param card The JButton representing the CPU's card being taken
     * @param card2 The JButton representing the card taken from the table
     * @param img The ImageIcon of the card taken from the table
     * @param panel The JPanel containing the cards and decks
     */

    public void presaAnimationBack(JButton card, JButton card2, ImageIcon img, JPanel panel) {

        log.info("Start of the card taking animation for the CPU..");

        Timer timerPresaBack = new Timer(10, new ActionListener() {
            private int y1 = card.getLocation().y;
            private int x1 = card.getLocation().x;
            private int y2 = card2.getLocation().y;
            private int x2 = card2.getLocation().x;
            private int i = 0;
            private int j = 0;
            private int k = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x1 == 950 && y1 == 215) {
                    if (i == 0) {
                        i = 1;
                        card.setBounds(x2, y2, 168, 89);
                        card.setIcon(img);
                        card.repaint();
                    }

                    if (k == 0) {
                        k = 1;
                        label2.setBounds(950, 215, 168, 89);
                        panel.add(label2);
                        panel.setComponentZOrder(label2, 1);
                    }

                }

                if (y1 > 215) {
                    y1 = Math.min(y1 - 25, 215);
                    card.setBounds(x1, y1, 89, 168);
                    card.repaint();
                }
                if (x1 < 950) {
                    x1 = Math.min(x1 + 25, 950);
                    card.setBounds(x1, y1, 89, 168);
                    card.repaint();
                }

                if (x2 == 950 && y2 == 215) {
                    if (j == 0) {
                        j = 1;
                        card2.setBounds(x2, y2, 168, 89);
                        card2.setIcon(img);
                        card2.repaint();
                    }

                }
                if (y2 < 215) {
                    y2 = Math.min(y2 + 25, 215);
                    card2.setBounds(x2, y2, 89, 168);
                    card2.repaint();
                }
                if (x2 < 950) {
                    x2 = Math.min(x2 + 25, 950);
                    card2.setBounds(x2, y2, 89, 168);
                    card2.repaint();
                }


                if (x1 == 950 && y1 == 215 && x2 == 950 && y2 == 215 && j == 1 && i == 1) {
                    log.info("The card taking animation for the CPU is finished");
                    ((Timer) e.getSource()).stop();
                }

            }

        });

        timerPresaBack.start();

        log.info("The card taking animation for the CPU has started");

    }

    /**
     * Initiates the animation for taking cards from the player and placing them into the player's deck.
     *
     * @param card The JButton representing the player's card being taken
     * @param card2 The JButton representing the card taken from the table
     * @param img The ImageIcon of the card taken from the table
     * @param panel The JPanel containing the cards and decks
     */

    public void presaAnimation(JButton card, JButton card2, ImageIcon img, JPanel panel) {

        log.info("Start of the card taking animation..");

        Timer timerPresa = new Timer(10, new ActionListener() {
            private int y1 = card.getLocation().y;
            private int x1 = card.getLocation().x;
            private int y2 = card2.getLocation().y;
            private int x2 = card2.getLocation().x;
            private int l = 0;
            private int m = 0;
            private int n = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x1 == 950 && y1 == 430) {
                    if (l == 0) {
                        l = 1;
                        card.setBounds(x2, y2, 168, 89);
                        card.setIcon(img);
                        card.repaint();
                    }

                    if (n == 0) {
                        n = 1;
                        label.setBounds(950, 430, 168, 89);
                        panel.add(label);
                        panel.setComponentZOrder(label, 1);
                    }

                }

                if (y1 < 430) {
                    y1 = Math.min(y1 + 25, 430);
                    card.setBounds(x1, y1, 89, 168);
                    card.repaint();
                }
                if (x1 < 950) {
                    x1 = Math.min(x1 + 25, 950);
                    card.setBounds(x1, y1, 89, 168);
                    card.repaint();
                }

                if (x2 == 950 && y2 == 430) {
                    if (m == 0) {
                        m = 1;
                        card2.setBounds(x2, y2, 168, 89);
                        card2.setIcon(img);
                        card2.repaint();
                    }

                }
                if (y2 < 430) {
                    y2 = Math.min(y2 + 25, 430);
                    card2.setBounds(x2, y2, 89, 168);
                    card2.repaint();
                }
                if (x2 < 950) {
                    x2 = Math.min(x2 + 25, 950);
                    card2.setBounds(x2, y2, 89, 168);
                    card2.repaint();
                }


                if (x1 == 950 && y1 == 430 && x2 == 950 && y2 == 430 && m == 1 && n == 1) {
                    log.info("The card taking animation is finished");
                    ((Timer) e.getSource()).stop();
                }

            }
        });

        timerPresa.start();

        log.info("The card taking animation for the CPU has started");

    }

    /**
     * Initiates the animation for drawing a card from the deck and placing it into the player's hand.
     *
     * @param card The JButton representing the card drawn from the deck
     * @param carta The card object representing the drawn card
     * @param x1 The final x-coordinate of the card
     * @param g1 The player object to which the drawn card belongs
     */

    public void pescataAnimation(JButton card, Carta carta, int x1, Giocatore g1) {

        log.info("The card drawing animation is starting..");

        Timer timerPescata = new Timer(10, new ActionListener() {
            private int y = 90;
            private int x = 158;

            @Override
            public void actionPerformed(ActionEvent e) {

                if (y == 90 && x == 158) {
                    card.setIcon(imgLoad.loadImage("res/Cards/back.png"));
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

                if (x == x1 && y == 600) {
                    card.setIcon(carta.getImg());
                    g1.setLanciata(false);
                    log.info("The card drawing animation is over");
                    ((Timer) e.getSource()).stop();
                }

                if (y < 600) {
                    y = Math.min(y + 25, 600);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

                if (card.getLocation().x < x1) {
                    x = Math.min(x + 25, x1);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

            }
        });

        timerPescata.start();

        log.info("The card drawing animation has started");

    }

    /**
     * Initiates the animation for drawing a card from the deck and placing it into the CPU's hand.
     *
     * @param card The JButton representing the card drawn from the deck
     * @param carta The card object representing the drawn card
     * @param x1 The final x-coordinate of the card
     */

    public void pescataAnimationBack(JButton card, Carta carta, int x1) {

        log.info("The card drawing animation for the CPU is starting..");

        Timer timerPescataBack = new Timer(10, new ActionListener() {
            private int y = 90;
            private int x = 158;

            @Override
            public void actionPerformed(ActionEvent e) {

                if (y == 90 && x == 158) {
                    card.setIcon(imgLoad.loadImage("res/Cards/back.png"));
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }


                if (y > 0) {
                    y = Math.min(y - 25, 0);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

                if (card.getLocation().x < x1) {
                    x = Math.min(x + 25, x1);
                    card.setBounds(x, y, 89, 168);
                    card.repaint();
                }

                if (y == 0 && x == x1) {
                    log.info("The card drawing animation for the CPU is over");
                    ((Timer) e.getSource()).stop();
                }

            }
        });

        timerPescataBack.start();

        log.info("The card drawing animation for the CPU has started");

    }

    /**
     * Retrieves the JLabel representing the deck of cards facing downwards for the player.
     *
     * @return The JLabel representing the player's deck
     */

    public JLabel getLabel(){
        return  label;
    }

    /**
     * Retrieves the JLabel representing the deck of cards facing downwards for the CPU.
     *
     * @return The JLabel representing the CPU's deck
     */

    public JLabel getLabel2(){
        return label2;
    }

}