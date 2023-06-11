package main;

import java.awt.*;
import javax.swing.*;

public class SpielFrame extends JFrame {
    
    SpielPanel spielPanel;
    
    public SpielFrame() {

        spielPanel = new SpielPanel();
        spielPanel.startgameThread();
        this.add(spielPanel); //panel wird den Frame hinzugefuegt
        this.setTitle("Rogue");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Frame auf Vollbild setzen
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        
    }
}


   
    

       /* for(int row = 0; row < FIELD_SIZE; row++) {

            for(int col = 0 ; col < FIELD_SIZE;col++) {
                int x = col * CELL_SIZE;
                int y = row * CELL_SIZE;
                g.setColor(Color.WHITE);
                g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, CELL_SIZE, CELL_SIZE);

            }*/
        

