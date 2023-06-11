package main;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageHandler {

    public static BufferedImage readImage(String pathToImg) throws IOException {
        BufferedImage image = null;
        File file = new File(pathToImg);
        if (file.exists()) {
            try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                image = ImageIO.read(inputStream);
            }
        }
        return image;
    }
}