
package main;

import splashScreen.SplashScreen;

import javax.swing.*;
import java.sql.SQLException;

import com.formdev.flatlaf.FlatLightLaf;

import briscola.Briscola;
import briscola.Database;

public class Main extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private static  Database db;
    private static Briscola b;

    /**
     * The main entry point for the application.
     *
     * @param args The command-line arguments.
     * @throws InterruptedException If the sleep operation is interrupted.
     */

    public static void main(String[] args) throws InterruptedException {

        // Set up the FlatLight Look and Feel for the UI.

    	FlatLightLaf.setup();

        // Initialize the Briscola game instance and set up the UI.

    	java.awt.EventQueue.invokeLater(() -> {
            try {
                b = new Briscola();
                UIManager.setLookAndFeel(new FlatLightLaf());
                try {
                    SwingUtilities.updateComponentTreeUI(Briscola.getFrame());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        // Initialize the database connection.

    	try {
            db = new Database(Briscola.getFrame());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Show the splash screen.

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new SplashScreen(null, true).setVisible(true);
            } catch (UnsupportedLookAndFeelException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });


        // Wait for the splash screen to finish.

        Thread.sleep(11500);

        // Show the main Briscola frame and initialize the game.

        Briscola.getFrame().setVisible(true);
        b.inizialize2(db);
        Briscola.getFrame().repaint();
        Briscola.getFrame().revalidate();

    }

}
