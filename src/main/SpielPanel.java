package main;
import java.awt.*;
import java.io.IOException;
import block.Blockmanager;

import javax.swing.*;

import java.util.Random;

public class SpielPanel extends JPanel implements Runnable {

    public static final int FIELD_SIZE = 32; // größe des Kompletten Spielfeldes
    public static final int CELL_SIZE = 25; // größe der Felder
    private static final int DELAY = 99;
    public Blockmanager blockManager = new Blockmanager(this);


    static final int SCREEN_WIDTH = 2400;
    static final int SCREEN_HEIGHT = 1050;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int FPS = 60; // verzögerung in Milimeter

    public int playerX = CELL_SIZE * 2; // X-Koordinate des Spielers
    public int playerY = CELL_SIZE * 2; // Y-Koordinate des Spielers
    private int playerSize = UNIT_SIZE; // Größe des Spielers

    Random random;
    Charakter player = new Charakter(10, 10, 0, 5);
    Thread gameThread; // sorgt fürs starten bzw stoppen
    JTextArea sideText;
    JTextArea displayFPS;
    Font fontTarea;
    

    KeyHandler keyHandler = new KeyHandler();
    MouseHandler mouseHandler = new MouseHandler();
    //Sound sound = new Sound();
  

    SpielPanel() {

        fontTarea = new Font("Georgia", Font.ITALIC | Font.BOLD, 20);
        random = new Random();
        sideText = new JTextArea();
        displayFPS = new JTextArea();

        sideText.setBounds(860, 100, 350, 100);
        sideText.setFont(fontTarea);
        sideText.setText("Willkommen in ...\n Drücken sie WASD um \n sich zu Bewegen");
        sideText.setForeground(Color.ORANGE);
        sideText.setBackground(Color.BLACK);
        sideText.setEditable(false);

        displayFPS.setBounds(1260, 100, 100, 100);
        displayFPS.setFont(fontTarea);
        displayFPS.setText("FPS:" + FPS);
        displayFPS.setForeground(Color.ORANGE);
        displayFPS.setBackground(Color.BLACK);
        displayFPS.setEditable(false);

        this.setLayout(null);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.addKeyListener(keyHandler); // keylistener/keyHandler wird dem panel hinzugefuegt
        this.addMouseListener(mouseHandler);
        this.setFocusable(true);
        this.add(sideText);
        this.add(displayFPS);
    }
    
    @Override
    public void run() {
        // thread startet automatisch diese Methode
        double drawinterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime(); // muss long sein
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawinterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) { // 1 sek in nanosec

                displayFPS.setText("FPS:"+ drawCount); // Ausgabe der Bilder Pro Sekunde
                drawCount = 0;
                timer = 0;
            }
            // System.out.println("deine mudda is running");

            // information ob das spiel noch läuft
        }

    }

    public void update() {

        if (keyHandler.upPressed == true) {
            playerY -= CELL_SIZE; // andere schreibweise: playerY = playerY - Playerspeed
            try {
                Thread.sleep(DELAY); // Füge eine Pause ein
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (keyHandler.downPressed == true) {
            playerY += CELL_SIZE;
            try {
                Thread.sleep(DELAY); // Füge eine Pause ein
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (keyHandler.leftPressed == true) {
            playerX -= CELL_SIZE;
            try {
                Thread.sleep(DELAY); // Füge eine Pause ein
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (keyHandler.rightPressed == true) {
            playerX += CELL_SIZE;
            try {
                Thread.sleep(DELAY); // Füge eine Pause ein
                } 
                catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (mouseHandler.leftMousePressed == true) {
            player.CastSwordHit();

        }
        if (mouseHandler.rightMousePressed == true) {
            player.CastShieldBlock();

        }

    }

    public void paintComponent(Graphics graphics) { // java methode in fenster zu zeichnen
        super.paintComponent(graphics);

        Rectangle hitbox = new Rectangle(FIELD_SIZE, FIELD_SIZE, UNIT_SIZE, UNIT_SIZE); // erstellen von Hitboxen mit
                                                                                        // Reckecken

        for (int row = 0; row < FIELD_SIZE; row++) {

            for (int col = 0; col < FIELD_SIZE; col++) {
                int x = col * CELL_SIZE;
                int y = row * CELL_SIZE;

                if (row == 0 || row == FIELD_SIZE - 1 || col == 0 || col == FIELD_SIZE - 1) {
                    graphics.setColor(Color.GRAY);
                    graphics.fillRect(x, y, CELL_SIZE, CELL_SIZE); // Raster wird grau ausgefüllt
                } 
                else {
                    graphics.setColor(Color.WHITE);

                }

                graphics.fillRect(x, y, CELL_SIZE, CELL_SIZE); // Raster wird schwarz ausgefüllt
                graphics.setColor(Color.BLACK);
                graphics.drawRect(x, y, CELL_SIZE, CELL_SIZE); // Raster wird Schwarz umrandet

                Graphics2D g2D = (Graphics2D) graphics;
                g2D.setColor(Color.MAGENTA); // player platzhalter Rechteck
                g2D.fillRect(playerX, playerY, CELL_SIZE, CELL_SIZE);

                if (playerX > (FIELD_SIZE - 2) * CELL_SIZE) { // wenn der spieler ausßerhalb des spielfelds läuft, wird
                                                              // er um X/Y zurückgesetzt
                    playerX--;
            }
                if (playerX < CELL_SIZE) {
                    playerX++;
                }
                if (playerY > (FIELD_SIZE - 2) * CELL_SIZE) {
                    playerY--;
                }
                if (playerY < CELL_SIZE) {
                    playerY++;
                }
            }
        }
    }
    
    /*public static void playMusic(int i) {
        sound.setFile(i);
        sound.playSound();
        sound.loopSound();
    }
    public void stopMusic() {
        sound.stopSound();
    }*/

    



    public void startgameThread() {
        gameThread = new Thread(this); // this = diese klasse wird gemeint
        gameThread.start();
    }
}
