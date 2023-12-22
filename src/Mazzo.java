import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mazzo {

	private final MyArrayList<Carta> mazzo = new MyArrayList<Carta>();
	private JLabel carta;
	private JPanel panel;
	private int indice = 1; // indice carte da pescare

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
		for (int i = 0; i < 3; i++) {
			g1.getMano().add(this.mazzo.get(this.indice++));
			g2.getMano().add(this.mazzo.get(this.indice++));
			JButton label = new JButton(g1.getMano().get(i).getImg());
			JLabel label2 = new JLabel(new ImageIcon("res/Cards/back.png"));
			label.setBounds(x, y, 89, 168);
			label.setBorderPainted(false);
			label.setContentAreaFilled(false);
			label.setFocusPainted(false);
			label.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					label.setBounds(548, 300, 89, 168);
					label.repaint();
				}
				
			});
			x += 130;
			label2.setBounds(x2, y2, 89, 168);
			x2 += 130;
			panel.add(label);
			panel.add(label2);
			panel.setComponentZOrder(label, 0);
			panel.setComponentZOrder(label2, 0);
		}
	}
	
	public void distribuisci(Giocatore g){
	    if(this.indice<this.mazzo.size()){
	    	if(g.getNickName().equals("CPU")) {
	    		g.getMano().add(this.mazzo.get(this.indice++));
	    		JLabel label2 = new JLabel(new ImageIcon("res/Cards/back.png"));
	    		label2.setBounds(418, 0, 89, 168);
	    		panel.add(label2);
	    	}
	    }
	  }
	
}
