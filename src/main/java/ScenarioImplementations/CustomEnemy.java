package ScenarioImplementations;

import GamesInTwoDimensions.Enemy;
import GamesInTwoDimensions.Sprite;

public class CustomEnemy extends Enemy {

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
}
