package utils;

import log.ColorLogger;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    private final ColorLogger log = new ColorLogger(ImageLoader.class);


    public ImageIcon loadImage(@NotNull String path){
        try{
            ImageIcon img = new ImageIcon(path);
            if (img.getImageLoadStatus() != MediaTracker.COMPLETE || img.getImage() == null) {
                throw new IOException("Image file could not be loaded.");
            }
            return img;
        }catch (Exception e){
            log.error("Failed to load image from file: " + path);
            throw new RuntimeException("Failed to load image from file: " + path, e);
        }
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
            log.error("Failed to read image file: " + path);
            throw new RuntimeException("Failed to read image file: " + path, e);
        }
    }

}
