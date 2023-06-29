package main;

public class Main {
    public static void main(String[] args) {
    
        StartBildschirm startScreen = new StartBildschirm(); //startbildschirm wird erstellt
        System.out.println("Herzlich Willkommen");
        
        SpielPanel spielpanel = new SpielPanel();
        
        spielpanel.playMusic(0);

    }
}
        
