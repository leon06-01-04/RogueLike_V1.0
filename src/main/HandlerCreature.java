package main;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class HandlerCreature {

    public ArrayList<Entity> object = new ArrayList<Entity>();

    public void tick() {
      //updaten des objects
       for(int i = 0; i < object.size(); i ++) {
           Entity tempObject = object.get(i);

           tempObject.tick();
          }
        }


    public void render(Graphics g) {
           //das rendern von Grafiken
        for(int i = 0; i < object.size(); i++) {
            Entity tempObject = object.get(i);

            tempObject.render(g);     
        }
    
    }
    public void addObject(Entity object) {
          this.object.add(object);
    }
    public void removeObject(Entity object) {
          this.object.remove(object);
    }

}
