package no.hiof.G07;

import java.util.ArrayList;

public class Handler {
    private ArrayList<GameObject> objects;

    public Handler() {
        this.objects = new ArrayList<>();
    }

    public void tick(){
        for (GameObject object : objects) {
            object.tick();
        }
    }

    public void render(){
        for (GameObject object : objects) {
            object.render();
        }
    }

    public void addObject(GameObject object){
        objects.add(object);
    }

    //Might remove return. But it might be good for debugging
    public GameObject removeObject(GameObject object) {
        objects.remove(object);
        return object;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < objects.size(); i++) {
            returnString.append("#").append(i).append(":").append(objects.get(i).toString());
        }
        return returnString.toString();
    }
}
