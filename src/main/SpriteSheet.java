package main;
import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage img;

    public SpriteSheet(BufferedImage img) {
      this.img = img;
}
public BufferedImage grabImage(int x, int y, int width,int height) {
    return img.getSubimage(x,y, width, height);

 }

}
