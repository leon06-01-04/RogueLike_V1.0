package main;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.SpriteSheet;


public class Mobs extends Entity {
int diffX, diffY, distance;
int enemyType;
Rectangle bounds;
private HandlerCreature handler;
private BufferedImage[] zombie_image = new BufferedImage[4];
int height, width;
int healthmob;


//variablen für die Gegner
public  Mobs(int x, int y,  ID ID,HandlerCreature handler, SpriteSheet ss){
    super(x, y, ID);
    //super ist zum Aufrufen eines Konstruktor einer anderen Klassen (durch extends)
    height = SpielPanel.CELL_SIZE;
    width = SpielPanel.CELL_SIZE; 
    this.handler = handler;
    //fish guckt nach unten
    zombie_image[0]= ss.grabimage(0,0,SpielPanel.CELL_SIZE,SpielPanel.CELL_SIZE);
    bounds = new Rectangle((int)x, (int)y, SpielPanel.CELL_SIZE, SpielPanel.CELL_SIZE);
    // this. ist zum variablen vereinen so das alles in einem gespeichert wird.
    // rectangle ist zum Hitbox machen 
    healthmob = 100; // Initialisieren der Gesundheit des Mobs
 
}
@Override
public void tick(){
    x +=velX;
    y +=velY;
    //schnelligkeit der Mobs
    for(int i = 0; i < handler.object.size();i++){
        Entity tempObject = handler.object.get(i);
        if(tempObject.getID() == ID) {
            diffX = x - tempObject.getX() - width;
            diffY = y - tempObject.getX() - height;
            distance = (int)Math.sqrt((x - tempObject.getX()) * (x - tempObject.getX()) + (y - tempObject.getY()) *  (y - tempObject.getY())); 
            //ausrechnung von der Distance
        }
    }
    if(distance != 0) {
        velX = ((-1 / distance) * diffX);
        velY = ((-1 / distance) * diffY);
        //wenn er nicht in dem entity drin ist verfolgt er ihn
    }
}
public int getY(){
    return y;
}
public int getX(){
    return x;
}
public int getHealth(){
    return health;
}
public ID getID(){
    return ID;
}
public int enemyType(){
    return enemyType;
}
//return methoden um die information zu bekommen
@Override
public void render(Graphics g){
    g.drawImage(zombie_image[0], (int) x, (int) y,null);
    //erzeugt das Bild von dem Mob
}
@Override
public Rectangle getBounds(){
    return new Rectangle((int) x, (int) y, width, height);
}

}

    


