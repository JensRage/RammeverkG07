package GamesInTwoDimensions;

public class Main {

    public static void main(String[] args) {

        // Write own code here

        Player p1 = new Player();

        // Assign keypress -> trigger function, works for all GameObjects
        p1.addKeyCommands(81, () -> System.out.println("q pressed"));  // key q

        Player p2 = new Player();
        p2.setMovementControl(new MovementControl.Arrows());
        p2.setPosition(200,200);

        MenuConfig.Menu startMenu = new MenuConfig()
                .hasLoadGameBtn()
                .hasNewGameBtn()
                .hasSaveGameBtn()
                .hasContinueBtn()
                .hasPauseBtn()
                .menu();

        GameConfig.Game game = new GameConfig()
                .setStartMenu(startMenu)
                .addPlayer(p1)
                .addPlayer(p2)
                .game();


        game.start();

    }

}