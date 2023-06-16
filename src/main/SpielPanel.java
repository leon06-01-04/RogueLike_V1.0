package main;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import block.Blockmanager;

import java.util.Random;

public class SpielPanel extends JPanel implements Runnable {

    Random random;
    Charakter player = new Charakter(10, 10, 0, 5);
    Thread gameThread; // sorgt fürs starten bzw stoppen
    JTextArea sideText;
    JTextArea displayFPS;
    JTextArea displayGold;
    Font fontTarea;
    BufferedImage image;
    
    
    KeyHandler keyHandler = new KeyHandler();
    MouseHandler mouseHandler = new MouseHandler();
    Sound sound = new Sound();
    
    int randomNumberY;
    int randomNumberX;   
    int countGold = 0;
    
    public static final int FIELD_SIZE = 32; // größe des Kompletten Spielfeldes
    public static final int CELL_SIZE = 25; // größe der Felder
    private static final int DELAY = 70;
    public Blockmanager blockmanager = new Blockmanager(this);
   
    
    static final int SCREEN_WIDTH = 2400;
    static final int SCREEN_HEIGHT = 1050; //final = ein zugewiesener wert und endvariable erhält immer gleichen wert
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / CELL_SIZE;
    static final int FPS = 30; // verzögerung in Milimeter
    //position spieler
    public static int playerX = CELL_SIZE * 2; // X-Koordinate des Spielers
    public static int playerY = CELL_SIZE * 2; // Y-Koordinate des Spielers
    //position mobs
    public static int mobsX = CELL_SIZE *2;
    public static int mobsY = CELL_SIZE *2;

    private int playerSize = CELL_SIZE; // Größe des Spielers
    private int mobSize = CELL_SIZE; // Größe des Spielers

    SpielPanel() {
        super();

        fontTarea = new Font("Georgia", Font.ITALIC | Font.BOLD, 20);
        random = new Random();
        sideText = new JTextArea();
        displayFPS = new JTextArea();
        displayGold = new JTextArea();

        randomNumberY = random.nextInt(FIELD_SIZE - 2) * CELL_SIZE + CELL_SIZE;
        randomNumberX = random.nextInt(FIELD_SIZE - 2) * CELL_SIZE + CELL_SIZE;
        
        

         try {
            image = ImageIO.read(new File("resources\\player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        sideText.setBounds(860, 100, 350, 100);
        sideText.setFont(fontTarea);
        sideText.setText("Willkommen in ...\n Drücken sie WASD um \n sich zu Bewegen");
        sideText.setForeground(Color.WHITE);
        sideText.setBackground(Color.BLACK);
        sideText.setEditable(false);

        displayFPS.setBounds(1760, 100, 100, 100);
        displayFPS.setFont(fontTarea);
        displayFPS.setText("FPS:" + FPS);
        displayFPS.setForeground(Color.WHITE);
        displayFPS.setBackground(Color.BLACK);
        displayFPS.setEditable(false);

        displayGold.setBounds(860, 200, 100, 100);
        displayGold.setFont(fontTarea);
        displayGold.setText("Gold:" + countGold);
        displayGold.setForeground(Color.ORANGE);
        displayGold.setBackground(Color.BLACK);
        displayGold.setEditable(false);

        this.setLayout(null);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.addKeyListener(keyHandler); // keylistener/keyHandler wird dem panel hinzugefuegt
        this.addMouseListener(mouseHandler);
        this.setFocusable(true);
        this.add(sideText);
        this.add(displayFPS);
        this.add(displayGold);
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
                graphics.setColor(Color.YELLOW);
                graphics.fillRect(randomNumberX, randomNumberY, CELL_SIZE, CELL_SIZE);
                graphics.setColor(Color.BLACK);
                graphics.drawRect(randomNumberX, randomNumberY, CELL_SIZE, CELL_SIZE);
                Graphics2D g2D = (Graphics2D) graphics;
               graphics.setColor(Color.WHITE);
               //g2D.fillRect(playerX, playerY, CELL_SIZE, CELL_SIZE);
               graphics.drawImage(image, playerX, playerY, CELL_SIZE, CELL_SIZE, null); //spieler wird eingefuegt
                

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
    
    public void playMusic(int i) {
        sound.setFile(i);
        sound.playSound();
        sound.loopSound();
    }
    public void stopMusic() {
        sound.stopSound();
    }

    



    public void startgameThread() {
        gameThread = new Thread(this); // this = diese klasse wird gemeint
        gameThread.start();
    }
}
