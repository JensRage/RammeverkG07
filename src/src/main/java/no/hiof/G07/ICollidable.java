package no.hiof.G07;

public interface ICollidable {
    void onCollisionEnter(GameObject collider);
    void onCollisionStay(GameObject collider);
    void onCollisionLeave(GameObject collider);
}
