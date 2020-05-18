package ScenarioImplementations;

import GamesInTwoDimensions.GameObject;
import GamesInTwoDimensions.Player;

public class CustomPlayer extends Player {

    private int health, stamina, magicka;
    private boolean isAlive = true;

    public CustomPlayer() {
        // Default values
        health = 100;
        stamina = 100;
        magicka = 100;
    }

    public CustomPlayer(int x, int y, int width, int height) {
        this.setPosition(x, y);
        this.setSize(width, height);
        // Default values
        health = 100;
        stamina = 100;
        magicka = 100;
    }

    // Collision detection handling Scenario
    @Override
    public void onCollisionEnter(GameObject collider) {
        super.onCollisionEnter(collider);
        if(collider instanceof CustomEnemy)
            drainHealth(((CustomEnemy) collider).getDamageDealt());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMagicka() {
        return magicka;
    }

    public void setMagicka(int magicka) {
        this.magicka = magicka;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void drainHealth(int amountToDrain){
        this.health -= amountToDrain;

        System.out.println("health: " + health);

        if(this.health <= 0)
            isAlive = false;
    }

    public void drainMagicka(int amountToDrain){
        this.magicka -= amountToDrain;
    }

    public void drainStamina(int amountToDrain){
        this.stamina -= amountToDrain;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

}
