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

    
    // int []inventory = new int [8];

    // Fighting
    public boolean CooldownSword;
    public boolean swordHitConnects;

    public boolean CooldownShield;
    public boolean damageProtection;

    public boolean CooldownShot;
    public boolean shotConnects;

    public Timer cooldownTimerSword = new Timer(1000, this);
    public Timer cooldownTimerShield = new Timer(5000, this);
    public Timer cooldownTimerShot = new Timer(8000, this);

    public void actionPerformed(ActionEvent e) {
        // Überprüfung der Events
        if (e.getSource() == cooldownTimerSword) {
            stopCooldownSword();
        } else if (e.getSource() == cooldownTimerShield) {
            stopCooldownShield();
        } else if (e.getSource() == cooldownTimerShot) {
            stopCooldownShot();
        }
    }

    // Sword
    public void CastSwordHit() {

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

    // Shot
    public void CastShot() {
        if (!CooldownShot) {

            System.out.println("Shot");
            startCooldownShot();
            if (shotConnects == true) {
                System.out.println("does dmg");
            } else {
                System.out.println("nothing happens");
            }
        } else {

            System.out.println("No Shot");
        }
    }

    private void startCooldownShot() {
        CooldownShot = true;
        cooldownTimerShot.start();
        System.out.println("Shot: Cooldown gestartet");
    }

    private void stopCooldownShot() {
        CooldownShot = false;
        cooldownTimerShot.stop();
        System.out.println("Shot: Cooldown beendet");
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
