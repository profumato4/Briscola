import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Briscola {

	private static JFrame frame;
	private JPanel panel;
	private static Briscola window = new Briscola();
	private Login login = new Login(window);
	private Register register = new Register(login);
	private String carte;
	private CerchioLabel carteRimanenti;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                window.frame.setVisible(true);
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                try {
                    SwingUtilities.updateComponentTreeUI(frame);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StartMenu m = new StartMenu(frame, panel, login, register);
		m.game().addActionListener(e -> {
            if (login.isLogged()) {
                carte = m.getCarteType();
                System.out.println(carte);
                game();
                System.out.println(frame.getSize());
            } else {
                JOptionPane.showMessageDialog(frame, "Utente non loggato", "Login",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

	}

	public static JFrame getFrame() {
		return frame;
	}

	private void setBackground() {

		panel.removeAll();

		JLabel background = new JLabel(new ImageIcon("res/Background/background7.jpg"));
		background.setBounds(0, 0, 1162, 822);

		JLabel mazzo = new JLabel(new ImageIcon("res/Cards/back.png"));
		mazzo.setBounds(80, 155, 139, 168);
		
		carteRimanenti = new CerchioLabel();
		carteRimanenti.setSize(60,60);
		carteRimanenti.calcolaCentro(carteRimanenti, mazzo);
		
		panel.add(carteRimanenti);
		panel.add(background);
		panel.add(mazzo);
		
		panel.setComponentZOrder(mazzo, 1);
		panel.setComponentZOrder(carteRimanenti, 0);
		
		panel.repaint();

	}

	public void game() {
		setBackground();
		Mazzo mazzo1 = new Mazzo(panel, carte, carteRimanenti);
		Giocatore giocatore = new Giocatore(login.getUserName());
		System.out.println(giocatore.getNickName());
		Giocatore giocatore2 = new CPU();
		mazzo1.distribuisci(giocatore, giocatore2);
		System.out.println(giocatore.getMano());
		System.out.println(giocatore2.getMano());
		carteRimanenti.setNumero(40 - (mazzo1.getIndice()-1));
	}
	
	
}
