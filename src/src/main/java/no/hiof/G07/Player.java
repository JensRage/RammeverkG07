package no.hiof.G07;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

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

    private static List<Player> instances = new ArrayList();

    public Player(int x, int y) {
        super(x, y);
        instances.add(this);
        movementControl = MovementControl.WASD;
    }

    @Override
    public void tick(double delta) {
        super.tick(delta);
    }

    @Override
    public void render(Graphics2D g) {
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

    @KeyListen
    public static void playerMover(KeyEvent e){
        for(Player player : instances)
            player.move(e);
    }
}
