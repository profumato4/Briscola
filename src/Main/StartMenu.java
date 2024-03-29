package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.commons.io.FileUtils;

public class StartMenu {

	private AudioInputStream audioIn;
	private boolean play = true;
	private Clip clip;
	private FloatControl volumeControl;
	private JButton game;
	private String carte;
	private CustomDialog card;

	public StartMenu(JFrame frame, JPanel panel, Login login1, Register register) {
		initialize(frame, panel, login1, register);
	}

	private void initialize(JFrame frame, JPanel panel, Login login1, Register register1) {
		panel.removeAll();

		frame.setBounds(100, 100, 1178, 861);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel.setBounds(0, 0, 1162, 822);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton audio = new JButton(new ImageIcon("res/AudioSymbols/audio_on50.png"));
		audio.setBounds(550, 600, 50, 50);
		audio.setBorderPainted(false);
		audio.setContentAreaFilled(false);
		audio.setFocusPainted(false);

		audio.addActionListener(e -> {
            if (play) {
                play = false;
				volumeControl.setValue((float) -80.0);
				System.out.println(volumeControl.getValue());
                audio.setIcon(new ImageIcon("res/AudioSymbols/audio_off50.png"));
                audio.repaint();
            } else {
                play = true;
				volumeControl.setValue((float) 0.0);
				System.out.println(volumeControl.getValue());
				audio.setIcon(new ImageIcon("res/AudioSymbols/audio_on50.png"));
                audio.repaint();
            }

        });

		panel.add(audio);
		
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
				
		panel.add(cards);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("res/Background/background4.png"));
		background.setBounds(0, 0, 1162, 822);
		panel.add(background);

		JLabel jBriscola = new JLabel("JBriscola");
		jBriscola.setFont(new Font("Tahoma", Font.PLAIN, 90));
		panel.add(calcolaCentro(frame, jBriscola));
		panel.setComponentZOrder(jBriscola, 0);

		JLabel label = new JLabel("(Clicca login se sei gia registrato)");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(420, 210, 342, 109);
		panel.add(label);
		panel.setComponentZOrder(label, 0);

		JButton login = new JButton("Login");
		login.setFont(new Font("Tahoma", Font.BOLD, 20));
		login.setBounds(420, 300, 340, 27);
		login.setBorderPainted(false);
		login.setFocusPainted(false);
		login.setBackground(Color.GRAY);
		login.addActionListener(e -> {
            if (login1.isLogged()) {
                JOptionPane.showMessageDialog(frame, "Utente già loggato", "Login",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                login1.getFrame().setVisible(true);
                frame.setVisible(false);

            }
        });
		panel.add(login);

		JButton register = new JButton("Register");
		register.setFont(new Font("Tahoma", Font.BOLD, 20));
		register.setBounds(420, 355, 340, 27);
		register.setBorderPainted(false);
		register.setFocusPainted(false);
		register.setBackground(Color.GRAY);

		register.addActionListener(e -> {
            register1.getFrame().setVisible(true);
            frame.setVisible(false);
        });

		panel.add(register);
		panel.setComponentZOrder(register, 0);

		game = new JButton("Star New Game");
		game.setFont(new Font("Tahoma", Font.BOLD, 20));
		game.setBounds(420, 410, 340, 27);
		game.setBorderPainted(false);
		game.setFocusPainted(false);
		game.setBackground(Color.GRAY);

		panel.add(game);
		panel.setComponentZOrder(game, 0);

		JButton logout = new JButton("Logout");
		logout.setFont(new Font("Tahoma", Font.BOLD, 20));
		logout.setBounds(420, 465, 340, 27);
		logout.setBorderPainted(false);
		logout.setFocusPainted(false);
		logout.setBackground(Color.GRAY);

		logout.addActionListener(e -> {
            if (login1.isLogged()) {
                int conferma = JOptionPane.showConfirmDialog(frame, "Vuoi eseguire il logout?", "Conferma",
                        JOptionPane.YES_NO_OPTION);
                if (conferma == JOptionPane.YES_OPTION) {
                    login1.setLogged(false);

                    try {
                        File file = new File("res\\Login\\MacAddress.txt");
                        List<String> righe = FileUtils.readLines(file, "UTF-8");

                        List<String> righeDaMantenere = new ArrayList<String>();

                        for(String str: righe) {
                            if(!str.contains(login1.getMacAddress())) {
                                righeDaMantenere.add(str);
                            }
                        }

                        FileUtils.writeLines(file, "UTF-8", righeDaMantenere);



                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                } else {
                    login1.setLogged(true);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Non sei loggato, non puoi fare il logout", "Logout",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

		panel.add(logout);
		panel.setComponentZOrder(logout, 0);

		musicTheme("res/ThemeSong/FRENESIA.wav");

		panel.repaint();
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

	private void musicTheme(String path) {
		new Thread(() -> {
			try {
				while (true) {
					if (play) {
						audioIn = AudioSystem.getAudioInputStream(new File(path));
						clip = AudioSystem.getClip();
						clip.open(audioIn);

						volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

						volumeControl.setValue((float)0.0);

						clip.start();

						System.out.println("started");

						CountDownLatch latch = new CountDownLatch(1);
						clip.addLineListener(event -> {
							if (event.getType() == LineEvent.Type.STOP) {
								clip.setMicrosecondPosition(0);
								latch.countDown();
							}
						});

						try {
							latch.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						} finally {
							clip.close();
						}

					}

				}

			} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
				e1.printStackTrace();
			}
		}).start();

	}

	public JButton game() {
		return game;
	}
	
	public String getCarteType() {
		carte = new CustomDialog().readCardType();
		return carte;
	}
}
