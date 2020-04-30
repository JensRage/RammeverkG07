package no.hiof.G07;

public class Main {

    public static void main(String[] args) {

        // Write own code here

        Player p1 = new Player(0,0, new Sprite("C:\\Users\\EmHaB\\IdeaProjects\\Rammeverk\\luigi.jpg"));

        // Assign keypress -> trigger function, works for all GameObjects
        p1.addKeyCommands(81, () -> System.out.println("q pressed"));  // key q

        Player p2 = new Player(200,200,new Sprite("C:\\Users\\EmHaB\\IdeaProjects\\Rammeverk\\mario.png"));
        p2.setMovementControl(new MovementControl.Arrows());

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
