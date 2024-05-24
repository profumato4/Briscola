package splashScreen;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Utility class for loading and displaying images asynchronously.
 *
 * This class provides a method for loading an image from a file and displaying it on a JLabel.
 * The image loading process is performed asynchronously using a separate thread.
 *
 */

public class ImageLoading {

    /**
     * Loads an image from a file and displays it on the specified JLabel.
     *
     * The image loading process is performed asynchronously using a separate thread.
     *
     * @param jLabel1 The JLabel to display the loaded image.
     */

    public void loadImage(JLabel jLabel1) {
        new Thread(() -> {
            try {

                // Read the full image from file

                BufferedImage fullImage = ImageIO.read(new File("res/logo.png"));
                int width = fullImage.getWidth();
                int height = fullImage.getHeight();

                // Display the full image on the JLabel

                SwingUtilities.invokeLater(() -> jLabel1.setIcon(new ImageIcon(fullImage)));

                // Split the full image into 11 parts and display each part sequentially

                for (int i = 1; i <= 11; i++) {
                    int subWidth = width * i / 11;

                    // Get the sub-image

                    BufferedImage subImage = fullImage.getSubimage(0, 0, subWidth, height);

                    // Display the sub-image on the JLabel

                    SwingUtilities.invokeLater(() -> jLabel1.setIcon(new ImageIcon(subImage)));

                    // Pause for 1 second

                    Thread.sleep(1000);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
