package no.hiof.G07;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;


public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // write your code here

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player(10,20));
        players.add(new Player(20,10));

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
