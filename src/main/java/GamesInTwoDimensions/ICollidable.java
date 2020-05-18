package GamesInTwoDimensions;

public interface ICollidable {
    void onCollisionEnter(GameObject collider);
    void onCollisionStay(GameObject collider);
    void onCollisionLeave(GameObject collider);
}
