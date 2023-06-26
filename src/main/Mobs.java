package main;
import java.awt.Rectangle;


public class Mobs extends Entity {

int enemyType;
Rectangle bounds;



//variablen für die Gegner
public  Mobs(int x, int y, int ID, int enemyType){
    super(x, y, ID, enemyType);
    //super ist zum Aufrufen eines Konstruktor einer anderen Klassen (durch extends)
    int height = 25;
    int width = 25;   
    //(SpielPanel Frame Size);
    


    bounds = new Rectangle((int)x, (int)y, 25, 25);
 // this. ist zum variablen vereinen so das alles in einem gespeichert wird.
 // rectangle ist zum Hitbox machen 
 // float ist zum positionen eingeben
}
public void speed(int x,int y){
    this.x +=x;
    this.y +=y;
    //schnelligkeit der Mobs
}
@Override
public int getY(){
    return y;
}
@Override
public int getX(){
    return x;
}
/*public Rectangle getBounds(){
    return new Rectangle((int) x, (int) y, width, height);
}
*/
public int getHealth(){
    return health;
}
public int getID(){
    return ID;
}
public int enemyType(){
    return enemyType;

}
}
//return methoden um die information zu bekommen
