package main;
import java.awt.Graphics;
import java.util.LinkedList;


public class HandlerCreature {

    public LinkedList<Entity> object = new LinkedList<Entity>();

    public void tick() {
      //updaten des objects
        for (Entity tempObjekt : object) {
            tempObjekt.tick();
            
        }

    }

    public void render(Graphics g) {
           //das rendern von Grafiken
        for (Entity tempObject : object) {
            tempObject.render(g);
        }
    }

    public void addObject(Entity tempObject) {
        object.add(tempObject);
        //Addition von Objecten in die LinkedList
    }

    public void removeObject(Entity tempObject) {
        object.remove(tempObject);
        //Subtraktion von Objecten aus der LinkedList
    }

}
