package main;
import java.awt.Graphics;
import java.util.LinkedList;


public class HandlerCreature {

    private BufferedImage[] firstMob = new BufferedImage[1];

    public void tick() {
      //updaten des objects
       
            
        }

    }

    public void render(Graphics g) {
           //das rendern von Grafiken
        g.drawImage(firstMob[0],(int) x, (int) y, null);
    }

  

    

}
