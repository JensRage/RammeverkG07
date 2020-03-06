package no.hiof.G07;

import java.io.*;
import java.util.ArrayList;

public class Menu {

    // TODO:: figure out what to do with 'buttons', temporarily are strings for now
    private ArrayList<String> buttons = new ArrayList<>();

    public ArrayList<String> getButtons() {
        return buttons;
    }

    public void setButton(String button) {
        buttons.add(button);
    }

    private void continueGame(){

    }
    private void pauseGame(){

    }

    public Game loadGame(File saveFile){

        if(!saveFile.isFile()){
            System.out.println("The save file is invalid");
            return null;
        }

        Game loadedGame = new Game();

        BufferedReader objReader = null;
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader(saveFile));

            while ((strCurrentLine = objReader.readLine()) != null)
                System.out.println(strCurrentLine);

            objReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return loadedGame;

    }

    // TODO:: figure out way to save variables, so far is the game.toString() method
    public File saveGame(Game game) {

        File file = null;
        int saveNr = 0;

        // Checks for existing save file name, increments file-nr-name instead of overwriting previous save file
        while(file == null || file.isFile()) {
            saveNr++;
            file = new File("save_file_" + saveNr + ".txt");
        }

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file));
            out.write(game.toString());
            out.close();
            return file;
        } catch (IOException e) {
            System.out.println("Could not save game");
            //e.printStackTrace();
            return null;
        }
    }
    private void newGame(){

    }

    @Override
    public String toString() {
        return "Menu{" +
                "buttons=" + buttons +
                '}';
    }
}
