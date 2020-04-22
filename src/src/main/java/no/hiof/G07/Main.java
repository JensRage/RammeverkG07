package no.hiof.G07;

import java.io.File;


public class Main {

    public static void main(String[] args) {
        // write your code here

        Player p1 = new Player(10,20);
        Player p2 = new Player(20,10);
        p2.setMovementControl(Player.MovementControl.ARROWS);
        p1.setMovementControl(Player.MovementControl.WASD);

        MenuConfig mc = new MenuConfig()
                .hasLoadGameBtn()
                .hasSaveGameBtn()
                .hasNewGameBtn();

        GameConfig gc = new GameConfig()
                            .addPlayer(p1).addPlayer(p2)
                            .setStartMenu(mc.menu())
                            .addKeyListener();

        GameConfig.Game game = gc.game();

        game.start();

    }

}
