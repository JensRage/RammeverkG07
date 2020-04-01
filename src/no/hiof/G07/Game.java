package no.hiof.G07;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game extends Canvas implements Runnable{

    private String name;
    private Window window;
    private Gametype type;
    private ArrayList<Player> players;
    private MenuConfig.Menu startMenu, pauseMenu;
    private Handler handler;
    private Thread thread;
    private int fps;

    private boolean running;

    // GameView (som mario eller pokemon) er ikke med,
    // Heller ikke gravity pga vi skulle bestemme oss for ên

    private synchronized void start(){
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
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
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
            try{Thread.sleep(
                    (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
            }catch (InterruptedException e){
                System.out.println("Sleep interrupted: " + e);
                e.printStackTrace();
            }

        }
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


    }

    public int getFps() {
        return fps;
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
