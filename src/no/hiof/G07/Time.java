package no.hiof.G07;

public class Time extends Gametype {

    private int timeInSeconds;

    public Time(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public Time() {
        timeInSeconds = 0;
    }

    @Override
    boolean checkEnd() {
        return false;
    }
}
