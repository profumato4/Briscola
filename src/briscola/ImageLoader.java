package briscola;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    private static final Logger logger = LoggerFactory.getLogger(ImageLoader.class);

    public ImageLoader(){
        LogbackConfigurator.configure("res/logs/logback.xml");
    }

    public ImageIcon loadImage(@NotNull String path){
        try{
            ImageIcon img = new ImageIcon(path);
            if (img.getImageLoadStatus() != MediaTracker.COMPLETE || img.getImage() == null) {
                throw new IOException("Image file could not be loaded.");
            }
            return img;
        }catch (Exception e){
            logger.error("Failed to load image from file: " + path, e);
        }
        return  null;
    }

    public BufferedImage loadBufferedImage(@NotNull String path){
        BufferedImage image;
        try {
            image = ImageIO.read(new File(path));
            if (image == null) {
                throw new IOException("Image file could not be loaded.");
            }
            return image;
        } catch (IOException e) {
            logger.error("Failed to read image file: " + path, e);
        }
        return  null;
    }

}
