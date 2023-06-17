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
        File file = new File(pathToImg); //neue datei wird erstellt
        if (file.exists()) { //abgefragt ob die datei existiert
            try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                image = ImageIO.read(inputStream); 
            }
        }
        return image; //bild wird zurückgegeben
    }
}