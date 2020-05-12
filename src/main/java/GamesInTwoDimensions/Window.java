package GamesInTwoDimensions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Class Window
 * This class is designed to be the window of our application.
 * It uses the JFrame class to get this functionality
 * @author emilyhbh (Emily Healey)
 * @version 0.1
 */
public class Window {

    private int width, height;
    private String name;
    JFrame frame = new JFrame();

    // TODO:: Background Sprite?
    private File background;

    public Window(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        frame.addKeyListener(new Controls());
    }

    public Window(String name) {
        this.name = name;
        width = 800;
        height = 600;
        frame.addKeyListener(new Controls());
    }

    /**
     * Method openWindow()
     * Sets basic window settings and proceeds to
     * launch our application window
     */
    public void openWindow(){

        frame.setTitle(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);

        // Sets background
        if(background != null && background.isFile()){
            try {
                frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(background))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        frame.setVisible(true);
    }

    public void addComponent(JComponent comp){
        if(comp instanceof JMenuBar){
            frame.setJMenuBar((JMenuBar) comp);
        }
    }

    /**
     * Adds the game we want displayed in the window to our frame instance
     * @param game      The game we want displayed in the window.
     */
    public void addGameToFrame(GameConfig.Game game){
        frame.add(game);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public File getBackground() { return background; }

    public void setBackground(File background) { this.background = background; }

    public void setName(String name) {
        this.name = name;
    }
}
