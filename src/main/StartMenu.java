package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;

public class StartMenu {

	private boolean play = checkPlay();
	private Clip clip;
	private JButton game;
	private String carte;
	private CustomDialog card;
	private JButton audio;
	private PodioPanel pp;
	private BackgroundPanel bp;
	private Color color = Color.decode("#7fc7c2");

	public StartMenu(JFrame frame, JPanel panel, Login login1, Register register) {
		initialize(frame, panel, login1, register);
		pp = new PodioPanel(login1.getDb(), panel);
		pp.setVisible(false);
		frame.add(pp, BorderLayout.CENTER);
	}

	private void initialize(JFrame frame, JPanel panel, Login login1, Register register1) {
		panel.removeAll();
		
		bp = new BackgroundPanel("res/Background/background4.png");
		panel.add(bp, BorderLayout.CENTER);
		System.out.println(play);

		frame.setBounds(100, 100, 1178, 861);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//panel.setBounds(0, 0, 1162, 822);
		frame.getContentPane().add(panel);
		panel.setSize(1178, 861);
		panel.setLayout(null);

	/*	JLabel copyright = new JLabel("Copyright (c) 2024 Leonardo Belli");
		copyright.setFont(new Font("Serif", Font.PLAIN, 14));
		copyright.setBounds(960, 793, 428, 30);
		copyright.setForeground(new Color(51, 51, 51));
		panel.add(copyright);
*/
		this.audio = new JButton(new ImageIcon("res/AudioSymbols/audio_on50.png"));
		this.audio.setBounds(550, 600, 50, 50);
		this.audio.setBorderPainted(false);
		this.audio.setContentAreaFilled(false);
		this.audio.setFocusPainted(false);

		this.audio.addActionListener(e -> {
			checkPlayButton();

		});

		bp.add(this.audio);


		JButton cards = new JButton(new ImageIcon("res/background/output.png"));
		cards.setBounds(640, 585, 90, 80);
		cards.setBorderPainted(false);
		cards.setContentAreaFilled(false);
		cards.setFocusPainted(false);

		cards.addActionListener(e -> {

			card = new CustomDialog(frame);
			card.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					carte = card.getCarteType();
					System.out.println("Valore di carte dopo il dialogo: " + carte);
					System.out.println(getCarteType());
				}
			});
			card.setVisible(true);
		});

		bp.add(cards);

		JButton podio = new JButton(new ImageIcon("res/PODIO-ITALIA.png"));
		podio.setBounds(400, 570, 120, 93);
		podio.setBorderPainted(false);
		podio.setContentAreaFilled(false);
		podio.setFocusPainted(false);

		podio.addActionListener(e -> {
			panel.setVisible(false);
			pp.setVisible(true);
		});

		bp.add(podio);

	/*	JLabel background = new JLabel();
		background.setIcon(new ImageIcon("res/Background/background4.png"));
		background.setBounds(0, 0, 1162, 822);
		panel.add(background, BorderLayout.CENTER);
*/
		JLabel jBriscola = new JLabel("JBriscola");
		jBriscola.setFont(new Font("Tahoma", Font.PLAIN, 90));
		jBriscola.setSize(200, 130);
		bp.add(calcolaCentro(frame, jBriscola));
		bp.setComponentZOrder(jBriscola, 0);

		JLabel label = new JLabel("(Clicca login se sei gia registrato)");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(420, 210, 342, 109);
		bp.add(label);
		bp.setComponentZOrder(label, 0);

		JButton login = new JButton("Login");
		login.setFont(new Font("Tahoma", Font.BOLD, 20));
		login.setBounds(420, 300, 340, 27);
		login.setBorderPainted(true);
		login.setFocusPainted(false);
		login.setBackground(Color.white);
		
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				login.setBackground(color);
				login.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				login.setBackground(Color.white);
				login.repaint();
			}

		});
		
		login.addActionListener(e -> {
			if (login1.isLogged()) {
				JOptionPane.showMessageDialog(frame, "Utente già loggato", "Login",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				login1.getFrame().setVisible(true);
				frame.setVisible(false);

			}
		});
		bp.add(login);
		bp.setComponentZOrder(login, 0);

		JButton register = new JButton("Register");
		register.setFont(new Font("Tahoma", Font.BOLD, 20));
		register.setBounds(420, 355, 340, 27);
		register.setBorderPainted(true);
		register.setFocusPainted(false);
		register.setBackground(Color.white);
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				register.setBackground(color);
				register.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				register.setBackground(Color.white);
				register.repaint();
			}

		});

		register.addActionListener(e -> {
			register1.getFrame().setVisible(true);
			frame.setVisible(false);
		});

		bp.add(register);
		bp.setComponentZOrder(register, 0);

		game = new JButton("Start New Game");
		game.setFont(new Font("Tahoma", Font.BOLD, 20));
		game.setBounds(420, 410, 340, 27);
		game.setBorderPainted(true);
		game.setFocusPainted(false);
		game.setBackground(Color.white);
		game.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				game.setBackground(color);
				game.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				game.setBackground(Color.white);
				game.repaint();
			}

		});

		bp.add(game);
		bp.setComponentZOrder(game, 0);

		JButton logout = new JButton("Logout");
		logout.setFont(new Font("Tahoma", Font.BOLD, 20));
		logout.setBounds(420, 465, 340, 27);
		logout.setBorderPainted(true);
		logout.setFocusPainted(false);
		logout.setBackground(Color.white);
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logout.setBackground(color);
				logout.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				logout.setBackground(Color.white);
				logout.repaint();
			}

		});

		logout.addActionListener(e -> {
			if (login1.isLogged()) {
				int conferma = JOptionPane.showConfirmDialog(frame, "Vuoi eseguire il logout?", "Conferma",
						JOptionPane.YES_NO_OPTION);
				if (conferma == JOptionPane.YES_OPTION) {
					login1.setLogged(false);
					
					FileWriter fw = null;
					try {
						fw = new FileWriter("res/Login/remember.txt", false);
						fw.append(String.valueOf(false));
						System.out.println("scritto");
					} catch (IOException e1) {
						e1.printStackTrace();
					}finally {
						try {
							fw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				} else {
					login1.setLogged(true);
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Non sei loggato, non puoi fare il logout", "Logout",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		bp.add(logout);
		bp.setComponentZOrder(logout, 0);

		musicTheme("res/ThemeSong/FRENESIA.wav");
		panel.repaint();
		panel.revalidate();

	}

	private void writePlay() {
		FileWriter file2;
		try {
			file2 = new FileWriter("res\\ThemeSong\\playOn.txt", false);
			file2.append(String.valueOf(play));
			file2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private boolean checkPlay() {
		try {
			FileReader fr = new FileReader("res\\ThemeSong\\playOn.txt");
			try (BufferedReader reader = new BufferedReader(fr)) {
				String str;
				while ((str = reader.readLine()) != null) {
					return Boolean.valueOf(str);
				}

				reader.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void checkPlayButton() {
		if (play) {
			play = false;
			writePlay();
			clip.stop();
			audio.setIcon(new ImageIcon("res/AudioSymbols/audio_off50.png"));
			audio.repaint();
			System.out.println(play);
		} else {
			play = true;
			writePlay();
			clip.start();
			audio.setIcon(new ImageIcon("res/AudioSymbols/audio_on50.png"));
			audio.repaint();
			System.out.println(play);
		}
	}

	private void checkPlayButton2() {
		if (!play) {
			play = false;
			clip.stop();
			audio.setIcon(new ImageIcon("res/AudioSymbols/audio_off50.png"));
			audio.repaint();
		} else {
			play = true;
			clip.start();
			audio.setIcon(new ImageIcon("res/AudioSymbols/audio_on50.png"));
			audio.repaint();
		}
	}

	private JLabel calcolaCentro(JFrame frame, JLabel label) {
		Dimension size = frame.getSize();

		Dimension labelSize = label.getPreferredSize();

		int x = (size.width - labelSize.width) / 2;
		int y = 160;
		label.setBounds(x, y, labelSize.width, labelSize.height);

		System.out.println(x + " " + y + " " + labelSize.width + " " + labelSize.height);

		return label;
	}

	private Clip prepareClip(String audioFile) {

		try (AudioInputStream ais = AudioSystem
				.getAudioInputStream(new BufferedInputStream(new FileInputStream(audioFile)))) {
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			return clip;
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	private void musicTheme(String path) {
		Thread thread = new Thread(() -> {
			clip = prepareClip(path);
			if (clip != null) {
				clip.loop(-1);
				checkPlayButton2();
			}
		});
		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public JButton game() {
		return game;
	}

	public String getCarteType() {
		carte = new CustomDialog().readCardType();
		return carte;
	}
}
