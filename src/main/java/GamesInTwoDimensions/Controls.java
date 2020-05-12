package GamesInTwoDimensions;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * This class is designed to be the core KeyListener for our framework
 * It holds all methods flagged with @KeyListen and loops through them when a key is pressed
 * @see java.awt.event.KeyAdapter
 * @see org.reflections.Reflections
 * @author emilyhbh (Emily Healey)
 * @version 0.1
 */
public class Controls extends KeyAdapter {

    // Finds all methods annotated with @KeyListen and calls them
    Reflections reflections = new Reflections("GamesInTwoDimensions", new MethodAnnotationsScanner());
    Set<Method> keypressedMethods = reflections.getMethodsAnnotatedWith(KeyPressed.class);
    Set<Method> keyreleasedMethods = reflections.getMethodsAnnotatedWith(KeyReleased.class);

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * This method is called whenever a key is pressed.
     * It will iterate though all methods flagged with @KeyPressed and execute those.
     * @param e     The KeyEvent that triggered the function.
     * @throws java.lang.IllegalAccessException             If the underlying method is inaccessible.
     * @throws java.lang.reflect.InvocationTargetException  If the called method calls an exception.
     * {@inheritDoc}
     */
    @Override
    public void keyPressed(KeyEvent e) {
        for (Method method : keypressedMethods) {
            try {
                method.invoke(null, e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * This method is called whenever a key is released.
     * It will iterate though all methods flagged with @KeyReleased and execute those.
     * @param e     The KeyEvent that triggered the function.
     * @throws java.lang.IllegalAccessException             If the underlying method is inaccessible.
     * @throws java.lang.reflect.InvocationTargetException  If the called method calls an exception.
     * {@inheritDoc}
     */
    @Override
    public void keyReleased(KeyEvent e) {
        for (Method method : keyreleasedMethods) {
            try {
                method.invoke(null, e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
