package briscola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The StartMenu class represents the initial menu of the JBriscola game.
 * It provides options to start a new game, login, logout, register,
 * view the leaderboard, and control audio settings.
 * <p>
 * This class handles the initialization of the start menu interface,
 * including buttons for various functionalities like login, logout, register, etc.
 * It also manages audio playback for the game's theme song.
 *
 * @author profumato4
 */
public class StartMenu {

	private final ColorLogger log = new ColorLogger(StartMenu.class);

	private final FileManager fm = new FileManager("res/ThemeSong/play.txt");
	private boolean play = checkPlay();
	private Clip clip;
	private JButton game;
	private String carte;
	private CustomDialog card;
	private JButton audio;
	private final PodioPanel pp;
    private final Color color = Color.decode("#7fc7c2");
	private final ImageLoader imgLoad = new ImageLoader();

	/**
	 * Constructs a new StartMenu object.
	 * Initializes the start menu interface.
	 *
	 * @param frame the main JFrame of the application
	 * @param panel the main JPanel of the application
	 * @param login1 the instance of the Login class
	 * @param register the instance of the Register class
	 */

	public StartMenu(JFrame frame, JPanel panel, Login login1, Register register) {

		LogbackConfigurator.configure("logs/logback.xml");

		initialize(frame, panel, login1, register);
		pp = new PodioPanel(login1.getDb(), panel);
		pp.setVisible(false);
		frame.add(pp, BorderLayout.CENTER);
	}

	/**
	 * Initializes the start menu interface.
	 *
	 * @param frame the main JFrame of the application
	 * @param panel the main JPanel of the application
	 * @param login1 the instance of the Login class
	 * @param register1 the instance of the Register class
	 */

