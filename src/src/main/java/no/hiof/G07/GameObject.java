package no.hiof.G07;

import java.awt.*;

/**
 * This class is designed to be the base for all future GameObjects.
 * It holds basic information about the Object.
 * @author emilyhbh (Emily Healey)
 * @author jenshr (Jens Rage)
 * @version 0.1
 */
public abstract class GameObject {
    private int x;
    private int y;
    private int velocityX;
    private int velocityY;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public abstract void tick(double delta);
    public abstract void render(Graphics2D g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    @Override
    public String toString() {
        return "GameObject{" +
                "x=" + x +
                ", y=" + y +
                ", velocityX=" + velocityX +
                ", velocityY=" + velocityY +
                '}';
    }
}
