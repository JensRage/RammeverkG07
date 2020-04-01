package no.hiof.G07;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Player extends Unit {

    private static List<Player> instances = new ArrayList();

    public Player(int x, int y) {
        super(x, y);
        instances.add(this);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void render() {
        super.render();
    }

    // TODO:: Denne kan vi da endre etterpå
    public void move(KeyEvent e){
        char c = Character.toLowerCase(e.getKeyChar());
        if(c == 'w')
            System.out.println("w pressed");
        else if (c == 's')
            System.out.println("s pressed");
    }

    @KeyListen
    public static void playerMover(KeyEvent e){
        for(Player player : instances)
            player.move(e);
    }
}
