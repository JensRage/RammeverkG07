package no.hiof.G07;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Main {

    public static void main(String[] args) {
    // write your code here

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player(10,20));

        Game game = new Game();
        game.setName("Gamerino");

        MenuConfig mc = new MenuConfig(game)
                .hasLoadGameBtn()
                .hasSaveGameBtn()
                .hasNewGameBtn();

        game.setStartMenu(mc.menu());

        Window window = new Window(game.getName(), 1080, 480);
        window.addComponent(game.getStartMenu().getMenu());

        window.setBackground(new File("test_bg_img.jpg"));
        game.setWindow(window);
        window.openWindow();

        game.setType(new Wave());
        game.setPlayers(players);

    }
}
