
package LoadingScreen;

import SplashScreen.SplashScreen;
import  Main.Briscola;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import Main.Database;

public class Main extends javax.swing.JFrame {
    private static Database db;
    private static Briscola b;

    public static void main(String[] args) throws InterruptedException {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                b = new Briscola();
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                try {
                    SwingUtilities.updateComponentTreeUI(b.getFrame());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });
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

        try {
            db = new Database(b.getFrame());
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(null ,"Troppe connessioni", "Connection",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLSyntaxErrorException e){
            JOptionPane.showMessageDialog(null ,"Troppe connessioni", "Connection",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Thread.sleep(11500);
        b.getFrame().setVisible(true);
        b.inizialize2();
        b.getFrame().repaint();
        b.getFrame().revalidate();

    }

}
