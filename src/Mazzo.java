import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Mazzo {

	private final MyArrayList<Carta> mazzo = new MyArrayList<Carta>();
	private JLabel carta;
	private JPanel panel;
	private int indice = 1; // indice carte da pescare
	private ArrayList<JButton> backs = new ArrayList<JButton>(); // carte avversario

	public Mazzo(JPanel panel) {
		this.panel = panel;
		addCarte();
		mescola();
		briscola(panel);
		System.out.println(mazzo);
	}

	private void addCarte() {
		// spade
		mazzo.add(new Carta("Spade", "Asso", 11, new ImageIcon("res/Cards/31.png")));
		mazzo.add(new Carta("Spade", "2", 0, new ImageIcon("res/Cards/32.png")));
		mazzo.add(new Carta("Spade", "3", 10, new ImageIcon("res/Cards/33.png")));
		mazzo.add(new Carta("Spade", "4", 0, new ImageIcon("res/Cards/34.png")));
		mazzo.add(new Carta("Spade", "5", 0, new ImageIcon("res/Cards/35.png")));
		mazzo.add(new Carta("Spade", "6", 0, new ImageIcon("res/Cards/36.png")));
		mazzo.add(new Carta("Spade", "7", 0, new ImageIcon("res/Cards/37.png")));
		mazzo.add(new Carta("Spade", "Fante", 2, new ImageIcon("res/Cards/38.png")));
		mazzo.add(new Carta("Spade", "Cavallo", 3, new ImageIcon("res/Cards/39.png")));
		mazzo.add(new Carta("Spade", "Re", 4, new ImageIcon("res/Cards/40.png")));
		// coppe
		mazzo.add(new Carta("Coppe", "Asso", 11, new ImageIcon("res/Cards/21.png")));
		mazzo.add(new Carta("Coppe", "2", 0, new ImageIcon("res/Cards/22.png")));
		mazzo.add(new Carta("Coppe", "3", 10, new ImageIcon("res/Cards/23.png")));
		mazzo.add(new Carta("Coppe", "4", 0, new ImageIcon("res/Cards/24.png")));
		mazzo.add(new Carta("Coppe", "5", 0, new ImageIcon("res/Cards/25.png")));
		mazzo.add(new Carta("Coppe", "6", 0, new ImageIcon("res/Cards/26.png")));
		mazzo.add(new Carta("Coppe", "7", 0, new ImageIcon("res/Cards/27.png")));
		mazzo.add(new Carta("Coppe", "Fante", 2, new ImageIcon("res/Cards/28.png")));
		mazzo.add(new Carta("Coppe", "Cavallo", 3, new ImageIcon("res/Cards/29.png")));
		mazzo.add(new Carta("Coppe", "Re", 4, new ImageIcon("res/Cards/30.png")));
		// denara
		mazzo.add(new Carta("Denara", "Asso", 11, new ImageIcon("res/Cards/11.png")));
		mazzo.add(new Carta("Denara", "2", 0, new ImageIcon("res/Cards/12.png")));
		mazzo.add(new Carta("Denara", "3", 10, new ImageIcon("res/Cards/13.png")));
		mazzo.add(new Carta("Denara", "4", 0, new ImageIcon("res/Cards/14.png")));
		mazzo.add(new Carta("Denara", "5", 0, new ImageIcon("res/Cards/15.png")));
		mazzo.add(new Carta("Denara", "6", 0, new ImageIcon("res/Cards/16.png")));
		mazzo.add(new Carta("Denara", "7", 0, new ImageIcon("res/Cards/17.png")));
		mazzo.add(new Carta("Denara", "Fante", 2, new ImageIcon("res/Cards/18.png")));
		mazzo.add(new Carta("Denara", "Cavallo", 3, new ImageIcon("res/Cards/19.png")));
		mazzo.add(new Carta("Denara", "Re", 4, new ImageIcon("res/Cards/20.png")));
		// bastoni
		mazzo.add(new Carta("Bastoni", "Asso", 11, new ImageIcon("res/Cards/1.png")));
		mazzo.add(new Carta("Bastoni", "2", 0, new ImageIcon("res/Cards/2.png")));
		mazzo.add(new Carta("Bastoni", "3", 10, new ImageIcon("res/Cards/3.png")));
		mazzo.add(new Carta("Bastoni", "4", 0, new ImageIcon("res/Cards/4.png")));
		mazzo.add(new Carta("Bastoni", "5", 0, new ImageIcon("res/Cards/5.png")));
		mazzo.add(new Carta("Bastoni", "6", 0, new ImageIcon("res/Cards/6.png")));
		mazzo.add(new Carta("Bastoni", "7", 0, new ImageIcon("res/Cards/7.png")));
		mazzo.add(new Carta("Bastoni", "Fante", 2, new ImageIcon("res/Cards/8.png")));
		mazzo.add(new Carta("Bastoni", "Cavallo", 3, new ImageIcon("res/Cards/9.png")));
		mazzo.add(new Carta("Bastoni", "Re", 4, new ImageIcon("res/Cards/10.png")));
	}

	public void mescola() {
		Collections.shuffle(this.mazzo);
	}

	public Carta briscola(JPanel panel) {
		Collections.swap(mazzo, 0, 39);
		carta = new JLabel(rotateCarta(this.mazzo.get(0)).getImg());
		carta.setBounds(105, 155, 200, 168);
		panel.add(carta);
		panel.setComponentZOrder(carta, 1);
		return this.mazzo.get(0);
	}

	public Carta rotateCarta(Carta carta) {

		// spade

		if (carta.getNome().equals("Asso") && carta.getSeme().equals("Spade")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/31.png"));
		} else if (carta.getNome().equals("2") && carta.getSeme().equals("Spade")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/32.png"));
		} else if (carta.getNome().equals("3") && carta.getSeme().equals("Spade")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/33.png"));
		} else if (carta.getNome().equals("4") && carta.getSeme().equals("Spade")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/34.png"));
		} else if (carta.getNome().equals("5") && carta.getSeme().equals("Spade")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/35.png"));
		} else if (carta.getNome().equals("6") && carta.getSeme().equals("Spade")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/36.png"));
		} else if (carta.getNome().equals("7") && carta.getSeme().equals("Spade")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/37.png"));
		} else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Spade")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/38.png"));
		} else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Spade")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/39.png"));
		} else if (carta.getNome().equals("Re") && carta.getSeme().equals("Spade")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/40.png"));
		}

		// coppe

		else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Coppe")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/21.png"));
		} else if (carta.getNome().equals("2") && carta.getSeme().equals("Coppe")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/22.png"));
		} else if (carta.getNome().equals("3") && carta.getSeme().equals("Coppe")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/23.png"));
		} else if (carta.getNome().equals("4") && carta.getSeme().equals("Coppe")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/24.png"));
		} else if (carta.getNome().equals("5") && carta.getSeme().equals("Coppe")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/25.png"));
		} else if (carta.getNome().equals("6") && carta.getSeme().equals("Coppe")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/26.png"));
		} else if (carta.getNome().equals("7") && carta.getSeme().equals("Coppe")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/27.png"));
		} else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Coppe")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/28.png"));
		} else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Coppe")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/29.png"));
		} else if (carta.getNome().equals("Re") && carta.getSeme().equals("Coppe")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/30.png"));
		}

		// denara

		else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Denara")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/11.png"));
		} else if (carta.getNome().equals("2") && carta.getSeme().equals("Denara")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/12.png"));
		} else if (carta.getNome().equals("3") && carta.getSeme().equals("Denara")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/13.png"));
		} else if (carta.getNome().equals("4") && carta.getSeme().equals("Denara")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/14.png"));
		} else if (carta.getNome().equals("5") && carta.getSeme().equals("Denara")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/15.png"));
		} else if (carta.getNome().equals("6") && carta.getSeme().equals("Denara")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/16.png"));
		} else if (carta.getNome().equals("7") && carta.getSeme().equals("Denara")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/17.png"));
		} else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Denara")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/18.png"));
		} else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Denara")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/19.png"));
		} else if (carta.getNome().equals("Re") && carta.getSeme().equals("Denara")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/20.png"));
		}

		// bastoni

		else if (carta.getNome().equals("Asso") && carta.getSeme().equals("Bastoni")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/1.png"));
		} else if (carta.getNome().equals("2") && carta.getSeme().equals("Bastoni")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/2.png"));
		} else if (carta.getNome().equals("3") && carta.getSeme().equals("Bastoni")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/3.png"));
		} else if (carta.getNome().equals("4") && carta.getSeme().equals("Bastoni")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/4.png"));
		} else if (carta.getNome().equals("5") && carta.getSeme().equals("Bastoni")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/5.png"));
		} else if (carta.getNome().equals("6") && carta.getSeme().equals("Bastoni")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/6.png"));
		} else if (carta.getNome().equals("7") && carta.getSeme().equals("Bastoni")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/7.png"));
		} else if (carta.getNome().equals("Fante") && carta.getSeme().equals("Bastoni")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/8.png"));
		} else if (carta.getNome().equals("Cavallo") && carta.getSeme().equals("Bastoni")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/9.png"));
		} else if (carta.getNome().equals("Re") && carta.getSeme().equals("Bastoni")) {
			carta.setImg(new ImageIcon("res/Cards/Rotate/10.png"));
		}

		return carta;
	}

	public void distribuisci(Giocatore g1, Giocatore g2) {
		int x = 418;
		int y = 600;
		int x2 = 418;
		int y2 = 0;
		
		for(int i = 0;i < 3; i++) {
			g1.getMano().add(this.mazzo.get(this.indice++));
			g2.getMano().add(this.mazzo.get(this.indice++));
		}
		
		JButton card0 = new JButton(new ImageIcon("res/Cards/back.png"));
		JButton card1 = new JButton(new ImageIcon("res/Cards/back.png"));
		JButton card2 = new JButton(new ImageIcon("res/Cards/back.png"));
		
		JButton back0 = new JButton(new ImageIcon("res/Cards/back.png"));
		JButton back1 = new JButton(new ImageIcon("res/Cards/back.png"));
		JButton back2 = new JButton(new ImageIcon("res/Cards/back.png"));
		
		distribuisciAnimation(card0, g1.getMano().get(0).getImg(), 418);
		distribuisciAnimation(card1, g1.getMano().get(1).getImg(), 548);
		distribuisciAnimation(card2, g1.getMano().get(2).getImg(), 678);
		
		distribuisciAnimationBack(back0, 418);
		distribuisciAnimationBack(back1, 548);
		distribuisciAnimationBack(back2, 678);
		
		setUpButton(card0);
		setUpButton(card1);
		setUpButton(card2);
		
		setUpButton(back0);
		setUpButton(back1);
		setUpButton(back2);
		
		backs.add(back0);
		backs.add(back1);
		backs.add(back2);
		
		card0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				g1.lancia(card0, g1);
				g2.lancia(selectCard(backs), g2);
			}

		});
		
		card1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				g1.lancia(card1, g1);
				g2.lancia(selectCard(backs), g2);
			}

		});
		
		card2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				g1.lancia(card2, g1);
				g2.lancia(selectCard(backs), g2);
			}

		});
		
	/*	for (int i = 0; i < 3; i++) {
			g1.getMano().add(this.mazzo.get(this.indice++));
			g2.getMano().add(this.mazzo.get(this.indice++));
			JButton button = new JButton(g1.getMano().get(i).getImg());
			JButton button2 = new JButton(new ImageIcon("res/Cards/back.png"));
			button.setBounds(x, y, 89, 168);
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusPainted(false);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					g1.lancia(button, g1);
					g2.lancia(button2, g2);
				}

			});
			x += 130;
			button2.setBorderPainted(false);
			button2.setContentAreaFilled(false);
			button2.setFocusPainted(false);
			button2.setBounds(x2, y2, 89, 168);	
			x2 += 130;
			panel.add(button);
			panel.add(button2);
			panel.setComponentZOrder(button, 0);
			panel.setComponentZOrder(button2, 0);
		}
	*/
	}

	public void distribuisci(Giocatore g) {
		if (this.indice < this.mazzo.size()) {
			g.getMano().add(this.mazzo.get(this.indice++));
		}
	}
	
	private void setUpButton(JButton button) {
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		panel.add(button);
		panel.setComponentZOrder(button, 0);
	}
	
	private JButton selectCard(ArrayList<JButton> backs) {
		Collections.shuffle(backs);
		return backs.get(0);
	}
	
	private void distribuisciAnimation(JButton card, ImageIcon img, int x1) {
		Timer timer = new Timer(5, new ActionListener() {
			private int y = 90;
			private int x = 158;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(x == x1 && y == 600) {
					card.setIcon(img);
				}
				if (y < 600) {
					y = Math.min(y + 20, 600);
					card.setBounds(x, y, 89, 168);
					card.repaint();
					if(card.getLocation().x < x1) {
						x = Math.min(x + 20, x1);
						card.setBounds(x, y, 89, 168);
						card.repaint();
					}
				} else {
					((Timer) e.getSource()).stop();
				}
			}
		});

		timer.start();
		
	}
	
	
	private void distribuisciAnimationBack(JButton card, int x1) {
		Timer timer = new Timer(5, new ActionListener() {
			private int y = 90;
			private int x = 158;
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(card.getLocation().x < x1) {
					x = Math.min(x + 20, x1);
					card.setBounds(x, y, 89, 168);
					card.repaint();
				}
				
				if (y > 0) {
					y = Math.min(y - 20, 0);
					card.setBounds(x, y, 89, 168);
					card.repaint();
				}
				
				if(y == 0 && x == x1) {
					((Timer) e.getSource()).stop();
				}
				
			}
		});

		timer.start();
		
	}
	
}