	private void initialize(JFrame frame, JPanel panel, Login login1, Register register1) {
		panel.removeAll();

        BackgroundPanel bp = new BackgroundPanel("res/Background/background4.png");
		panel.add(bp, BorderLayout.CENTER);

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
		this.audio = new JButton(imgLoad.loadImage("res/AudioSymbols/audio_on50.png"));
		this.audio.setBounds(550, 600, 50, 50);
		this.audio.setBorderPainted(false);
		this.audio.setContentAreaFilled(false);
		this.audio.setFocusPainted(false);

		this.audio.addActionListener(e -> checkPlayButton());

		bp.add(this.audio);


		JButton cards = getCardsButton(frame);

		bp.add(cards);

		JButton podio = new JButton(imgLoad.loadImage("res/leaderboard/podio.png"));
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
		CustomDialog.g(login, color);

		login.addActionListener(e -> {
			if (login1.isLogged()) {
				JOptionPane.showMessageDialog(frame, "Utente già loggato", "Login",
						JOptionPane.INFORMATION_MESSAGE);
				log.info("the user is already logged in");
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
		CustomDialog.g(register, color);

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
		CustomDialog.g(game, color);

		bp.add(game);
		bp.setComponentZOrder(game, 0);

		JButton logout = new JButton("Logout");
		logout.setFont(new Font("Tahoma", Font.BOLD, 20));
		logout.setBounds(420, 465, 340, 27);
		logout.setBorderPainted(true);
		CustomDialog.g(logout, color);

		logout.addActionListener(e -> {
			if (login1.isLogged()) {
				int conferma = JOptionPane.showConfirmDialog(frame, "Vuoi eseguire il logout?", "Conferma",
						JOptionPane.YES_NO_OPTION);
				if (conferma == JOptionPane.YES_OPTION) {

					login1.setLogged(false);

					log.info("You have logged out");

					login1.getFm().append(false);

					log.info(false + " was written to the file: " + login1.getFm().getPath());

				} else {
					login1.setLogged(true);
					log.info("You have not logged out");
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Non sei loggato, non puoi fare il logout", "Logout",
						JOptionPane.INFORMATION_MESSAGE);
				log.warn("You were not logged out because you are not logged in");
			}
		});

		bp.add(logout);
		bp.setComponentZOrder(logout, 0);

		playMusic("res/ThemeSong/FRENESIA.wav");
		panel.repaint();
		panel.revalidate();

	}

	private JButton getCardsButton(JFrame frame) {
		JButton cards = new JButton(imgLoad.loadImage("res/background/output.png"));
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
					log.info("Selected deck: " + carte);
				}
			});
			card.setVisible(true);
		});
		return cards;
	}

	/**
	 * Writes the current state of the audio playback (true or false) to a text file.
	 * This method appends the boolean value of the 'play' variable to the specified file.
	 */

	private void writePlay() {

		fm.append(play);
		log.audioWrite(play, fm.getPath());
	}

	/**
	 * Checks the current state of the audio playback from the text file.
	 * This method reads a boolean value from the specified file,
	 * indicating whether the audio playback is active (true) or paused (false).
	 * @return The boolean value indicating the current state of audio playback.
	 */

	private boolean checkPlay() {
		return fm.readBoolean();
	}

	/**
	 * Controls the audio playback based on the current state.
	 * If the audio is currently playing, it stops the playback, updates the state, and adjusts the UI accordingly.
	 * If the audio is currently paused, it starts the playback, updates the state, and adjusts the UI accordingly.
	 */

	private void checkPlayButton() {
		if (play) {
			play = false;
			writePlay();
			audioOff();
		} else {
			play = true;
			writePlay();
			audioOn();
		}
	}

	/**
	 * Controls the audio playback based on the current state, but without writing to the file.
	 * If the audio is currently paused, it stops the playback, updates the UI accordingly.
	 * If the audio is currently playing, it starts the playback, updates the UI accordingly.
	 */

	private void checkPlayButton2() {
		if (!play) {
            audioOff();
		} else {
            audioOn();
		}
	}

	private void audioOn() {
		clip.start();

		audio.setIcon(imgLoad.loadImage("res/AudioSymbols/audio_on50.png"));
		audio.repaint();
		log.audioInfo(play);

	}

	private void audioOff() {
		clip.stop();

		audio.setIcon(imgLoad.loadImage("res/AudioSymbols/audio_off50.png"));
		audio.repaint();

		log.audioInfo(play);
	}

	/**
	 * Calculates the center position of a JLabel relative to the specified JFrame.
	 * The label will be positioned at the horizontal center of the frame and at a fixed vertical position.
	 * @param frame The JFrame instance to which the label will be centered.
	 * @param label The JLabel instance to be centered.
	 * @return The centered JLabel.
	 */

	private JLabel calcolaCentro(JFrame frame, JLabel label) {
		Dimension size = frame.getSize();

		Dimension labelSize = label.getPreferredSize();

		int x = (size.width - labelSize.width) / 2;
		int y = 160;
		label.setBounds(x, y, labelSize.width, labelSize.height);

		return label;
	}

	/**
	 * Prepares and returns a Clip object for the specified audio file.
	 * This method reads the audio file, creates a BufferedInputStream and an AudioInputStream, and then opens a Clip.
	 * @param audioFile The path to the audio file.
	 * @return The prepared Clip object, or null if an error occurs.
	 */

	private Clip prepareClip(String audioFile) {

		try (AudioInputStream ais = AudioSystem
				.getAudioInputStream(new BufferedInputStream(Files.newInputStream(Paths.get(audioFile))))) {
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			return clip;
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
			log.error("Failed to prepare clip for audio file: " + audioFile);
			throw new RuntimeException("Failed to prepare clip for audio file: " + audioFile, e1);
		}
	}

	/**
	 * Plays the theme music specified by the given path in a separate thread.
	 * This method prepares the clip for the specified audio file,
	 * starts the playback in a loop, and controls the playback based on the current state.
	 * @param path The path to the theme music audio file.
	 */

	private void playMusic(String path) {
		Thread thread = new Thread(() -> {
			clip = prepareClip(path);
			if (clip != null) {
				clip.loop(-1);
				checkPlayButton2();
			}else{
				log.error("Failed to prepare clip for path: " + path);
			}
		});
		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			log.error("Thread interrupted while playing music from path: " + path);
			throw new RuntimeException("Thread interrupted while playing music from path: " + path, e);
		}
	}

	/**
	 * Retrieves the JButton instance associated with starting a new game.
	 * @return The JButton instance for starting a new game.
	 */

	public JButton game() {
		return game;
	}

	/**
	 * Retrieves the type of cards selected by the user from a custom dialog.
	 * This method opens a custom dialog to prompt the user to select a type of cards,
	 * reads the selected type, and returns it as a string.
	 * @return The type of cards selected by the user.
	 */

	public String getCarteType() {
		carte = new CustomDialog().readCardType();
		return carte;
	}
}
