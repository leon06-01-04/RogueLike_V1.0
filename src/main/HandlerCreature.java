package main;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;


public class HandlerCreature {

<<<<<<< HEAD
    private BufferedImage[] firstMob = new BufferedImage[1];
    int x;
    int y;
=======
    public ArrayList<GameObject> object = new ArrayList<GameObject>();

>>>>>>> main
    public void tick() {
      //updaten des objects
       for(int i = 0; i < object.size(); i ++) {
           GameObject tempObject = object.get(i);

           tempObject.tick();
          }
        }

<<<<<<< HEAD
    
=======
>>>>>>> main

    public void render(Graphics g) {
           //das rendern von Grafiken
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);     
        }
    
    }
    public void addObject(GameObject object) {
          this.object.add(object);
    }
    public void removeObject(GameObject object) {
          this.object.remove(object);
    }
  }
  //cake


<<<<<<< HEAD
  

    


=======
}
>>>>>>> main
