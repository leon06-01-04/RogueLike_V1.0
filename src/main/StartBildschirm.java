package main;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class StartBildschirm extends Main {

    JButton startBtn;
    JButton creditsBtn;
    JButton settinsBtn;

    public StartBildschirm() {

        SwingUtilities.invokeLater(() -> { //um synchronisationsprobleme zu vermeiden
        JFrame frame = new JFrame("Hello World!"); //neues fenster erstellen
        
        startBtn = new JButton("Start");
        startBtn.setPreferredSize(new Dimension(90, 40));
        
        startBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start!");
                SpielFrame spielFrame = new SpielFrame();
                frame.dispose(); //nach klick wird Fenster geschlossen
            }
        });
        
        JButton creditsBtn = new JButton("Credits");
        creditsBtn.setPreferredSize(new Dimension(90, 40));
        creditsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Credits!");
            }
        });
        
        JButton settingsBtn = new JButton("Settings");
        settingsBtn.setPreferredSize(new Dimension(90, 40));    //preffierte buttongroeße von 90 mal 40
        settingsBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Settings!");
            }
        });
        

        JPanel panel = new JPanel();

        panel.setBackground(Color.ORANGE);
        panel.add(startBtn);
        panel.add(settingsBtn);
        panel.add(creditsBtn);
        /*buttons werden dem Inhalt des fensters zugefuegt */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.getContentPane().add(panel); //panel wird dem Fenster zugefuegt
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); //nach setsize ansonsten falsche Position 
        frame.setVisible(true);
        /*this.addKeyListener(keyH);
        this.setFocusable(true); // focus um den Tastendruck zu bekommen
        */
    });
    
    }
}

