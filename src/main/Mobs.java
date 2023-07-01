package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Mobs extends Entity {
float diffX, diffY, distance;
int enemyType;
Rectangle bounds;
private HandlerCreature handler;
private BufferedImage[] zombie_image = new BufferedImage[4];
GameObject tempObject;

    // Variablen für die Gegner
    public  Mobs(int x, int y, int ID, int enemyType,HandlerCreature handler, Spritesheet ss){
         super(x, y, ID, enemyType);
        // super ist zum Aufrufen eines Konstruktors einer anderen Klasse (durch extends)
        int height = SpielPanel.CELL_SIZE;
        int width = SpielPanel.CELL_SIZE;

        int mobSize = height;
        this.handler = handler;
        //fish guckt nach unten
        bounds = new Rectangle(x, y, width, height);
        zombie_image[0]= ss.grabImage(0,0,SpielPanel.CELL_SIZE,SpielPanel.CELL_SIZE);
        bounds = new Rectangle((int)x, (int)y, SpielPanel.CELL_SIZE, SpielPanel.CELL_SIZE);
        // this. ist zum variablen vereinen so das alles in einem gespeichert wird.
        // rectangle ist zum Hitbox machen 
    }
    @Override
    public void tick(){
    float velX;
    float velY;
    x +=velX;
    y +=velY;
    //schnelligkeit der Mobs
    for(int i = 0; i < handler.object.size();i++){
        GameObject tempObject = handler.object.get(i);
        
        if(tempObject.getId() == Charakter.ID) {
            diffX = x - tempObject.getX() - width;
            diffY = y - tempObject.getX() - height;
            distance = (float)Math.sqrt((x - tempObject.getX()) * (x - tempObject.getX()) + (y - tempObject.getY()) *  (y - tempObject.getY())); 
            //ausrechnung von der Distance
        }
    }
     if(distance != 0) {
        velX = ((-1 / distance) * diffX);
        velY = ((-1 / distance) * diffY);
        //wenn er nicht in dem entity drin ist verfolgt er ihn
    }
}
    // Methode, um die Position der Mobs zu ändern
    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }
    @Override
    public void render(Graphics g){
    g.drawImage(zombie_image[0], (int) x, (int) y,null);
    //erzeugt das Bild von dem Mob
    }
    // Getter-Methoden
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public int getID() {
        return ID;
    }
    @Override
    public Rectangle getBounds(){
    return new Rectangle((int) x, (int) y, width, height);
    }   

}

    


