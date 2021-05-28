import bagel.*;
import bagel.util.Point;

public class Background {
    // Define constants
    private static final Image IMAGE = new Image("res/background.png");
    private final Point POSITION;

    // Constructor
    public Background() {
        this.POSITION = new Point(0, 0);
    }

    // Draw on window at POSITION
    public void update() {
        IMAGE.drawFromTopLeft(this.POSITION.x, this.POSITION.y);
    }
}
