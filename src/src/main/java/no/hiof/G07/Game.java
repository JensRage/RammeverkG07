package no.hiof.G07;

import java.util.ArrayList;

public class Game {

    private String name;
    private Window window;
    private Gametype type;
    private ArrayList<Player> players;
    private MenuConfig.Menu startMenu, pauseMenu;

    // GameView (som mario eller pokemon) er ikke med,
    // Heller ikke gravity pga vi skulle bestemme oss for ên

    private void start(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public MenuConfig.Menu getStartMenu() {
        return startMenu;
    }

    public void setStartMenu(MenuConfig.Menu startMenu) {
        this.startMenu = startMenu;
    }

    public MenuConfig.Menu getPauseMenu() {
        return pauseMenu;
    }

    public void setPauseMenu(MenuConfig.Menu pauseMenu) {
        this.pauseMenu = pauseMenu;
    }

    @Override
    public String toString() {
        return "Game{" +
                "window=" + window +
                ", type=" + type +
                ", players=" + players +
                ", startMenu=" + startMenu +
                ", pauseMenu=" + pauseMenu +
                '}';
    }
}
