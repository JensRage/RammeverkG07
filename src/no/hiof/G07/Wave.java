package no.hiof.G07;

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
}
