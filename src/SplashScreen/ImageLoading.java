package SplashScreen;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoading {

    public void ImageLoading(JLabel jLabel1) {
        new Thread(() -> {
            try {
                BufferedImage fullImage = ImageIO.read(new File("res/logo.png"));
                int width = fullImage.getWidth();
                int height = fullImage.getHeight();

                SwingUtilities.invokeLater(() -> jLabel1.setIcon(new ImageIcon(fullImage)));

                for (int i = 1; i <= 11; i++) {
                    int subWidth = width * i / 11;
                    BufferedImage subImage = fullImage.getSubimage(0, 0, subWidth, height);

                    SwingUtilities.invokeLater(() -> jLabel1.setIcon(new ImageIcon(subImage)));

                    Thread.sleep(1000);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
