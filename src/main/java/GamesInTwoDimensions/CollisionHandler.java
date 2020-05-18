package GamesInTwoDimensions;

import java.awt.*;
import java.util.ArrayList;

//PROBLEM: Struggling with testing this atm
//PROBLEM: Demanding nested loops

/**
 * Class used find what collidable objects collide for each tick.
 * @author jenshr
 * @version 1.0
 */
public class CollisionHandler {

    private ArrayList<GameObject> collidableObjects = new ArrayList<>();

    private CollisionSet collisionPairs = new CollisionSet();
    private CollisionSet lastTicsCollisionPairs = new CollisionSet();

    /**
     * Function tick(), called at the end of each tick function in the Handler class. Calls the different ICollidable functions on colliding objects.
     */

    /*
    Runs a nested loop through all the collidableObjects. (collidableObjects are objects than implements ICollidable)
    If the both objects are the same it skips the iteration.
    Uses the function checkCollision to see whether to objects are colliding
    If they are then an CollisionPair object is created, containing these objects
    Then they are as a pair added to another list (collisionPairs)
    If this pair is in the list (lastTicsCollisionPairs) the function callOnCollisionStay() is called, this function is supposed to be called when two objects collide for more than one tick.
    If this pair is not in the list (lastTicsCollisionPairs) the function callOnCollisionEnter() is called, this function is supposed to be called when two objects collided this tick.
    AFTER LOOP
    We find the difference between collisionPars and lastTicksCollisionPairs and get the difference as a list.
    Loop throught the list and call the function callOnCollisionLeave() on these objects, this function is supposed to be called when two objects are no longer colliding this specific tick.
    lastTicsCollisionPairs is wiped then list collisionPairs are added to lastTicsCollisionPars
     */
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

    /**
     * Takes two GameObjects to check for collision between them.
     * @param collidee the object we check is colliding with something else.
     * @param collider the object we check is colliding with the collidee
     * @return
     */
    public boolean checkCollision(GameObject collidee, GameObject collider){
        return getBounds(collidee).intersects(getBounds(collider));
    }

    /**
     * Creates a Rectangle object based on variables of the GameObject parameter.
     * @param object Object to be "translated" to a Rectangle
     * @return Rectangle based on the GameObjects values
     */
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
