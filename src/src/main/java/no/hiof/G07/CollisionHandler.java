package no.hiof.G07;

import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

//PROBLEM: Struggling with testing this atm
//PROBLEM: Demanding nested loops

public class CollisionHandler {

    private ArrayList<GameObject> collidableObjects = new ArrayList<>();

    private CollisionSet collisionPairs = new CollisionSet();
    private CollisionSet lastTicsCollisionPairs = new CollisionSet();

    public void tick(){
        for (GameObject collidee : collidableObjects){
            for (GameObject collider : collidableObjects){
                if (collidee.equals(collider)) continue;


                if (checkCollision(collidee, collider)){

                    CollisionPair collisionPair = new CollisionPair(collidee, collider);

                    collisionPairs.add(collisionPair);

                    if (lastTicsCollisionPairs.contains(collisionPair))

                        collisionPair.callOnCollisionStay();
                    else
                        collisionPair.callOnCollisionEnter();
                }
            }
        }

        CollisionSet collisionsLost = lastTicsCollisionPairs.findDifference(collisionPairs);
        for (CollisionPair pair : collisionsLost){
            pair.callOnCollisionLeave();
        }
        wipeLastTicksCollisionPairs();
        lastTicsCollisionPairs.addAll(collisionPairs);
        //System.out.println(lastTicsCollisionPairs);
        wipeCollisionPairs();
        wipeCollidableObjects();
    }

    public boolean checkCollision(GameObject collidee, GameObject collider){
        return getBounds(collidee).intersects(getBounds(collider));
    }

    public Rectangle getBounds(GameObject object){
        return new Rectangle(object.getX(), object.getY(), object.getWidth(), object.getHeight());
    }

    public void addCollidable(GameObject object){
        collidableObjects.add(object);
    }

    public void removeCollidable(GameObject object){
        collidableObjects.remove(object);
    }

    private void wipeCollidableObjects(){
        collidableObjects.clear();
    }

    private void wipeCollisionPairs(){
        collisionPairs.clear();
    }

    private void wipeLastTicksCollisionPairs(){
        lastTicsCollisionPairs.clear();
    }
}
