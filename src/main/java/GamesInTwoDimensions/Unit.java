package GamesInTwoDimensions;

import java.awt.*;

/**
 * Class Unit
 * This class is the first successor of GameObject. It is the most basic form of instance-able GameObjects
 * @author jenshr (Jens Rage)
 * @version 0.1
 */
public abstract class Unit extends GameObject{

    public Unit(){}

    public Unit(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    public Unit(int x, int y, int width, int height, Sprite sprite) {
        super(x, y, width, height, sprite);
    }

    /**
     * This implementation of tick allows for steady and smooth movement,
     * by setting XY coordinates to: it's position + its velocity at the given axis.
     * @param delta     delta consists of how long the loop update took divided by OPTIMAL_TIME which is a double
     *                  that describes how long each update should take.
     *                  This variable is used to update GameObjects variables in a way that keeps the different
     * {@inheritDoc}
     */
    @Override
    public void tick(double delta) {
        setX(getX() + getVelocityX());
        setY(getY() + getVelocityY());
    }

    /**
     *
     * @param g         Graphics2D object, which Canvas uses to render graphics in our window.
     * {@inheritDoc}
     */
    @Override
    public void render(Graphics2D g) {

        // Render sprite if exists, otherwise render white box
        if(getSprite() != null)
            g.drawImage(this.getSprite().getImage(), this.getX(), this.getY(), null);

        else {
            g.setColor(new Color(255, 255, 255));   // White
            g.fillRect(getX(), getY(), getWidth(), getHeight());
            g.drawRect(getX(), getY(), getWidth(), getHeight());
        }
    }



}
