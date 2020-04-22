package no.hiof.G07;


public class Main {

    public static void main(String[] args) {

        Player p1 = new Player(10,10, new Sprite("C:\\Users\\EmHaB\\Downloads\\mario.png"));
        Player p2 = new Player(500,250, new Sprite("C:\\Users\\EmHaB\\Downloads\\mario.png"));
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
        game.getHandler().addObject(p1);
        game.getHandler().addObject(p2);

        game.start();

    }

}
