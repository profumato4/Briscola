package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.Timer;

public class Giocatore {

	private final String nickName;
	private ArrayList<Carta> mano;
	private int punteggio;

	public Giocatore(String nickName) {
		this.nickName = nickName;
		this.mano = new ArrayList<Carta>();
		this.punteggio = 0;
	}

	public ArrayList<Carta> getMano() {
		return mano;
	}

	public String getNickName() {
		return nickName;
	}

	public void lancia(JButton button, Giocatore giocatore, Carta carta) {
		Timer timer = new Timer(10, new ActionListener() {
			private int y = button.getLocation().y;
			private int x = button.getLocation().x;
			

			@Override
			public void actionPerformed(ActionEvent e) {
				if (y > 300) {
					y -= 20;
					button.setBounds(x, y, 89, 168);
					button.repaint();
				}
				
				if(y == 300) {
					if (button.getLocation().x > 548) {
						x -= 10;
						button.setBounds(x, y, 89, 168);
						button.repaint();
					} else if (button.getLocation().x < 548) {
						x += 10;
						button.setBounds(x, y, 89, 168);
						button.repaint();
					} else if (button.getLocation().x == 548 && button.getLocation().y == 300) {

						((Timer) e.getSource()).stop();

					}
				}
				
			}
		});

		timer.start();
	}

	public void setPunteggio(int punteggio){
		this.punteggio = punteggio;
	}

	public int getPunteggio(){
		return  punteggio;
	}
}
