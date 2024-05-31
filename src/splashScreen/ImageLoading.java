package splashScreen;

import briscola.ColorLogger;
import briscola.ImageLoader;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Utility class for loading and displaying images asynchronously.
 *
 * This class provides a method for loading an image from a file and displaying it on a JLabel.
 * The image loading process is performed asynchronously using a separate thread.
 *
 */

public class ImageLoading {

    private final ColorLogger log = new ColorLogger(ImageLoading.class);
    private final ImageLoader imgLoad = new ImageLoader();


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

                BufferedImage fullImage;
                
                try{
                    fullImage = imgLoad.loadBufferedImage("res/logo/logo.png");
                }catch (Exception e){
                    log.error("Failed to load image from file: res/logo/logo.png");
                    throw new RuntimeException("Failed to load image from file: res/logo/logo.png",e);
                }
                
                int width = fullImage.getWidth();
                int height = fullImage.getHeight();

                // Display the full image on the JLabel

                BufferedImage finalFullImage = fullImage;
                SwingUtilities.invokeLater(() -> jLabel1.setIcon(new ImageIcon(finalFullImage)));

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
            } catch (InterruptedException e) {
                log.error("Error loading and displaying image ");
                throw new RuntimeException("Error loading and displaying image", e);
            }
        }).start();
    }

}
