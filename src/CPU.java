import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;

public class CPU extends Giocatore{

	public CPU() {
		super("CPU");
	}
	
	@Override
	public void lancia(JButton button, Giocatore giocatore, Carta carta) {
		
		button.setIcon(carta.getImg());
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
				}

				if(y == 200 && x == 598){
					((Timer) e.getSource()).stop();
				}

			}
		});

		timer.start();
	}
	
}
