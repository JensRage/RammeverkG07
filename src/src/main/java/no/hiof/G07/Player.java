package no.hiof.G07;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is designed to function as the player controlled object.
 * It will work on its own but can also be derived from.
 * It holds the players controls and a static list of all player controlled objects.
 * @author emilyhbh (Emily Healey)
 * @version 0.1
 */
public class Player extends Unit {

    private MovementControl movementControl;
    enum MovementControl {
        WASD(87,83,65,68),
        ARROWS(38,40,37,39);

        public int up, down, left, right;

        MovementControl(int up, int down, int left, int right) {
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Static list of all player controlled GameObjects.
     */
    private static List<Player> instances = new ArrayList();

    public Player(int x, int y) {
        super(x, y);
        instances.add(this);
        movementControl = MovementControl.WASD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void tick(double delta) {
        super.tick(delta);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(Graphics2D g) {
        //TODO:: Render sprite.
        super.render(g);
    }

    // TODO:: Denne kan vi da endre etterpå
    public void move(KeyEvent e){
        int key = e.getKeyCode();

        if(key == movementControl.up)
            setY(getY() + 1);
        else if (key == movementControl.down)
            setY(getY() - 1);
        else if (key == movementControl.left)
            setX(getX() -1);
        else if (key == movementControl.right)
            setX(getX() +1);
    }

    public MovementControl getMovementControl() {
        return movementControl;
    }

    public void setMovementControl(MovementControl movementControl) {
        this.movementControl = movementControl;
    }

    /**
     * Static method playerMover()
     * This method loops through all player controlled GameObjects, and calls the move() function from them
     * Due to the @KeyListen flag, this method is called whenever a key is pressed
     * @see Controls
     * @param e     KeyEvent that triggered the function call
     */
    @KeyListen
    public static void playerMover(KeyEvent e){
        for(Player player : instances)
            player.move(e);
    }
}
