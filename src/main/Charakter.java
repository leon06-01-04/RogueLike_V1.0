package main;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Charakter extends Entity implements ActionListener {

    int health = 3;

    public Charakter(int x, int y, int ID, int health) {
        //Konstruktor für Charakter
        super(x, y, ID, health);
    }

    public void tick() {
        //leer
    }

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

    private int shieldAoE_X[] [] = new int [3] [3];
    private int shieldAoE_Y[] [] = new int [3] [3];

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

    public void CastSwordHit() {

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

        if (!CooldownSword && !activeShield) { //soll auch nicht möglich sein wenn Shieldblock aktiv ist 
       
        //Abfrage nach laufendem Cooldown

            System.out.println("SwordHit");
            startCooldownSword();
  
            for (int i = 0; i<5; i++) {
                for (int j = 0; j<3; j++ ) {

                
                  
                            if (SpielPanel.mobX == swordAoE_X [i] [j] && SpielPanel.mobY == swordAoE_Y [i] [j] ) { //maybe andere Variable

                        swordHitConnects = true;

                        if (swordHitConnects == true) {

                            // Hier muss dann der Mob mit den jeweiligen X und Y Koordinaten schaden bekommen
                            System.out.println("does dmg");
                        } else {
                             System.out.println("nothing happens");
                        }
                    }
                }
            }
        } else {
            System.out.println("No Swordhit");    
        }
    }
    
        //Unvollständig

    private void startCooldownSword() {

        //Klasse zum Start des Cooldowns. Dabei wird Cooldown auf true gesetzt und der Timer des Cooldowns gestartet
        CooldownSword = true;
        cooldownTimerSword.start();
        System.out.println("Sword: Cooldown gestartet");
        
    }

    private void stopCooldownSword() {

        //Klasse zum Stoppen des Cooldowns. 
        CooldownSword = false;
        cooldownTimerSword.stop();
        System.out.println("Sword: Cooldown beendet");
    }

        // Shield
    public void CastShieldBlock() {

            /* Selbe Prinzip wie bei swordAoE_X und swordAoE_Y
               Hier wird im Radius von 1 ein Shield erstellt das den Spieler beim durchlaufen von Mobs vor Schaden schützt,
               gleichzeitig aber verhindert Schaden selbst zu machen
           

        //2. linke Spalte                                                   //mittlere Spalte                            //1. rechte Spalte                                                 
        shieldAoE_X [1] [0] = SpielPanel.playerX - SpielPanel.CELL_SIZE;    shieldAoE_X [2] [0] = SpielPanel.playerX;    shieldAoE_X [3] [0] = SpielPanel.playerX + SpielPanel.CELL_SIZE;    
        shieldAoE_X [1] [1] = SpielPanel.playerX - SpielPanel.CELL_SIZE;    shieldAoE_X [2] [1] = SpielPanel.playerX;    shieldAoE_X [3] [1] = SpielPanel.playerX + SpielPanel.CELL_SIZE;    
        shieldAoE_X [1] [2] = SpielPanel.playerX - SpielPanel.CELL_SIZE;    shieldAoE_X [2] [2] = SpielPanel.playerX;    shieldAoE_X [3] [2] = SpielPanel.playerX + SpielPanel.CELL_SIZE;    
        //2. obere                                                          //mittlere Reihe                             //1. untere Reihe                                                  
        shieldAoE_Y [1] [0] = SpielPanel.playerY - SpielPanel.CELL_SIZE;    shieldAoE_Y [2] [0] = SpielPanel.playerY;    shieldAoE_Y [3] [0] = SpielPanel.playerY + SpielPanel.CELL_SIZE;     
        shieldAoE_Y [1] [1] = SpielPanel.playerY - SpielPanel.CELL_SIZE;    shieldAoE_Y [2] [1] = SpielPanel.playerY;    shieldAoE_Y [3] [1] = SpielPanel.playerY + SpielPanel.CELL_SIZE;    
        shieldAoE_Y [1] [2] = SpielPanel.playerY - SpielPanel.CELL_SIZE;    shieldAoE_Y [2] [2] = SpielPanel.playerY;    shieldAoE_Y [3] [2] = SpielPanel.playerY + SpielPanel.CELL_SIZE;    
                                        //mit der Hilfe von Andrei
        */
        if (!CooldownShield) {
            System.out.println("Shieldblock active");
            startCooldownShield();
                //eventuell Abbrechbarkeit durch eine Differenz Rechnung des Cooldowns
            while (CooldownShield == false) {
                System.out.println("cant take dmg");
            }
        } else {
            System.out.println("No Shieldblock");
        }
    }


    private void startCooldownShield() {
        CooldownShield = true;
        cooldownTimerShield.start();
        System.out.println("Shield: Cooldown gestartet");
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
