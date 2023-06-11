package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    
    Clip clip;
    URL soundURL[] = new URL[10];

    public Sound() {

        soundURL[0] = getClass().getResource("/resources/Tanz auf dem Vulkan.mp3");
    }
    
    public void setFile(int i) {

        try {

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch(Exception e) {

        }
    }

    public void playSound() {
        clip.start();
    }
    public void loopSound() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }   
    public void stopSound() {
        clip.stop();
    }

}
