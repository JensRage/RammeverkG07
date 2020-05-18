package GamesInTwoDimensions;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// source: http://zetcode.com/tutorials/javagamestutorial/movingsprites/

/**
 * Class Sprite
 * This class is designed to hold images that represents GameObjects,
 * in other words: what should be rendered to represent each object.
 * @author emilyhbh (Emily Healey)
 * @version 1.0
 */
public class Sprite {

    @JsonIgnore
    protected Image image;
    private String filename;
    private int width = 0, height = 0;

    public Sprite(){
        loadImage();
    }

    public Sprite(String filename) {
        this.filename = filename;
        loadImage();
    }

    /**
     * Loads an image to be used as the sprite takes width and height from the image unless its previously specified.
     */
    protected void loadImage() {

        // If the sprite has no width or height set than the image shall be loaded in it's full form/size
        if(width <= 0 && height <= 0){
            ImageIcon ii = new ImageIcon(filename);
            image = ii.getImage();
        }
        // If Sprite width and height is specified, the image must resize to fill it
        else {
            ImageIcon ii = new ImageIcon(filename);
            Image img = ii.getImage();
            Image scaledii = img.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
            image = new ImageIcon(scaledii).getImage();
        }
    }

    public Image getImage() {
        return image;
    }

    public void setWidth(int width) {
        this.width = width;

        if(height > 0 && width > 0)
            loadImage();
    }

    public void setHeight(int height) {
        this.height = height;

        if(width > 0 && height > 0)
            loadImage();
    }

    public String getFilename() {
        return filename;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Sprite{" + image +
                '}';
    }
}
