package no.hiof.G07;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is designed to hold all the different AI states for a GameObject that needs behaviour logic executed
 * @author jenshr (Jens Henrik Rage)
 * @version 0.1
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
