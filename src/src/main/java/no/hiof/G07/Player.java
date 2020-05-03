package no.hiof.G07;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

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

    /**
     * Static list of all player controlled GameObjects.
     */
    private static List<Player> instances = new ArrayList();

    public Player(){
        instances.add(this);
    }

    public Player(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        instances.add(this);
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
            setVelocityY(-1);
        else if (key == movementControl.down)
            setVelocityY(1);
        else if (key == movementControl.left)
            setVelocityX(-1);
        else if (key == movementControl.right)
            setVelocityX(1);
    }

    public void stop(KeyEvent e){
        int key = e.getKeyCode();

        if(key == movementControl.up)
            setVelocityY(0);
        else if (key == movementControl.down)
            setVelocityY(0);
        else if (key == movementControl.left)
            setVelocityX(0);
        else if (key == movementControl.right)
            setVelocityX(0);
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

    @KeyReleased
    public static void playerStopper(KeyEvent e){
        for (Player player : instances)
            player.stop(e);
    }
}
