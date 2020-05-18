package GamesInTwoDimensions;

/**
 * This class is design to hold a specific set of 4 keys used intended to be used for movement on the x & y axes
 * @author emilyhbh
 * @version 1.0
 */
public class MovementControl {

    public int up, down, left, right;

    public MovementControl(){}

    public MovementControl(int up, int down, int left, int right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public static class Wasd extends MovementControl{
        public Wasd() {
            super(87,83,65,68);
        }
    }

    public static class Arrows extends MovementControl{
        public Arrows() {
            super(38,40,37,39);
        }
    }

}