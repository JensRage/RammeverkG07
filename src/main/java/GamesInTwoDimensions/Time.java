package GamesInTwoDimensions;

/**
 * SUPER EARLY DEVELOPMENT
 * This class is designed to work as a tool when developing games where you are playing versus time.
 * @author emilyhbh (Emily Healey)
 * @version 0.00001
 */
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
