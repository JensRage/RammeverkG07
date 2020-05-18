package GamesInTwoDimensions;

/**
 * This class is designed to be derived from by non friendly Units
 * @version 1.0
 */
public class Enemy extends Unit {

    private Behaviour behaviour;

    public Enemy(){}

    public Enemy(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

}
