package main;
import java.awt.Graphics;
import java.util.LinkedList;


public class HandlerCreature {

    private BufferedImage[] firstMob = new BufferedImage[1];

    public void tick() {
      //updaten des objects
        for (Entity tempObjekt : object) {
            tempObjekt.tick();
            
        }

    }

    public void render(Graphics g) {
           //das rendern von Grafiken
        g.drawImage(firstMob[0],(int) x, (int) y, null);
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
