package main;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import main.ID;

import javax.imageio.ImageIO;
import javax.swing.*;

import block.Blockmanager;

import java.util.Random;

public class SpielPanel extends JPanel implements Runnable {

    Random random;

    Charakter player = new Charakter(10, 10 , ID.Charakter, 5);
    

    Thread gameThread; // sorgt fürs starten bzw stoppen
    JTextArea sideText;
    JTextArea displayFPS;
    JTextArea displayGold;
    JTextArea displayHealth;

    Font fontTarea;
    BufferedImage image;
    BufferedImageLoader loader;
    HandlerCreature handlerCreature;
    KeyHandler keyHandler = new KeyHandler();
    MouseHandler mouseHandler = new MouseHandler();
    Sound sound = new Sound();
    

    int randomNumberY; //
    int randomNumberX; //
    int countGold = 0;
    
    public static final int FIELD_SIZE = 32; // größe des Kompletten Spielfeldes
    public static final int CELL_SIZE = 30; // größe der Felder
    private static final int DELAY = 70;    //verzögerung um den Spieler zu verlangsamen
    public Blockmanager blockmanager = new Blockmanager(this);
   
    
    static final int SCREEN_WIDTH = 2400;
    static final int SCREEN_HEIGHT = 1050; //final = ein zugewiesener wert und endvariable erhält immer gleichen wert
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / CELL_SIZE;
    static final int FPS = 30; //bilder pro Sekunde
    
    public static int playerX = CELL_SIZE * 2; // X-Koordinate des Spielers
    public static int playerY = CELL_SIZE * 2; // Y-Koordinate des Spielers
    //position mobs
    public static int mobX = CELL_SIZE *2;
    public static int mobY = CELL_SIZE *2;

    private int playerSize = CELL_SIZE; // Größe des Spielers
    private int mobSize = CELL_SIZE; // Größe des Spielers

    SpielPanel() {
        super();
        fontTarea = new Font("Georgia", Font.ITALIC | Font.BOLD, 20); //schriftart erstellen
        random = new Random(); 
        sideText = new JTextArea(); //TextAusgabe für einem Text
        displayFPS = new JTextArea(); //Anzeige der Bilder pro Sekunde
        displayGold = new JTextArea(); //Anzeige wie viel Gold man besitzt
        displayHealth = new JTextArea();

        
        
        
        //versucht die png Datei für den spieler zu finden
         try {
            image = ImageIO.read(new File("resources\\player.png")); //Bild des Spielers
        } catch (IOException e) {
            e.printStackTrace();
        }

        sideText.setBounds(960, 100, 350, 100);
        sideText.setFont(fontTarea); //schrift für die anzeige einfuegen
        sideText.setText("Willkommen in ...\n Drücken sie WASD um \n sich zu Bewegen");
        sideText.setForeground(Color.WHITE); //schriftfarbe weiß
        sideText.setBackground(Color.BLACK);
        sideText.setEditable(false); //text kann nicht verändert werden

        displayFPS.setBounds(1760, 100, 100, 100);
        displayFPS.setFont(fontTarea);
        displayFPS.setText("FPS:" + FPS);
        displayFPS.setForeground(Color.WHITE);
        displayFPS.setBackground(Color.BLACK);
        displayFPS.setEditable(false);

        displayGold.setBounds(960, 200, 100, 100);
        displayGold.setFont(fontTarea);
        displayGold.setText("Gold:" + countGold);
        displayGold.setForeground(Color.ORANGE);
        displayGold.setBackground(Color.BLACK);
        displayGold.setEditable(false);

        this.setLayout(null);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        //Keylistener und mouselistener wird hinzugefuegt
        this.addKeyListener(keyHandler); // keylistener/keyHandler wird dem panel hinzugefuegt
        this.addMouseListener(mouseHandler);
        this.setFocusable(true);
        //wird dem Panel hinzugefuegt
        this.add(sideText);
        this.add(displayFPS);
        this.add(displayGold);
        randomNum();
    }
    private SpriteSheet ss;
    private BufferedImage sprite_sheet;
    public void init(){
        // Initialisierung 
        handlerCreature = new HandlerCreature();

        loader = new BufferedImageLoader();
        sprite_sheet = loader.loadImage("/mob.png");
        //Sprite Sheet fehlt deswegen nichts hinter /
        ss = new SpriteSheet(sprite_sheet);
        //damit kann man jeden part von dem Spritesheet benutzen kann
    }
    
    @Override
    public void run() {
        // thread startet automatisch diese Methode
         if (gameThread == null) {
        return; // Beenden, wenn gameThread nicht initialisiert wurde
    }
        double drawinterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime(); // muss long sein
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        init();
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
        /*if(playerX) {
            if(playerY) {
            }
        } */
    }
    
    public void paintComponent(Graphics graphics) { // java methode in fenster zu zeichnen
        super.paintComponent(graphics);
        
        
     
        
        for (int i = 0; i < FIELD_SIZE; i++) {
            
            for (int j = 0; j < FIELD_SIZE; j++) {
                int x = j * CELL_SIZE;
                int y = i * CELL_SIZE;
                
                if (i == 0 || i == FIELD_SIZE - 1 || j == 0 || j == FIELD_SIZE - 1) {
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
                                                              // er um ein feld zurückgesetzt
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
                if(playerX == randomNumberX && playerY == randomNumberY) {
                    countGold(countGold, graphics);
                    displayGold.setText("Gold:" + this.countGold);
                    randomNum();   
                }
                if(countGold >5) {
                    nextLvl(graphics);
                }
                handlerCreature.addObject(new Mobs(x, y, ID.Mobs, handlerCreature,ss ));
                    
                
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

    public int countGold(int countGold, Graphics graphics) {
        
    
        this.countGold++;
        countGold = this.countGold;
        displayGold.setText("Gold:" + countGold);
        graphics.setColor(Color.white);
        graphics.fillRect(randomNumberX, randomNumberY, CELL_SIZE, CELL_SIZE);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(randomNumberX, randomNumberY, CELL_SIZE, CELL_SIZE);
        graphics.setColor(Color.white);
    return countGold;
    }
    public void randomNum() {
        randomNumberY = random.nextInt(FIELD_SIZE - 2) * CELL_SIZE + CELL_SIZE;
        randomNumberX = random.nextInt(FIELD_SIZE - 2) * CELL_SIZE + CELL_SIZE;
    }
    public void nextLvl(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(CELL_SIZE * FIELD_SIZE,FIELD_SIZE/2, CELL_SIZE,CELL_SIZE);
    }
    public void startgameThread() {
        gameThread = new Thread(this); // this = diese klasse wird gemeint
        gameThread.start();
    }
}
