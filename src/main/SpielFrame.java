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


   
    

        

