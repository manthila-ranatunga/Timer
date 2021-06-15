import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {
    public static synchronized void play(final String filename) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(filename));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.out.println("Play sound error: " + e.getMessage() + " for " + filename);
                }
            }
        }).start();
    }
}
