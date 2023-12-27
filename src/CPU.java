import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.Timer;

public class CPU extends Giocatore{

	public CPU() {
		super("CPU");
	}
	
	@Override
	public void lancia(JButton button, Giocatore giocatore) {
		
		int r = new Random().nextInt(0, 2);
		
		button.setIcon(giocatore.getMano().get(r).getImg());
		button.repaint();
		
		Timer timer = new Timer(10, new ActionListener() {
			private int y = button.getLocation().y;
			private int x = button.getLocation().x;
			@Override
			public void actionPerformed(ActionEvent e) {
				if (y < 200) {
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
					System.out.println(button.getLocation().x);
				}
			}
		});

		timer.start();
		giocatore.getMano().remove(r);
	}
	
}
