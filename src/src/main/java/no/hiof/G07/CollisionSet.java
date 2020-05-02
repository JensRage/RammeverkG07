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
}