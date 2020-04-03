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

    /**
     * Method tick()
     * This method is called from the Handler class,
     * it exists to update required variables throughout all GameObjects currently in the game.
     * Object deriving from this class will require to override this method,
     * this is where logic is decided for what where and which variables will be updated.
     * @param delta     delta consists of how long the loop update took divided by OPTIMAL_TIME which is a double
     *                  that describes how long each update should take.
     *                  This variable is used to update GameObjects variables in a way that keeps the different
     *                  processing power of different computers in mind.
     */
    public abstract void tick(double delta);

    /**
     * Method render()
     * This method is called from the Handler class,
     * it is used to update/render the graphics of a GameObject,
     * Object deriving from this class will require to override this method,
     * this is where logic is decided for what where and when the graphic is rendered.
     * @param g         Graphics2D object, which Canvas uses to render graphics in our window.
     * @see java.awt.Canvas
     * @see java.awt.Graphics2D
     */
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
