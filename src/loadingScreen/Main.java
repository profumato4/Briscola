
package loadingScreen;

import main.Briscola;
import main.Database;
import splashScreen.SplashScreen;

import javax.swing.*;
import java.sql.SQLException;

import com.formdev.flatlaf.FlatLightLaf;

public class Main extends javax.swing.JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static  Database db;
    private static Briscola b;

    public static void main(String[] args) throws InterruptedException {
    	FlatLightLaf.setup();

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

        

        Thread.sleep(11500);
        Briscola.getFrame().setVisible(true);
        b.inizialize2(db);
        Briscola.getFrame().repaint();
        Briscola.getFrame().revalidate();

    }

}
