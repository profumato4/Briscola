import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Briscola {

	private JFrame frame;
	private JLabel background;
	private JLabel mazzo;
	@SuppressWarnings("unused")
	private Mazzo mazzo1;
	private JPanel panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Briscola window = new Briscola();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Briscola() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1178, 861);
		panel = new JPanel();
		panel.setBounds(0, 0, 1040, 667);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		setBackground();
		mazzo1 = new Mazzo(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void setBackground() {

		background = new JLabel(new ImageIcon("C:/Users/Utente/Desktop/codici/java/Briscola/res/poker-table-background_77211-140.jpg"));
		background.setBounds(-419, 5, 2000, 1406);
			
		mazzo = new JLabel(new ImageIcon("C:/Users/Utente/Desktop/codici/java/Briscola/res/Cards/back.png"));
		mazzo.setBounds(80, 155, 139, 168);
		
		panel.add(background);
		panel.add(mazzo);
		panel.setComponentZOrder(mazzo, 0);
	}
	
}
