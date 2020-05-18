package GamesInTwoDimensions;

import java.util.HashMap;

/**
 * Class Behaviour
 * SUPER EARLY DEVELOPMENT
 * This class is designed to hold all the different AI states for a GameObject that needs behaviour logic executed
 * @author jenshr (Jens Henrik Rage)
 * @version 0.0001
 */
public abstract class Behaviour {

    /*
    private ArrayList<State> states;
    private Enum stateNames;
    private State currentState
     */

    private HashMap<Enum, State> states;
    private State currentState;

}
