
package main;

import log.ColorLogger;
import splashScreen.SplashScreen;

import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;

import briscola.Briscola;
import briscola.Database;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The Main class serves as the entry point for the Briscola application.
 * It sets up the user interface, initializes the game and database connection,
 * and handles the display of the splash screen.
 */

public class Main extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private static Database db;
    private static Briscola b;
    private static final ColorLogger log = new ColorLogger(Briscola.class);

    /**
     * The main entry point for the application.
     *
     * @param args The command-line arguments.
     */

    public static void main(String[] args) {

        // Set up the FlatLight Look and Feel for the UI.

        FlatLightLaf.setup();

        // Run the application logic on the Event Dispatch Thread

        java.awt.EventQueue.invokeLater(Main::run);


    }

    /**
     * Initializes and sets up the Briscola game, database connection, and splash screen.
     * This method is invoked on the Event Dispatch Thread.
     */

    private static void run() {
        try {
            // Create the Briscola game instance
            b = new Briscola();
            UIManager.setLookAndFeel(new FlatLightLaf());

            // Initialize the database connection.
            db = new Database(Briscola.getFrame());

            // Update the component tree UI
            try {
                SwingUtilities.updateComponentTreeUI(Briscola.getFrame());
                log.info("Component tree UI updated.");
            } catch (Exception e) {
                log.error("Error updating component tree UI.");
                throw new RuntimeException("Error updating component tree UI.", e);
            }

            // Show the splash screen.
            SplashScreen splashScreen = new SplashScreen(null, true);
            splashScreen.setAlwaysOnTop(true);
            splashScreen.setVisible(true);

            log.info("Splash screen displayed.");

            // Add a listener to detect when the splash screen is closed.
            splashScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent windowEvent) {

                    // Show the main Briscola frame and initialize the game.
                    Briscola.getFrame().setVisible(true);
                    log.info("Splash screen closed. Main frame displayed.");

                    // Initialize the Briscola game with the database
                    b.inizialize2(db);
                    log.info("Briscola game initialized.");

                    // Repaint and revalidate the main frame
                    Briscola.getFrame().repaint();
                    Briscola.getFrame().revalidate();
                    log.info("Main frame repainted and revalidated.");

                }
            });

        } catch (Exception e) {
            log.error("An error occurred during initialization.");
            throw new RuntimeException("An error occurred during initialization.", e);
        }
    }
}
