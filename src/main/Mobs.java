package main;
import java.awt.Rectangle;


public class Mobs extends Entity {
float diffX, diffY, distance;
int enemyType;
Rectangle bounds;
private HandlerCreature handler;
private BufferedImage[] fish_image = new BufferedImage[4];



//variablen für die Gegner
public  Mobs(int x, int y, int ID, int enemyType,HandlerCreature handler, Spritesheet ss){
    super(x, y, ID, enemyType);
    //super ist zum Aufrufen eines Konstruktor einer anderen Klassen (durch extends)
    height = ;
    width = ;   
    this.handler = handler;
    //fish guckt nach unten
    fish_image[0]=
    bounds = new Rectangle((int)x, (int)y, 25, 25);
 // this. ist zum variablen vereinen so das alles in einem gespeichert wird.
 // rectangle ist zum Hitbox machen 
 
}
public void tick(){
    x +=VelX;
    y +=VelY;
    //schnelligkeit der Mobs
    for(int i = 0; i < handler.object.size();i++){
        GameObject tempObject = handler.object.get(i);
        if(tempObject.getId() == ID.Charakter) {
            diffX = x - tempObject.getX() - width;
            diffY = y - tempObject.getX() - height;
            distance = (float)Math.sqrt((x - tempObject.getX()) * (x - tempObject.getX()) + (y - tempObject.getY()) *  (y - tempObject.getY()));
        }
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
public int getID(){
    return ID;
}
public int enemyType(){
    return enemyType;
}
//return methoden um die information zu bekommen
public void render(Graphics g){
    g.drawImage(fish_image[0], (int) x, (int) y,null);
}
public Rectangle getBounds(){
    return new Rectangle((int) x, (int) y, width, height);
}

}
