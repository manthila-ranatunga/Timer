import bagel.DrawOptions;
import bagel.Font;
import bagel.util.Colour;
import bagel.util.Point;
import java.io.*;


public class Clock {
    private final int NUMBER;
    private static int count = 1;

    private int hrs;
    private int mins;
    private int secs;

    int counter = 0;

    private DrawOptions drawOptions = new DrawOptions();
    private final Colour WHITE = new Colour(255, 255, 255);

    private Point position;

    public Clock(int hrs, int mins, int secs, Point position) {
        this.hrs = hrs;
        this.mins = mins;
        this.secs = secs;
        NUMBER = count++;

        this.position = position;

    }

    public void update() {
        Font FONT = new Font("res/IniyaDisplay.otf", 48);

        String string = "Timer " + NUMBER + "\n" + hrs + " : " + mins + " : " + secs;

        FONT.drawString(string, position.x, position.y, drawOptions);
    }

    public void tick() {
        if (secs == 0 && mins == 0 && hrs == 0) {
            return;
        }
        if (secs != -1) {
            if (counter == 60) {
                secs--;
                counter = 0;
            }
            counter++;
        } else if (mins != -1) {
            secs = 59;
            if (mins != 0) {
                mins--;

            } else if (hrs != -1) {
                mins = 59;
//                secs = 59;
                if (hrs != 0) {
                    hrs--;
                }
            }
        }
    }

//    private void playSound() throws FileNotFoundException {
//        // open the sound file as a Java input stream
//        String gongFile = "res/alarm.wav";
//        InputStream in = new FileInputStream(gongFile);
//
//        // create an audiostream from the inputstream
//        AudioStream audioStream = new AudioStream(in);
//
//        // play the audio clip with the audioplayer class
//        AudioPlayer.player.start(audioStream);
//    }

    public int inSecs() {
        return hrs * 3600 + mins * 60 + secs;
    }

    public int getNUMBER() {
        return NUMBER;
    }

    public static int getCount() {
        return count;
    }
}
