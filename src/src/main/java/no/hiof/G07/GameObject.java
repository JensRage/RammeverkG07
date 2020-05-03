package no.hiof.G07;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class is designed to be the base for all future GameObjects.
 * It holds basic information about the Object.
 * @author emilyhbh (Emily Healey)
 * @author jenshr (Jens Rage)
 * @version 0.1
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
public abstract class GameObject {

    private static List<GameObject> gameObjInstances = new ArrayList();

    private int x;
    private int y;
    private int velocityX;
    private int velocityY;
    private int width, height;
    private Sprite sprite;
    private boolean isVisible;
    private HashMap<Integer, Runnable> keyCommands;

    public GameObject(){}

    public GameObject(int x, int y, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.height = this.sprite.image.getHeight(null);
        this.width = this.sprite.image.getWidth(null);
        isVisible = true;
        keyCommands = new HashMap<>();
        gameObjInstances.add(this);
    }

    public GameObject(int x, int y, int width, int height, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
    }

    public void addKeyCommands(Integer keyCode, Runnable keyCommand) {
        keyCommands.put(keyCode, keyCommand);
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
        checkBounds();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        checkBounds();
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

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
        this.sprite.setWidth(width);
        this.sprite.setHeight(height);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;

        if(sprite != null)
            sprite.setWidth(width);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;

        if(sprite != null)
            sprite.setHeight(height);
    }

    // TODO: Can i change this in runtime?
    public void setSize(int width, int height){
        this.width = width;
        this.height = height;

        if(sprite != null){
            sprite.setWidth(width);
            sprite.setHeight(height);
        }
    }

    private void checkBounds(){

        // TODO:: get window size? only checks left wall and top wall
        isVisible = x + width >= 0 && y + height >= 0;
    }

    @KeyPressed
    public static void interact(KeyEvent e){

        Integer keyCode = e.getKeyCode();

        for(GameObject go : gameObjInstances){
            if (go.keyCommands.containsKey(keyCode))
                go.keyCommands.get(keyCode).run();
        }
    }

    @Override
    public String toString() {

        String result;
        try {
            result = new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            result = null;  // TODO: better error handling
        }

        return result;
    }
}
