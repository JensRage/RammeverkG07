package no.hiof.G07;

/**
 * SUPER EARLY DEVELOPMENT
 * This class is designed as a tool if you are developing a game that progresses with waves.
 * @author emilyhbh (Emily Healey)
 * @version 0.00001
 */
public class Wave extends Gametype {

    private int round;

    public Wave(int round) {
        this.round = round;
    }

    public Wave() {
        round = 1;
    }

    @Override
    boolean checkEnd() {
        return false;
    }

    public int getRound() {
        return round;
    }

    public void startNextRound() {
        round++;
    }

    @Override
    public String toString() {
        return "Wave{" +
                "round=" + round +
                '}';
    }
}
