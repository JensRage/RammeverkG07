package GamesInTwoDimensions;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is designed to give users more control over the Game object.
 * Its designed as a builder, giving strong command over the most important class.
 * @author emilyhbh (Emily Healey)
 * @version 0.1
 */
public class GameConfig {

    private Game game = new Game();
    private String name = "Default Name";
    private Window window = new Window(name);
    private Gametype type = new Linear();
    private ArrayList<Player> players = new ArrayList<>();
    private MenuConfig.Menu startMenu, pauseMenu;
    private static Handler handler =  new Handler();
    private static boolean isPaused = true;

    public GameConfig() {
        addKeyListener();
    }

    public static String getSaveContent(){
        return handler.toString();
    }

    public static void loadSaveContent(String saveContent) {

        // Reads JSON serialized handler instance
        ObjectMapper om = new ObjectMapper();
        try {
            handler = om.readValue(saveContent, Handler.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Pause(){
        isPaused = true;
    }

    public static void Continue(){
        isPaused = false;
    }

    public GameConfig addPlayer(Player player){
        players.add(player);
        handler.addObject(player);
        return this;
    }

    public GameConfig addObject(GameObject gameObject){
        handler.addObject(gameObject);
        return this;
    }

    public GameConfig addObjects(ArrayList<GameObject> gameObjects){
        handler.addObjects(gameObjects);
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

    public GameConfig addKeyListener(){
        game.addKeyListener(new Controls());
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

    /**
     * This class is designed to be the games core.
     * Its derived from Canvas to allow pixel drawing, and image display (sprites).
     * It implements Runnable so that it can be run as a thread, this will later allow us to potentially split workloads.
     * @see java.awt.Canvas
     * @see java.lang.Runnable
     * @author jenshr (Jens Rage)
     * @version 0.1
     */
    public class Game extends Canvas implements Runnable{

        private Window window;
        private Thread thread;
        private int fps;
        private int TARGET_FPS = 60;
        private boolean running;

        /**
         * Method start()
         * Called to start the game, opens the window, switches running to true, and calls the thread to start.
         */
        public synchronized void start(){

            window = getWindow();
            window.addGameToFrame(this);

            if (game.getStartMenu() != null) {
                window.addComponent(game.getStartMenu().getMenu());
            }

            window.openWindow();

            thread = new Thread(this);
            //Calls run();
            thread.start();
            running = true;
            isPaused = false;
        }

        /**
         * Method stop()
         * Called to stop the game, switches running to false, and cancels the thread.
         * @throws java.lang.InterruptedException       CHECH WHEN THIS IS THROWN
         */
        public synchronized void stop(){

            try{
                thread.join();
                running = false;
                isPaused = true;
            }catch (InterruptedException ie) {
                System.out.println("Interrupted:" + ie);
                ie.printStackTrace();
            }
        }

        /**
         * Method run()
         * This is the games game loop, it uses System.nanoTime() to compare time since last iteration
         * OPTIMAL_TIME is used to target a FPS set by TARGET_FPS
         * Every iteration tick() is called with parameter delta used to make calculations fair for all hardware
         * In addition it keeps track of the current amount of frames per second.
         * {@inheritDoc}
         */
        @Override
        public void run() {

            //http://www.java-gaming.org/index.php?topic=24220.0
            long lastLoopTime = System.nanoTime();
            final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
            int lastFpsTime = 0;

            // keep looping round til the game ends
            while ( running ){

                if( !isPaused ) {

                    // work out how long its been since the last update, this
                    // will be used to calculate how far the entities should
                    // move this loop
                    long now = System.nanoTime();
                    long updateLength = now - lastLoopTime;
                    lastLoopTime = now;
                    double delta = updateLength / ((double) OPTIMAL_TIME);

                    // update the frame counter
                    lastFpsTime += updateLength;
                    fps++;

                    // update our FPS counter if a second has passed since
                    // we last recorded
                    if (lastFpsTime >= 1000000000) {
                        System.out.println("(FPS: " + fps + ")");
                        lastFpsTime = 0;
                        fps = 0;
                    }

                    // update the game logic
                    tick(delta);
                }

                // draw everyting
                render();

                if (!isPaused){

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

            }
            stop();
        }

        /**
         * Method tick()
         * This method is called from the game loop, once every iteration.
         * It is used to update the variables of GameObjects currently in the games Handler.
         * @param delta     delta consists of how long the loop update took divided by OPTIMAL_TIME which is a double
         *                  that describes how long each update should take.
         *                  This variable is used to update GameObjects variables in a way that keeps the different
         *                  processing power of different computers in mind.
         */
        private void tick(double delta){
            handler.tick(delta);
        }

        /**
         * Method render()
         * This method is called from the game loop, once every iteration.
         * It is used to update/render the graphics of a GameObject based on their current values.
         */
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

        public int getTARGET_FPS() {
            return TARGET_FPS;
        }

        public void setTARGET_FPS(int TARGET_FPS) {
            this.TARGET_FPS = TARGET_FPS;
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
