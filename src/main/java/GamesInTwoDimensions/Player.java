package GamesInTwoDimensions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is designed to function as the player controlled object.
 * It will work on its own but can also be derived from.
 * It holds the players controls and a static list of all player controlled objects.
 * @author emilyhbh (Emily Healey)
 * @version 1.0
 */
public class Player extends Unit implements ICollidable{

    private MovementControl movementControl;

    /**
     * Static list of all player controlled GameObjects.
     */
    private static List<Player> instances = new ArrayList();

    public Player(){
        movementControl = new MovementControl.Wasd();   // Default controls are WASD
        instances.add(this);
    }

    public Player(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        instances.add(this);
        movementControl = new MovementControl.Wasd();
    }

    public Player(int x, int y, int width, int height, Sprite sprite, MovementControl movementControl) {
        super(x, y, width, height, sprite);
        this.movementControl = movementControl;
        movementControl = new MovementControl.Wasd();
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
        super.render(g);
    }

    // TODO:: change to movespeed variable
    public void move(KeyEvent e){
        int key = e.getKeyCode();

        if(key == movementControl.up)
            setVelocityY(-getMovementSpeed());
        else if (key == movementControl.down)
            setVelocityY(getMovementSpeed());
        else if (key == movementControl.left)
            setVelocityX(-getMovementSpeed());
        else if (key == movementControl.right)
            setVelocityX(getMovementSpeed());
    }

    public void stop(KeyEvent e){
        int key = e.getKeyCode();

        if(key == movementControl.up)
            setVelocityY(-getMovementSpeed());
        else if (key == movementControl.down)
            setVelocityY(getMovementSpeed());
        else if (key == movementControl.left)
            setVelocityX(-getMovementSpeed());
        else if (key == movementControl.right)
            setVelocityX(getMovementSpeed());
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
     * Due to the @KeyPressed flag, this method is called whenever a key is pressed
     * @see Controls
     * @param e     KeyEvent that triggered the function call
     */
    @KeyPressed
    public static void playerMover(KeyEvent e){
        for(Player player : instances)
            player.move(e);
    }

    /**
     * Static method playerStopper()
     * This method loops through all player controller GameObjects, and calls the stop() function from them
     * Due to the @KeyReleased flag, this method is called whenever a key is pressed
     * @param e     KeyEvent that triggered the function call
     */
    @KeyReleased
    public static void playerStopper(KeyEvent e){
        for (Player player : instances)
            player.stop(e);
    }

    @Override
    public void onCollisionEnter(GameObject collider) {
        //System.out.println("onCollisionEnter Called");
    }

    @Override
    public void onCollisionStay(GameObject collider) {
        //System.out.println("onCollisionStay Called");
    }

    @Override
    public void onCollisionLeave(GameObject collider) {
        //System.out.println("onCollisionLeave Called");
    }
}
