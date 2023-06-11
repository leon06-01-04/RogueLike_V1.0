package main;
import java.awt.Graphics;
import java.util.LinkedList;
import java.awt.event.*;
import javax.swing.*;

import java.awt.*;

public class HandlerCreature {

    public LinkedList<Entity> object = new LinkedList<Entity>();

    public void tick() {

        for (Entity tempObjekt : object) {
            tempObjekt.tick();
        }

    }

    public void render(Graphics g) {

        for (Entity tempObject : object) {
            tempObject.render(g);
        }
    }

    public void addObject(Entity tempObject) {
        object.add(tempObject);
    }

    public void removeObject(Entity tempObject) {
        object.remove(tempObject);
    }

}