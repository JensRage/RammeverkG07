package no.hiof.G07;

/**
 * This class is designed to be derived from by non friendly Units
 * @version 0.1
 */
public class Enemy extends Unit {

    private Behaviour behaviour;

    public Enemy(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }


}
