package main;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Charakter extends Entity implements ActionListener {

    String name = "Jannik"; 

    public Charakter(int x, int y, int ID, int health) {

        super(x, y, ID, health);
    }

    public void tick() {

    }

    public void render(Graphics g) {

    }

    // Fighting
    public boolean CooldownSword;
    public boolean swordHitConnects;

    public boolean CooldownShield;
    public boolean damageProtection;


    public Timer cooldownTimerSword = new Timer(1000, this);
    public Timer cooldownTimerShield = new Timer(5000, this);
    public Timer cooldownTimerShot = new Timer(8000, this);

    private int swordAoE_X[] [] = new int[3] [3];
    private int swordAoE_Y[] [] = new int[3] [3];


    public void actionPerformed(ActionEvent e) {
        // Überprüfung der Events
        if (e.getSource() == cooldownTimerSword) {
            stopCooldownSword();
        } else if (e.getSource() == cooldownTimerShield) {
            stopCooldownShield();
        } else if (e.getSource() == cooldownTimerShot) {
           //stopCooldownShot();
        }
    }

    // Sword
    public void CastSwordHit() {

        /*Hier werden die X und Y Koordinaten der Zellen um den Spieler deklariert. 
        swordAoE_X ist der X Wert der Zelle
        swordAoE_Y ist der Y Wert der Zelle

        Bei CastSwordHit soll in einem Radius von 1 die Umgebung via AoE attakiert werden */
        //Eventuell erweiterung auf Radius 2 

        //leftside                                                         //in the middle                             //rightside
        swordAoE_X [0] [0] = SpielPanel.playerX - SpielPanel.CELL_SIZE;    swordAoE_X [1] [0] = SpielPanel.playerX;    swordAoE_X [2] [0] = SpielPanel.playerX + SpielPanel.CELL_SIZE;
        swordAoE_X [0] [1] = SpielPanel.playerX - SpielPanel.CELL_SIZE;    swordAoE_X [1] [1] = SpielPanel.playerX;    swordAoE_X [2] [1] = SpielPanel.playerX + SpielPanel.CELL_SIZE;
        swordAoE_X [0] [2] = SpielPanel.playerX - SpielPanel.CELL_SIZE;    swordAoE_X [1] [2] = SpielPanel.playerX;    swordAoE_X [2] [2] = SpielPanel.playerX + SpielPanel.CELL_SIZE;
        //Above                                                            //in the middle                             //Down
        swordAoE_Y [0] [0] = SpielPanel.playerY - SpielPanel.CELL_SIZE;    swordAoE_Y [1] [0] = SpielPanel.playerY;    swordAoE_Y [2] [0] = SpielPanel.playerY + SpielPanel.CELL_SIZE;
        swordAoE_Y [0] [1] = SpielPanel.playerY - SpielPanel.CELL_SIZE;    swordAoE_Y [1] [1] = SpielPanel.playerY;    swordAoE_Y [2] [1] = SpielPanel.playerY + SpielPanel.CELL_SIZE;
        swordAoE_Y [0] [2] = SpielPanel.playerY - SpielPanel.CELL_SIZE;    swordAoE_Y [1] [2] = SpielPanel.playerY;    swordAoE_Y [2] [2] = SpielPanel.playerY + SpielPanel.CELL_SIZE;
            
        if (!CooldownSword) {

            
            System.out.println("SwordHit");
            startCooldownSword();
        }

        if (swordHitConnects == true) { // da fehlt ne privat klasse zur abfrage

            if (swordHitConnects == true) {

                System.out.println("does dmg");
            } else {
                System.out.println("nothing happens");
            }

        } else {

            System.out.println("No SwordHit");
        }

    }

    private void startCooldownSword() {
        CooldownSword = true;
        cooldownTimerSword.start();
        System.out.println("Sword: Cooldown gestartet");
    }

    private void stopCooldownSword() {
        CooldownSword = false;
        cooldownTimerSword.stop();
        System.out.println("Sword: Cooldown beendet");
    }

    // Shield
    public void CastShieldBlock() {
        if (!CooldownShield) {

            System.out.println("Shieldblock");

            startCooldownShield();
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



    // Interaction
    public String startInteraction() {

        return "sus";
    }

    // health
    public int reduceHealth(int health) {

        health--;
        System.out.println(health);
        return health;

    }

    public int regenerateHealth(int health) {

        if (health <= 2) {
            health = health + 3;
            System.out.println(health);
        } else {
            health = 5;
            System.out.println(health);
        }

        return health;
    }

}
