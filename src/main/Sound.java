package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

                                        //Ganze Klasse entnommen aus dem Tutorial: https://www.youtube.com/watch?v=nUHh_J2Acy8

public class Sound {
    
    Clip clip;
    //Initialsierung eines Clips

    URL soundURL[] = new URL[10];
    //verlinkung der MUsik/Sounddateien

    public Sound() {

        //Arrays zur verwaltung der jeweilig benötigten Soundeffekte
        soundURL[0] = getClass().getResource("/ed.mp3");
        soundURL[1] = getClass().getResource("/clickbutton.mp3"); 
        soundURL[2] = getClass().getResource("/sword.mp3");
        soundURL[3] = getClass().getResource("/coins.mp3");
        soundURL[4] = getClass().getResource("activebarrier5sek.mp3");
        soundURL[5] = getClass().getResource("resources\\TanzaufdemVulkan.wav");
        soundURL[6] = getClass().getResource("resources\\TanzaufdemVulkan.wav");
        soundURL[7] = getClass().getResource("resources\\TanzaufdemVulkan.wav");
    }
    
    public void setFile(int i) {
        
        try {
            //try-Methode, versucht auszuführen
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]); //NOCH KOMMENTAR ERGÄNZEN
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch(Exception e) {

        }
    }

    //Clip
    //Clip starten
    public void playSound() {
        clip.start();
    }
        //Clip loopen (Dauerschleife)
    public void loopSound() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }   
        //Clip stopen
    public void stopSound() {
        clip.stop();
    }

}
