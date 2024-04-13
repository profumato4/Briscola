package Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Mazzo {

    private final MyArrayList<Carta> mazzo = new MyArrayList<>();
    private JLabel carta;
    private JPanel panel;
    private int indice = 1; // indice carte da pescare
    private ArrayList<JButton> backs = new ArrayList<>(); // carte avversario
    private String briscola;
    private CerchioLabel carteRimanenti;
    private Animation animation = new Animation();

    private AtomicInteger punteggio = new AtomicInteger(0);
    private AtomicInteger punteggio2 = new AtomicInteger(0);
    private CerchioLabel punti1 = new CerchioLabel();
    private CerchioLabel punti2 = new CerchioLabel();
    private boolean flags[] = new boolean[3];
    private int r = new Random().nextInt(2);
    private String cartaType;
    private Setup setup = new Setup();
    private JButton [] cardsButton = new JButton[3];
    private GameOverPanel g;
    private int turno = 0;
    private Database db;
    private Briscola b;
    private Timer timer;

    public Mazzo(JPanel panel, String cartaType, CerchioLabel carteRimanenti, Database db, Briscola b) {
        this.panel = panel;
        this.carteRimanenti = carteRimanenti;
        this.cartaType = cartaType;
        this.db = db;
        this.b = b;
        
        addCarte(cartaType);
        mescola();
        briscola(panel, cartaType);
        System.out.println(mazzo);
    }

    private void addCarte(String str) {

        setup.setup(str, mazzo);

    }

    public void mescola() {
        Collections.shuffle(this.mazzo);
    }

    public Carta briscola(JPanel panel, String cartaType) {
        Collections.swap(mazzo, 0, 39);
        carta = new JLabel(rotateCarta(this.mazzo.get(0), cartaType).getImg());
        carta.setBounds(105, 155, 200, 168);
        panel.add(carta);
        panel.setComponentZOrder(carta, 2);
        this.briscola = this.mazzo.get(0).getSeme();
        return this.mazzo.get(0);
    }

    public Carta rotateCarta(Carta carta, String cartaType) {

        return setup.rotateCarta(carta, cartaType);

    }

    private Carta rotateBriscola(Carta carta, String cartaType) {

        return setup.rotateBriscola(carta, cartaType);

    }

    public void distribuisci(Giocatore g1, Giocatore g2) {

        for (int i = 0; i < 3; i++) {
            g1.getMano().add(this.mazzo.get(this.indice++));
            g2.getMano().add(this.mazzo.get(this.indice++));
        }

        JButton card0 = new JButton(new ImageIcon("res/Cards/back.png"));
        JButton card1 = new JButton(new ImageIcon("res/Cards/back.png"));
        JButton card2 = new JButton(new ImageIcon("res/Cards/back.png"));

        JButton back0 = new JButton(new ImageIcon("res/Cards/back.png"));
        JButton back1 = new JButton(new ImageIcon("res/Cards/back.png"));
        JButton back2 = new JButton(new ImageIcon("res/Cards/back.png"));

        animation.distribuisciAnimation(card0, g1.getMano().get(0).getImg(), 418);
        animation.distribuisciAnimation(card1, g1.getMano().get(1).getImg(), 548);
        animation.distribuisciAnimation(card2, g1.getMano().get(2).getImg(), 678);

        animation.distribuisciAnimationBack(back0, 418);
        animation.distribuisciAnimationBack(back1, 548);
        animation.distribuisciAnimationBack(back2, 678);

        setUpButton(card0);
        setUpButton(card1);
        setUpButton(card2);

        setUpButton(back0);
        setUpButton(back1);
        setUpButton(back2);

        backs.add(back0);
        backs.add(back1);
        backs.add(back2);


        cardActionListner(card0, g1, g2, 0);
        cardActionListner(card1, g1, g2, 1);
        cardActionListner(card2, g1, g2, 2);
        
        cardsButton[0] = card0;
        cardsButton[1] = card1;
        cardsButton[2] = card2;
        
    }

    private void pescata(JButton card, Giocatore g1, int r, Giocatore g2, int n) {
        Timer timer = new Timer(1000, actionEvent -> {
            controllo(card, n, g1);
            controllo2(r, g2);
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void pescataBack(JButton card, Giocatore g1, int r, Giocatore g2, int n) {
        Timer timer = new Timer(1000, actionEvent -> {
            controllo2(r, g2);
            controllo(card, n, g1);
        });
        timer.setRepeats(false);
        timer.start();
        
    }

    private void controllo(JButton card, int n, Giocatore g1) {
        if (n == 0) {
            animation.pescataAnimation(card, distribuisci(g1, n), 418, g1);
        } else if (n == 1) {
            animation.pescataAnimation(card, distribuisci(g1, n), 548, g1);
        } else if (n == 2) {
            animation.pescataAnimation(card, distribuisci(g1, n), 678, g1);
        }
    }

    private void controllo2(int r, Giocatore g2) {
        if (r == 0) {
            animation.pescataAnimationBack(backs.get(r), distribuiscir(g2, r), 418);
        } else if (r == 1) {
            animation.pescataAnimationBack(backs.get(r), distribuiscir(g2, r), 548);
        } else if (r == 2) {
            animation.pescataAnimationBack(backs.get(r), distribuiscir(g2, r), 678);
        }
    }

    public Carta distribuisci(Giocatore g, int n) {

        pescaUltimaCarta(g, n);

        return g.getMano().get(n);
    }

    public Carta distribuiscir(Giocatore g, int r) {
        pescaUltimaCarta(g, r);
        return g.getMano().get(r);
    }

    private void pescaUltimaCarta(Giocatore g, int r) {
        System.out.println(indice);
        if (indice == 40) {
            g.getMano().set(r, rotateBriscola(this.mazzo.get(0), cartaType));
            this.indice++;
            carteRimanenti.setNumero(40 - (indice - 1));
            removeMazzo();
        } else if (indice <= 39) {
            g.getMano().set(r, this.mazzo.get(this.indice++));
            carteRimanenti.setNumero(40 - (indice - 1));
        }
    }

    private void setUpButton(JButton button) {
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        panel.add(button);
        panel.setComponentZOrder(button, 0);
    }

    private int selectCard(Giocatore g2) {
        return new Random().nextInt(g2.getMano().size());
    }


    public int getIndice() {
        return indice;
    }

    private void cardActionListner(JButton card, Giocatore g1, Giocatore g2, int n) {
        card.addActionListener(e -> {
        	if(!g1.isLanciata()) {
        		g1.lancia(card, g1, g1.getMano().get(n).getCarta());

                lancioBack(g2);

                azioniPartita(card, g1, g2, n);
        	}else {
        		System.out.println("Aspetta la fine dell'animazione");
        	}
            
        });

    }


	private void azioniPartita(JButton card, Giocatore g1, Giocatore g2, int n) {
		timer = new Timer(1500, actionEvent -> {
			System.out.println("Il valore di r: " + r);
			System.out.println("g1 size: " + g1.getMano().size());
			System.out.println("g2 size: " + g2.getMano().size());
			turno++;
			System.out.println(turno);

			if (!flags[0] && !flags[1] && !flags[2]) {
				if (g1.getMano().get(n).getCarta().comparaCarte(g1.getMano().get(n).getCarta(),
						g2.getMano().get(r).getCarta(), briscola)) {
					azioniGiocatore1(card, g1, g2, n);
				} else {
					azioniBack(card, g1, g2, n);
				}

			} else {
				if (g2.getMano().get(r).getCarta().comparaCarte(g2.getMano().get(r).getCarta(),
						g1.getMano().get(n).getCarta(), briscola)) {
					azioniBack(card, g1, g2, n);
				} else {
					azioniGiocatore1(card, g1, g2, n);
				}
				flags[0] = false;
				flags[1] = false;
				flags[2] = false;
			}

			if (turno == 20) {
				System.out.println("ok");
				if (punteggio.get() + punteggio2.get() == 120) {
					g = new GameOverPanel(b);
					if (punteggio.get() == punteggio2.get()) {
						g.tie();
						db.pareggio();
						System.out.println("pareggio");
					} else if (punteggio.get() < punteggio2.get()) {
						g.lose();
						db.sconfitta();
						System.out.println("perso");
					} else if (punteggio.get() > punteggio2.get()) {
						g.wins();
						db.vittoria();
						System.out.println("vinto");
					}
					panel.add(g, BorderLayout.CENTER);
					panel.setComponentZOrder(g, 0);
					panel.repaint();
					panel.revalidate();
					timer.stop();
				}
			}

		});

		timer.setRepeats(false);
		timer.start();

	}

    private void azioniGiocatore1(JButton card, Giocatore g1, Giocatore g2, int n) {
    	calcoloPunteggio(g1, g2, n, punteggio2, punteggio, punti1, punti2, true);
        animation.presaAnimation(card, backs.get(r), new ImageIcon("res/Cards/Rotate/back.png"), panel);
        if(indice <= 40){
            pescata(card, g1, r, g2, n);
        }
        if(indice > 40){
            removeCard(g2);
        }
    }

	private void azioniBack(JButton card, Giocatore g1, Giocatore g2, int n) {
		calcoloPunteggio(g1, g2, n, punteggio2, punteggio, punti1, punti2, false);
		animation.presaAnimationBack(card, backs.get(r), new ImageIcon("res/Cards/Rotate/back.png"), panel);
		if (indice <= 40) {
			pescataBack(card, g1, r, g2, n);
		}
		if (indice > 40) {
			removeCard(g2);
		}
		if(g2.getMano().size() > 0) {
			r = selectCard(g2);
			Timer t = new Timer(1500, actionEvent1 -> g2.lancia(backs.get(r), g2, g2.getMano().get(r).getCarta()));
			t.setRepeats(false);
			t.start();
		}
		
	}

    private void calcoloPunteggio(Giocatore g1, Giocatore g2, int n, AtomicInteger punteggio2, AtomicInteger punteggio, CerchioLabel punti1, CerchioLabel punti2, boolean b) {
        if (b) {
            punteggio.addAndGet(g1.getMano().get(n).getCarta().getValore());
            punteggio.addAndGet(g2.getMano().get(r).getCarta().getValore());
            g1.setPunteggio(punteggio.get());
            punti1.setSize(60, 60);
            punti1.calcolaCentro(punti1, animation.getLabel());
            punti1.setNumero(g1.getPunteggio());
            panel.add(punti1);
            panel.setComponentZOrder(punti1, 0);
            panel.repaint();
            punti1.repaint();
        } else {
            punteggio2.addAndGet(g2.getMano().get(r).getCarta().getValore());
            punteggio2.addAndGet(g1.getMano().get(n).getCarta().getValore());
            g2.setPunteggio(punteggio2.get());
            punti2.setSize(60, 60);
            punti2.calcolaCentro(punti2, animation.getLabel2());
            punti2.setNumero(g2.getPunteggio());
            panel.add(punti2);
            panel.setComponentZOrder(punti2, 0);
            panel.repaint();
            punti2.repaint();
        }
        
        
        
    }

    private void lancioBack(Giocatore g2) {
        int i = 0;
        int x = 0;

        // controllo se è stata gia lanciata una carta
        for (JButton card : backs) {
            if (card.getLocation().x == 598 && card.getLocation().y == 200) {
                flags[i] = true;
            }
            i++;
        }

        // se è stata gia lanciata una carta la x viene impostata su 1 cosi da non lanciarne altre
        for (boolean flag : flags) {
            if (flag) {
                x = 1;
                break;
            }
        }

        if (x == 0) {
            r = selectCard(g2);
            System.out.println(r);
            g2.lancia(backs.get(r), g2, g2.getMano().get(r).getCarta());
        }

    }

    private void removeMazzo(){
        Component component = panel.getComponentAt(80, 155);
        Component component2 = panel.getComponentAt(119, 209);
        removeComponent(component);
        removeComponent(component2);
        removeComponent(carta);
    }

    private void removeComponent(Component component){
        if (component instanceof JLabel) {
            System.out.println("Component found: JLabel");
            panel.remove(component);
            panel.revalidate();
            panel.repaint();
        }
    }

    private void removeCard(Giocatore g2){
        System.out.println(g2.getMano());
        g2.getMano().remove(r);
        backs.remove(r);
    }

    public JButton[] getCardButtons() {
    	return cardsButton;
    }
    
}