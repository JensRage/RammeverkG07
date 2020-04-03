package no.hiof.G07;

import java.util.ArrayList;

/**
 * Class Sprite
 * SUPER EARLY DEVELOPMENT
 * This class is designed to hold images that represents GameObjects,
 * in other words: what should be rendered to represent each object.
 * @author emilyhbh (Emily Healey)
 * @version 0.0000x
 */
public class Sprite {

    // TODO:: Usikker på variabel typen for images, arraylist string for nå som placeholder
    private ArrayList<String> images;
    private ImageLoader imgLoader;

    public Sprite(ImageLoader imgLoader) {
        this.imgLoader = imgLoader;
    }

    private void uploadSprite(){

    }

    public ArrayList<String> getImages() {
        return images;
    }
}
