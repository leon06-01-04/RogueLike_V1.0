package main;
import java.awt.*;

 
public class Entity {

int y, x;
ID ID;
String name;
 int health;
Rectangle bounds;
 int velX, velY;
 
public int getVelX() {
    return velX;
}

public int getVelY() {
    return velY;
}
public Entity(int x, int y, ID ID) {
this.y = y;
this.x = x;
this.ID = ID;
this.health = health;
}


public void tick() {
//leer
}

public void render(Graphics g) {
//leer
}

public Rectangle getBounds(){
 return bounds;
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


}
