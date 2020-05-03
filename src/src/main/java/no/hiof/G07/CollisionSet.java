package no.hiof.G07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class CollisionSet extends ArrayList<CollisionPair>{
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