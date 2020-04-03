package no.hiof.G07;

/**
 * Class State
 * SUPER EARLY DEVELOPMENT
 * Successors to this class is designed to hold the AI logic for a given state.
 * As well as the condition where this state is used.
 * @author jenshr (Jens Rage)
 * @version 0.0000x
 */
public abstract class State {

    public abstract Boolean trigger();
    public abstract void stateLogic();
}
