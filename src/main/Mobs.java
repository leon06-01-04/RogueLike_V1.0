package main;

import java.awt.Rectangle;

public class Mobs extends Entity {

    private Rectangle bounds;
    private int health;

    // Variablen für die Gegner
    public Mobs(int x, int y, int ID) {
        super(x, y, ID);
        // super ist zum Aufrufen eines Konstruktors einer anderen Klasse (durch extends)
        int height = SpielPanel.CELL_SIZE;
        int width = SpielPanel.CELL_SIZE;

        int mobSize = height;
        
        bounds = new Rectangle(x, y, width, height);
    }

    // Methode, um die Position der Mobs zu ändern
    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    // Getter-Methoden
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public int getID() {
        return ID;
    }

    // Weitere Methoden für Mobs
    // ...
}

