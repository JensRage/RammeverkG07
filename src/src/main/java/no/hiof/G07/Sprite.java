package no.hiof.G07;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// source: http://zetcode.com/tutorials/javagamestutorial/movingsprites/

/**
 * Class Sprite
 * SUPER EARLY DEVELOPMENT
 * This class is designed to hold images that represents GameObjects,
 * in other words: what should be rendered to represent each object.
 * @author emilyhbh (Emily Healey)
 * @version 0.0000x
 */
public class Sprite {

    protected Image image;

    public Sprite(String filename) {
        loadImage(filename);
    }

    protected void loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Sprite{" + image +
                '}';
    }
}
