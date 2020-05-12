package GamesInTwoDimensions;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

import static GamesInTwoDimensions.GameConfig.*;


/**
 * This class is designed to act as a builder for the Menu class
 * @author emilyhbh (Emily Healey)
 * @version 0.1
 */
public class MenuConfig {

    private Menu menu = new Menu();

    private ArrayList<JMenuItem> menuItems = new ArrayList<>();

    public MenuConfig() {
    }

    /**
     * Adds a "Continue" button to the menu that calls the continueGame() method when clicked.
     *
     */
    public MenuConfig hasContinueBtn(){
        menuItems.add(new JMenuItem(new AbstractAction("Continue") {
            public void actionPerformed(ActionEvent e) {
                continueGame();
            }
        }));
        return this;
    }

    /**
     * Adds a "Load Game" button to the menu that calls the loadGame() method when clicked.
     *
     */
    public MenuConfig hasLoadGameBtn(){
        menuItems.add(new JMenuItem(new AbstractAction("Load Game") {
            public void actionPerformed(ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();

                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Save Files are text files", "txt");
                chooser.setFileFilter(filter);

                int returnVal = chooser.showOpenDialog(Frame.getFrames()[0]);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    loadGame(chooser.getSelectedFile());
                }
            }
        }));
        return this;
    }

    // TODO:: TEMPORARY
    public MenuConfig hasPauseBtn(){
        menuItems.add(new JMenuItem(new AbstractAction("Pause") {
            public void actionPerformed(ActionEvent e) {
                pauseGame();
            }
        }));
        return this;
    }

    /**
     * Adds a "Save Game" button to the menu that calls the saveGame() method when clicked.
     *
     */
    public MenuConfig hasSaveGameBtn(){
        menuItems.add(new JMenuItem(new AbstractAction("Save Game") {
            public void actionPerformed(ActionEvent e) {
                saveGame();
            }
        }));
        return this;
    }

    /**
     * Adds a "New Game" button to the menu that calls the newGame() method when clicked.
     *
     */
    public MenuConfig hasNewGameBtn(){
        menuItems.add(new JMenuItem(new AbstractAction("New Game") {
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        }));
        return this;
    }

    private ArrayList<JMenuItem> getMenuItems() {
        return menuItems;
    }

    private void addMenuItem(JMenuItem menuItem) {
        menuItems.add(menuItem);
    }

    private void continueGame(){
        System.out.println("Continuing");
        Continue();
    }

    private void loadGame(File saveFile){

        if(!saveFile.isFile()){
            System.out.println("The save file is invalid");
            return;
        }

        BufferedReader objReader;
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader(saveFile));

            StringBuilder savefileContent = new StringBuilder();

            while ((strCurrentLine = objReader.readLine()) != null)
                savefileContent.append(strCurrentLine);

            objReader.close();

            loadSaveContent(savefileContent.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void saveGame() {

        File file = null;
        int saveNr = 0;

        // Checks for existing save file name, increments file-nr-name instead of overwriting previous save file
        while(file == null || file.isFile()) {
            saveNr++;
            file = new File("save_file_" + saveNr + ".txt");
        }

        BufferedWriter out;
        try {
            out = new BufferedWriter(new FileWriter(file));
            out.write(getSaveContent());
            out.close();
            System.out.println("Saved Game Successfully");
        } catch (IOException e) {
            System.out.println("Could not save game");
        }
    }

    private void pauseGame(){
        System.out.println("Paused");
        Pause();
    }

    private void newGame(){
        System.out.println("New game called");
    }

    public Menu menu(){
        return menu;
    }

    /**
     * Class Menu
     * This Class is designed to hold game menus, for example: File, Edit and View
     * It utilizes JMenuBar which synergizes well with JFrame.
     * @author emilyhbh (Emily Healey)
     * @version 0.1
     */
    class Menu{
        private ArrayList<JMenuItem> items;
        private JMenuBar mb = new JMenuBar();

        /**
         *
         * @return      JMenuBar instance
         */
        public JMenuBar getMenu(){

            JMenu menu = new JMenu("Menu");

            items = getMenuItems();

            for(JMenuItem item : items){
                menu.add(item);
            }

            mb.setSize(400,400);
            mb.setVisible(true);
            mb.setLayout(null);
            mb.add(menu);

            return mb;
        }
    }
}
