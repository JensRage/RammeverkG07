package no.hiof.G07;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Window {

    private int width, height;
    private String name;
    JFrame frame = new JFrame("My First GUI");

    // TODO:: Background Sprite?
    private File background;

    public Window(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public Window(String name) {
        this.name = name;
        width = 800;
        height = 600;
    }

    public void openWindow(){

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
}
