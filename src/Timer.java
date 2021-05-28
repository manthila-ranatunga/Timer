// https://stackoverflow.com/questions/7504641/java-input-without-pausing/7504712

/*
Timer 1.0 by Manthila Ranatunga
Started 10/05/2021
 */

import bagel.*;
import bagel.util.Colour;
import bagel.util.Point;

import java.util.ArrayList;
import java.util.Scanner;


public class Timer extends AbstractGame {
    private Background background = new Background();

    private DrawOptions drawOptions = new DrawOptions();
    private final Colour WHITE = new Colour(255, 255, 255);

//    Scanner scanner = new Scanner(System.in);

    private ArrayList<Clock> clocks = new ArrayList<>();
    private ArrayList<String> inputs = new ArrayList<>();

    private Point posTracker = new Point(20.0, 120.0);
    private int numClocks = 0;
    private int columns = 0;


    public Timer() {
        super(800, 600, "Timer 1.0 by Manthila Ranatunga");

        inputs.add("0 0 10");
        inputs.add("0 0 20");
        inputs.add("0 1 5");
        inputs.add("0 2 30");
        inputs.add("1 0 5");


        for (String input : inputs) {

            initialise(input);
        }

    }


    public void drawString(String string, int size, Point position) {
        Font FONT = new Font("res/IniyaDisplay.otf", size);
        FONT.drawString(string, position.x, position.y, drawOptions);
    }

//    public void takeInput() {
//        if (scanner.hasNext()) {
//            String input = scanner.nextLine();
//
//            String[] splitInput = input.split(" ");
//
//            int hrs = Integer.parseInt(splitInput[0]);
//            int mins = Integer.parseInt(splitInput[1]);
//            int secs = Integer.parseInt(splitInput[2]);
//
//            Point position = displayPositionGenerator();
//            clocks.add(new Clock(hrs, mins, secs, position.x, position.y));
//        }
//    }


    public void initialise(String input) {

        String[] splitInput = input.split(" ");

        int hrs = Integer.parseInt(splitInput[0]);
        int mins = Integer.parseInt(splitInput[1]);
        int secs = Integer.parseInt(splitInput[2]);

        displayPositionGenerator();
        clocks.add(new Clock(hrs, mins, secs, posTracker));

    }

    public void displayPositionGenerator() {

        if (posTracker.x >= 600.0) {
            posTracker = new Point(20, posTracker.y + 120);
        } else {
            if (numClocks != 0) {
                posTracker = new Point(posTracker.x + 200, posTracker.y);
            }
        }

        numClocks++;
    }


    @Override
    public void update(Input input) {
        background.update();
//        takeInput();
        for (Clock clock : clocks) {
            clock.update();
            clock.tick();
        }
    }


    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.run();
    }
}