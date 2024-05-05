package Main;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class Briscola {

	private static JFrame frame;
	private JPanel panel;
	private Login login;
	private Register register;
	private String carte;
	private CerchioLabel carteRimanenti;
	private byte temp = 0;
	private MenuPanel menu;
	private Mazzo mazzo1;
	private JButton[] cardButtons = new JButton[3];
	private Briscola b = this;
	private BackgroundPanel bp;
	private Database db;
	

	public Briscola() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(1178, 861);
		centerFrame(frame);
		frame.setVisible(false);
		frame.setResizable(false);
		frame.setIconImage(new ImageIcon("res/logo.png").getImage());
		frame.setTitle("JBriscola");
		panel = new JPanel();
		panel.setSize(1178, 861);
		panel.setLayout(null);
	}

	public void inizialize2(Database db) {
		if (frame.isVisible()) {
			
			this.db = db;
			login = new Login(this, db);
			register = new Register(login, login.getDb());
			
			//panel.setBounds(0, 0, 1040, 667);
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			StartMenu m = new StartMenu(frame, panel, login, register);
			m.game().addActionListener(e -> {
				if (login.isLogged()) {
					carte = m.getCarteType();
					System.out.println(carte);
					game();
				} else {
					JOptionPane.showMessageDialog(frame, "Utente non loggato", "Login",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
		} else {

		}
	}

	public static JFrame getFrame() {
		return frame;
	}

	private void setBackground() {

		panel.removeAll();
		
		bp = new BackgroundPanel("res/Background/background9.jpg");
		
		panel.add(bp, BorderLayout.CENTER);

		JLabel mazzo = new JLabel(new ImageIcon("res/Cards/back.png"));
		mazzo.setBounds(80, 155, 139, 168);
		

		carteRimanenti = new CerchioLabel();
		carteRimanenti.setSize(60, 60);
		carteRimanenti.calcolaCentro(carteRimanenti, mazzo);

		bp.add(carteRimanenti);
		bp.add(mazzo);

		bp.setComponentZOrder(mazzo, 1);
		bp.setComponentZOrder(carteRimanenti, 0);

		System.out.println(carteRimanenti.getX() + System.lineSeparator() + carteRimanenti.getY());

		panel.repaint();
		bp.repaint();
		panel.revalidate();
		bp.revalidate();

	}

	public void game() {
		temp = 0;
		setBackground();
		mazzo1 = new Mazzo(bp, carte, carteRimanenti, login.getDb(), b);
		Giocatore giocatore = new Giocatore(login.getUserName());
		System.out.println(giocatore.getNickName());
		Giocatore giocatore2 = new CPU();
		mazzo1.distribuisci(giocatore, giocatore2);
		System.out.println(giocatore.getMano());
		System.out.println(giocatore2.getMano());
		carteRimanenti.setNumero(40 - (mazzo1.getIndice() - 1));
		cardButtons = mazzo1.getCardButtons();
		InputMap inputMap = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = panel.getActionMap();

		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "esc");

		actionMap.put("esc", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (temp == 0) {
					menu = new MenuPanel(cardButtons, new ResumeButtonListener() {

						@Override
						public void onResumeClicked(byte value) {
							temp = (byte) value;
						}

					}, b);
					panel.add(menu, BorderLayout.CENTER);
					panel.setComponentZOrder(menu, 0);
					for (JButton card : cardButtons) {
						card.setEnabled(false);
					}
					panel.repaint();
					temp = 1;
				} else {
					for (JButton card : cardButtons) {
						card.setEnabled(true);
					}
					menu.setVisible(false);
					temp = 0;
				}
			}
		});
	}

	public JPanel getPanel() {
		return panel;
	}
	
	private void centerFrame(JFrame f) {
		Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = f.getSize ();

		f.setLocation ((screenSize.width - frameSize.width) / 2,
		(screenSize.height - frameSize.height) / 2);
	}
	
	public Database getDb() {
		return db;
	}
	
}
