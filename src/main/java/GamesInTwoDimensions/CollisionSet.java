package GamesInTwoDimensions;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class used to hold a list of CollisionPair
 * Difference between this and a regular ArrayList is that this functions as a Set, a set will only hold one of each object.
 * @author jensh
 * @version 1.0
 */
public class CollisionSet extends ArrayList<CollisionPair>{

    /**
     * Adds a CollisionPair to the list.
     * @param collisionPair The pair to be added in the list
     * @return
     */
    @Override
    public boolean add(CollisionPair collisionPair) {
        if (this.contains(collisionPair))
            return false;
        return super.add(collisionPair);
    }

    public CollisionSet retainAllAndReturnLostPairs(Collection<?> c) {
        CollisionSet toBeRemoved = new CollisionSet();
        CollisionSet lostCollisions = new CollisionSet();
        for (CollisionPair pair : this){
            if (!c.contains(pair)){
                lostCollisions.add(pair);
                toBeRemoved.add(pair);
            }
        }
        this.removeAll(toBeRemoved);
        return lostCollisions;
    }

    /**
     * A method do find the difference between two CollisionSets.
     * @param c CollisionSet to compare to
     * @return The objects present in the list from the parameter that are NOT in the list this function is called on.
     */
    public CollisionSet findDifference(CollisionSet c){
        CollisionSet difference = new CollisionSet();

        for (CollisionPair pair : this){
            if (!c.contains(pair)){
                difference.add(pair);
            }
        }

        return difference;
    }
}