package main;
import java.awt.*;
import main.ID;
 
public class Entity {

int y, x;
ID id;
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

public Entity(int x, int y, ID id) {
this.y = y;
this.x = x;
this.id = id;

}

public void tick() {

}

public void render(Graphics g) {

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
    return id;
}
}
