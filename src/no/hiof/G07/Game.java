package no.hiof.G07;

import java.util.ArrayList;

public class Game {

    private Window window;
    private Gametype type;
    private ArrayList<Player> players;
    private Menu startScreen, pauseScreen;


    // GameView (som mario eller pokemon) er ikke med,
    // Heller ikke gravity pga vi skulle bestemme oss for ên

    private void start(){

    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public Gametype getType() {
        return type;
    }

    public void setType(Gametype type) {
        this.type = type;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Menu getStartScreen() {
        return startScreen;
    }

    public void setStartScreen(Menu startScreen) {
        this.startScreen = startScreen;
    }

    public Menu getPauseScreen() {
        return pauseScreen;
    }

    public void setPauseScreen(Menu pauseScreen) {
        this.pauseScreen = pauseScreen;
    }

    @Override
    public String toString() {
        return "Game{" +
                "window=" + window +
                ", type=" + type +
                ", players=" + players +
                ", startScreen=" + startScreen +
                ", pauseScreen=" + pauseScreen +
                '}';
    }
}
