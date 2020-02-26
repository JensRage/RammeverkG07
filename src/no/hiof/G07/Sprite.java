package no.hiof.G07;

import java.util.ArrayList;

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
