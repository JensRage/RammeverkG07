package no.hiof.G07;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.ArrayList;

public class GameConfig {

    private Game game = new Game();
    private String name = "Default Name";
    private Window window = new Window(name);
    private Gametype type = new Linear();
    private ArrayList<Player> players = new ArrayList<>();
    private MenuConfig.Menu startMenu, pauseMenu;

    public GameConfig() {
    }

    public GameConfig addPlayer(Player player){
        players.add(player);
        return this;
    }

    public GameConfig setName(String name){
        this.name = name;
        return this;
    }

    public GameConfig setType(Gametype type){
        this.type = type;
        return this;
    }

    public GameConfig setWindow(Window window){
        this.window = window;
        return this;
    }

    public GameConfig setStartMenu(MenuConfig.Menu startMenu){
        this.startMenu = startMenu;
        return this;
    }

    public String getNamee() {
        return name;
    }


    public Gametype getTypee() {
        return type;
    }

    public Window getWindow() {
        return window;
    }

    public ArrayList<Player> getPlayerss() {
        return players;
    }

    public MenuConfig.Menu getStartMenuu() {
        return startMenu;
    }

    public MenuConfig.Menu getPauseMenuu() {
        return pauseMenu;
    }

    public Game game() {
        return game;
    }

    class Game extends Canvas implements Runnable{

        private Window window;
        private Handler handler =  new Handler();
        private Thread thread;
        private int fps;
        private final int TARGET_FPS = 60;

        private boolean running;

        public synchronized void start(){
            window = getWindow();
            window.addGameToFrame(this);
            window.addComponent(game.getStartMenu().getMenu());
            window.openWindow();

            thread = new Thread(this);
            //Calls run();
            thread.start();
            running = true;
        }

        private synchronized void stop(){
            try{
                thread.join();
                running = false;
            }catch (InterruptedException ie) {
                System.out.println("Interrupted:" + ie);
                ie.printStackTrace();
            }
        }

        @Override
        public void run() {

            //http://www.java-gaming.org/index.php?topic=24220.0
            long lastLoopTime = System.nanoTime();
            final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
            int lastFpsTime = 0;

            // keep looping round til the game ends
            while ( running ){
                // work out how long its been since the last update, this
                // will be used to calculate how far the entities should
                // move this loop
                long now = System.nanoTime();
                long updateLength = now - lastLoopTime;
                lastLoopTime = now;
                double delta = updateLength / ((double)OPTIMAL_TIME);

                // update the frame counter
                lastFpsTime += updateLength;
                fps++;

                // update our FPS counter if a second has passed since
                // we last recorded
                if (lastFpsTime >= 1000000000)
                {
                    System.out.println("(FPS: "+fps+")");
                    lastFpsTime = 0;
                    fps = 0;
                }

                // update the game logic
                tick(delta);

                // draw everyting
                render();

                // we want each frame to take 10 milliseconds, to do this
                // we've recorded when we started the frame. We add 10 milliseconds
                // to this and then factor in the current time to give
                // us our final value to wait for
                // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
                try{
                    Thread.sleep(
                            (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
                }catch (InterruptedException ie){
                    System.out.println("Sleep interrupted: " + ie);
                    ie.printStackTrace();
                }catch (IllegalArgumentException iae) {
                    System.out.println("Timeout value negative, skipping sleep");
                }

            }
            stop();
        }

        private void tick(double delta){
            handler.tick(delta);
        }

        private void render(){
            BufferStrategy bs = this.getBufferStrategy();
            if(bs == null){
                //amount of buffers could change
                this.createBufferStrategy(3);
                return;
            }

            //Typecasting for now, might change to Graphics
            Graphics2D g = (Graphics2D) bs.getDrawGraphics();

            g.setColor(Color.black);
            g.fillRect(0, 0, window.getWidth(), window.getHeight());

            handler.render(g);

            g.dispose();
            bs.show();
        }

        public int getFps() {
            return fps;
        }

        public String getName(){
            return getNamee();
        }

        public Gametype getType(){
            return getTypee();
        }

        public ArrayList<Player> getPlayers() {
            return players;
        }

        public void addPlayer(Player p){
            players.add(p);
        }

        public MenuConfig.Menu getStartMenu(){
            return getStartMenuu();
        }

        public MenuConfig.Menu getPauseMenu(){
            return getPauseMenuu();
        }

        public Handler getHandler() {
            return handler;
        }
    }
}
