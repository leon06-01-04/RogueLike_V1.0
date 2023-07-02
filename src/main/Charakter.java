package main;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Charakter extends Entity implements ActionListener {

    int health = 3;
    String swordMessage;
    String shieldMessage;

    public Charakter(int x, int y,ID ID, int health) {
        //Konstruktor für Charakter
        super(x, y, ID);
    }

    @Override
    public void tick() {
        //leer
    }

    @Override
    public void render(Graphics g) {
        //leer
    }

    // Fighting
        //Initialisierung der boolean Variablen für die Cooldowns und der aktivierung der Fähigkeit
            //Sword
              //Sword
    public boolean CooldownSword;
    public boolean swordHitConnects;
            //Shield
    public boolean CooldownShield;
    public boolean activeShield;
    public boolean damageProtection;

        //Timer die Cooldowns als true or false definieren
    public Timer cooldownTimerSword = new Timer(1000, this);
    public Timer cooldownTimerShield = new Timer(10000, this);
    public Timer activeTimerShield = new Timer(5000, this);
    public Timer cooldownTimerShot = new Timer(8000, this);

        //Arrays für den AoE_Effekt der CastSwordHit Methode
    private int swordAoE_X[] [] = new int[5] [3];
    private int swordAoE_Y[] [] = new int[5] [3];

    /*private int shieldAoE_X[] [] = new int [3] [3];
    private int shieldAoE_Y[] [] = new int [3] [3];
    */
        //Überprüfung der Inputs/Events des Kampfes
     public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cooldownTimerSword) {
            stopCooldownSword();
        } else if (e.getSource() == cooldownTimerShield) {
            stopCooldownShield();
        } else if (e.getSource() == activeTimerShield) {
            stopActiveTimerShield();
    }
    }
      
        //Fighting Methoden
        // Sword
    public String CastSwordHit() {

        /*Hier werden die X und Y Koordinaten der Zellen um den Spieler deklariert. 
        swordAoE_X ist der X Wert der Zelle
        swordAoE_Y ist der Y Wert der Zelle

        Bei CastSwordHit soll in einem Radius von 2 die Umgebung via AoE attakiert werden */
        
        
        //1. linke Spalte                                                   //2. linke Spalte                                                  //mittlere Spalte                           //1. rechte Spalte                                                 //2. rechte Spalte
        swordAoE_X [0] [0] = SpielPanel.playerX - 2*SpielPanel.CELL_SIZE;   swordAoE_X [1] [0] = SpielPanel.playerX - SpielPanel.CELL_SIZE;    swordAoE_X [2] [0] = SpielPanel.playerX;    swordAoE_X [3] [0] = SpielPanel.playerX + SpielPanel.CELL_SIZE;    swordAoE_X [4] [0] = SpielPanel.playerX + 2*SpielPanel.CELL_SIZE; 
        swordAoE_X [0] [1] = SpielPanel.playerX - 2*SpielPanel.CELL_SIZE;   swordAoE_X [1] [1] = SpielPanel.playerX - SpielPanel.CELL_SIZE;    swordAoE_X [2] [1] = SpielPanel.playerX;    swordAoE_X [3] [1] = SpielPanel.playerX + SpielPanel.CELL_SIZE;    swordAoE_X [4] [1] = SpielPanel.playerX + 2*SpielPanel.CELL_SIZE;
        swordAoE_X [0] [2] = SpielPanel.playerX - 2*SpielPanel.CELL_SIZE;   swordAoE_X [1] [2] = SpielPanel.playerX - SpielPanel.CELL_SIZE;    swordAoE_X [2] [2] = SpielPanel.playerX;    swordAoE_X [3] [2] = SpielPanel.playerX + SpielPanel.CELL_SIZE;    swordAoE_X [4] [2] = SpielPanel.playerX + 2*SpielPanel.CELL_SIZE;
        //1. obere Reihe                                                    //2. obere                                                         //mittlere Reihe                            //1. untere Reihe                                                  //2. untere Reihe
        swordAoE_Y [0] [0] = SpielPanel.playerY - 2*SpielPanel.CELL_SIZE;   swordAoE_Y [1] [0] = SpielPanel.playerY - SpielPanel.CELL_SIZE;    swordAoE_Y [2] [0] = SpielPanel.playerY;    swordAoE_Y [3] [0] = SpielPanel.playerY + SpielPanel.CELL_SIZE;    swordAoE_Y [4] [0] = SpielPanel.playerY + 2*SpielPanel.CELL_SIZE; 
        swordAoE_Y [0] [1] = SpielPanel.playerY - 2*SpielPanel.CELL_SIZE;   swordAoE_Y [1] [1] = SpielPanel.playerY - SpielPanel.CELL_SIZE;    swordAoE_Y [2] [1] = SpielPanel.playerY;    swordAoE_Y [3] [1] = SpielPanel.playerY + SpielPanel.CELL_SIZE;    swordAoE_Y [4] [1] = SpielPanel.playerY + 2*SpielPanel.CELL_SIZE;
        swordAoE_Y [0] [2] = SpielPanel.playerY - 2*SpielPanel.CELL_SIZE;   swordAoE_Y [1] [2] = SpielPanel.playerY - SpielPanel.CELL_SIZE;    swordAoE_Y [2] [2] = SpielPanel.playerY;    swordAoE_Y [3] [2] = SpielPanel.playerY + SpielPanel.CELL_SIZE;    swordAoE_Y [4] [2] = SpielPanel.playerY + 2*SpielPanel.CELL_SIZE;
        
        //mit der Hilfe von Andrei

        if (!CooldownSword && !activeShield) { 
        //Abfrage nach laufendem Cooldown

            System.out.println("SwordHit");
            swordMessage = "sword Hit";
            spielpanel.playMusic(2);
            startCooldownSword();
  
            for (int i = 0; i<5; i++) {
                for (int j = 0; j<3; j++ ) {

                
                  
                            if (SpielPanel.mobX == swordAoE_X [i] [j] && SpielPanel.mobY == swordAoE_Y [i] [j] ) { //maybe andere Variable

                        swordHitConnects = true;

                        if (swordHitConnects == true) {

                            // Hier muss dann der Mob mit den jeweiligen X und Y Koordinaten schaden bekommen
                            System.out.println("does dmg");
                            swordMessage = "does damage";
                        } else {
                             System.out.println("nothing happens");
                             swordMessage = "No Sword hit";                              
                        }
                    }
                }
            }
        } else {
            System.out.println("No Swordhit"); 
            
              
        }
        return swordMessage;
    }
    
    private void startCooldownSword() {

        //Klasse zum Start des Cooldowns. Dabei wird Cooldown auf true gesetzt und der Timer des Cooldowns gestartet
        CooldownSword = true;
        
        cooldownTimerSword.start();
        swordMessage = "cooldown active";
        System.out.println("Sword: Cooldown gestartet");
    }

    private void stopCooldownSword() {

        //Klasse zum Stoppen des Cooldowns. 
        CooldownSword = false;
        swordMessage = "cooldown ends";
        cooldownTimerSword.stop();
        System.out.println("Sword: Cooldown beendet");
    }

        // Shield
    public String CastShieldBlock() {

           

      
        if (!CooldownShield) {
            System.out.println("Shieldblock active");
            shieldMessage = "shield block active";
            startCooldownShield();
            startActiveTimerShield();
            spielpanel.playMusic(4);

                //eventuell Abbrechbarkeit durch eine Differenz Rechnung des Cooldowns
            while (CooldownShield == false) {
                System.out.println("cant take dmg");
                 swordMessage = "cant take dmg";
            }
        } else {
            System.out.println("No Shieldblock");
            shieldMessage = "No shildblock";
        }
        return shieldMessage;
    }


    private void startCooldownShield() {
        CooldownShield = true;
        cooldownTimerShield.start();
        System.out.println("Shield: Cooldown gestartet");
        shieldMessage = "cooldown active";
    }

    private void stopCooldownShield() {
        CooldownShield = false;
        cooldownTimerShield.stop();
        System.out.println("Shield: Cooldown beendet");
    }

    // health
        //Schadenskalkulation nach dem der Spieler getroffen wurde
    public void reduceHealth(int health) {

        health--;
        System.out.println(health);
        

    }
       private void startActiveTimerShield() {
        activeShield = true;
        activeTimerShield.start();
        System.out.println("Shield: Aktiv");
        shieldMessage = "shield active";
    }

    private void stopActiveTimerShield() {
        activeShield = false;
        activeTimerShield.stop();
        System.out.println("Shield: Nicht mehr Aktiv");
    }

        //(Teilweise) Reneration von Leben beim wechseln des Raumes
    public void regenerateHealth() {

        if (health <= 1) {
            health++;
            System.out.println(health);
        } 
        else {
            health = 3;
            System.out.println(health);
        }

        
    }
      //(Teilweise) Reneration von Leben beim wechseln des Raumes
    
    

}
