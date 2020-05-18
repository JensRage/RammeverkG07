package GamesInTwoDimensions;

/**
 * Interface containing methods for dealing with object collision
 * @author jensh
 * @version 1.0
 */
public interface ICollidable {
    /**
     * Method to be called when two objects are first colliding
     * @param collider The object the base object is colliding with.
     */
    void onCollisionEnter(GameObject collider);

    /**
     * Method to be called when two objects are colliding for more than one tick in a row.
     * @param collider The object the base object is colliding with.
     */
    void onCollisionStay(GameObject collider);

    /**
     * Method to be called when two objects stops colliding.
     * @param collider The object the base object is colliding with.
     */
    void onCollisionLeave(GameObject collider);
}
