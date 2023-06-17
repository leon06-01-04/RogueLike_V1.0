package main;
import java.awt.*;

 
public class Entity {

int y, x;
int ID;
String name;
int health;
Rectangle bounds;
 
public Entity(int x, int y, int ID, int health) {
this.y = y;
this.x = x;
this.ID = ID;
this.health = health;
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
public int getID(){
    return ID;
}
}
