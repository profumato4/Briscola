/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadingScreen;

import SplashScreen.SplashScreen;
import  Main.Briscola;

import javax.swing.*;

public class Main extends javax.swing.JFrame {

    public static void main(String[] args) throws InterruptedException {
        java.awt.EventQueue.invokeLater(() -> {
            new SplashScreen(null, true).setVisible(true);
        });
        Thread.sleep(11500);
        java.awt.EventQueue.invokeLater(() -> {
            try {
                Briscola b = new Briscola();
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

    }

}
