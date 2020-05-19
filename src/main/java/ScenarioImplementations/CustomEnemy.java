package ScenarioImplementations;

import GamesInTwoDimensions.Enemy;
import GamesInTwoDimensions.GameObject;
import GamesInTwoDimensions.ICollidable;
import GamesInTwoDimensions.Sprite;

public class CustomEnemy extends Enemy implements ICollidable {

    private int damageDealt = 1;

    public CustomEnemy() {
    }

    public CustomEnemy(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(int damageDealt){
        this.damageDealt = damageDealt;
    }

    @Override
    public void onCollisionEnter(GameObject collider) {

    }

    @Override
    public void onCollisionStay(GameObject collider) {

    }

    @Override
    public void onCollisionLeave(GameObject collider) {

    }
}
