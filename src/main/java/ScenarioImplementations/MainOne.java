package ScenarioImplementations;

import GamesInTwoDimensions.*;

public class MainOne {

    public static void main(String[] args){

        // Scenario: mini-menu
        // Scenario: Save game progress
        // Scenario: Load game
        // Scenario: Pause and Continue Game
        MenuConfig.Menu startMenu = new MenuConfig()
                .hasSaveGameBtn()
                .hasLoadGameBtn()
                .hasPauseBtn()
                .hasContinueBtn()
                .menu();

        CustomEnemy e1 = new CustomEnemy();
        e1.setDamageDealt(10);
        e1.setSize(50,50);
        e1.setPosition(150,150);

        // Multiple Players Scnenario

            // Scenario: Run a game with WASD controls  (WASD are defualt)
            CustomPlayer p1 = new CustomPlayer();
            p1.setSize(50,100);

            // Scenario: Key-map functions
            p1.addKeyCommand(81, () -> {
                System.out.print("\npressed Q: Took player 1's health from " + p1.getHealth() + " to ");
                p1.setHealth(p1.getHealth() * 2);
                System.out.print(p1.getHealth() + "\n");
            });  // key: Q

            // Scenario: Run a game with Arrow controls
            CustomPlayer p2 = new CustomPlayer(300,200, 50, 50);
            p2.setMovementControl(new MovementControl.Arrows());

            // Scenairo: Run a game with custom control mapping
            CustomPlayer p3 = new CustomPlayer(75, 150, 50, 50);
            p3.setMovementControl(new MovementControl(84,71,70,72));   // t, g, f, h

        // Scenario: Set up custom sprite images easily
        p1.setSprite(new Sprite("./src\\main\\java\\ScenarioImplementations\\mario.png"));

        Window window = new Window("My Game", 550, 350);

        GameConfig.Game game = new GameConfig()
                .setStartMenu(startMenu)

                // Adding multiple Players to the game
                .addPlayer(p1)
                .addPlayer(p2)
                .addPlayer(p3)

                .setWindow(window)
                .game();

        game.getHandler().addObject(e1);


        // Scenario: Constant object updates are handled automatically in the game.
        // Scenario: open game window is handled automatically by Game object
        game.start();

    }

}
