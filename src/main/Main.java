
package main;

import splashScreen.SplashScreen;

import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;

import briscola.Briscola;
import briscola.Database;

public class Main extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private static Database db;
    private static Briscola b;

    /**
     * The main entry point for the application.
     *
     * @param args The command-line arguments.
     */

    public static void main(String[] args) {

        // Set up the FlatLight Look and Feel for the UI.

        FlatLightLaf.setup();

        // Initialize the Briscola game instance and set up the UI.

        java.awt.EventQueue.invokeLater(() -> {
            try {
                b = new Briscola();
                UIManager.setLookAndFeel(new FlatLightLaf());

                // Initialize the database connection.
                db = new Database(Briscola.getFrame());

                try {
                    SwingUtilities.updateComponentTreeUI(Briscola.getFrame());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Show the splash screen.
                SplashScreen splashScreen = new SplashScreen(null, true);
                splashScreen.setAlwaysOnTop(true);
                splashScreen.setVisible(true);
                // Add a listener to detect when the splash screen is closed.
                splashScreen.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        // Show the main Briscola frame and initialize the game.
                        Briscola.getFrame().setVisible(true);
                        b.inizialize2(db);
                        Briscola.getFrame().repaint();
                        Briscola.getFrame().revalidate();
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }

}
