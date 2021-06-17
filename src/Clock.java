import bagel.DrawOptions;
import bagel.Font;
import bagel.Input;
import bagel.Keys;
import bagel.util.Colour;
import bagel.util.Point;

public class Clock {
    private final int NUMBER;
    private static int count = 1;
    private boolean pause = false;

    private int hrs;
    private int mins;
    private int secs;
    private boolean finished = false;

    int clkCounter = 0;
    int soundCounter = 0;

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
        Font FONT = new Font("res/Profontwindows.ttf", 48);

        String string = "Timer " + NUMBER + "\n" + hrs + ":" + mins + ":" + secs;

        FONT.drawString(string, position.x, position.y, drawOptions);
    }

    public void tick(Input input) {
        pause(input);
        if (pause) {
            return;
        }

        if (secs == 0 && mins == 0 && hrs == 0) {
            if (!finished) {
//                playAlarm();
                Sound.play("res/alarm.wav");
                finished = true;
            }
            return;
        }
        if (secs != -1) {
            if (clkCounter
                    == 60) {
                secs--;
                clkCounter
                        = 0;
            }
            clkCounter
                    ++;
        } else if (mins != -1) {
            secs = 59;
            if (mins != 0) {
                mins--;

            } else if (hrs != -1) {
                mins = 59;
                if (hrs != 0) {
                    hrs--;
                }
            }
        }
    }

    private boolean soundCount() {
        if (soundCounter == 60) {
            soundCounter = 0;
            return true;
        }
        soundCounter++;
        return false;
    }

    private void pause(Input input) {
        if (input.wasPressed(Keys.P)) {
            pause = !pause;
        }
    }

    private void playAlarm() {
        if (soundCount()) {
            Sound.play("res/alarm.wav");
        }
    }

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
