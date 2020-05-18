package GamesInTwoDimensions;

/**
 * Class State
 * SUPER EARLY DEVELOPMENT
 * Successors to this class is designed to hold the AI logic for a given state.
 * As well as the condition where this state is used.
 * @author jenshr (Jens Rage)
 * @version 0.00001
 */
public abstract class State {

    public abstract Boolean trigger();
    public abstract void stateLogic();
}
