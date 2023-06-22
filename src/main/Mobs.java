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
    x +=Velx;
    y +=Vely;
    //schnelligkeit der Mobs
}
public int getY(){
    return y;
}
public int getX(){
    return x;
}
public Rectangle getBounds(){
    return new Rectangle((int) x, (int) y, width, height);
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
}
