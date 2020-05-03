package no.hiof.G07;

public class CollisionPair {
    private GameObject collidee;
    private GameObject collider;

    public CollisionPair(GameObject collidee, GameObject collider) {
        this.collidee = collidee;
        this.collider = collider;
    }

    @Override
    public boolean equals(Object obj) {
        CollisionPair collisionPair = (CollisionPair)obj;
        return this.collidee.equals(collisionPair.collidee) && this.collider.equals(collisionPair.collider);
    }

    public void callOnCollisionLeave(){
        ICollidable collidable = (ICollidable)collidee;
        collidable.onCollisionLeave(collider);
    }

    public void callOnCollisionEnter(){
        ICollidable collidable = (ICollidable)collidee;
        collidable.onCollisionEnter(collider);
    }

    public void callOnCollisionStay(){
        ICollidable collidable = (ICollidable)collidee;
        collidable.onCollisionStay(collider);
    }
}
