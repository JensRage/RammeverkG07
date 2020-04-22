package no.hiof.G07;

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
    private Reflections reflections = new Reflections("no.hiof.G07", new MethodAnnotationsScanner());
    private Set<Method> pressMethods = reflections.getMethodsAnnotatedWith(KeyPressed.class);
    private Set<Method> releaseMethods = reflections.getMethodsAnnotatedWith(KeyReleased.class);

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * This method is called whenever a key is pressed.
     * It will iterate though all methods flagged with @KeyListen and execute those.
     * @param e     The KeyEvent that triggered the function.
     * @throws java.lang.IllegalAccessException             If the underlying method is inaccessible.
     * @throws java.lang.reflect.InvocationTargetException  If the called method calls an exception.
     * {@inheritDoc}
     */
    @Override
    public void keyPressed(KeyEvent e) {
        for (Method method : pressMethods) {
            try {
                method.invoke(null, e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    //TODO:: Use this as well
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(releaseMethods.size());
        for (Method method : releaseMethods) {
            try {
                method.invoke(null, e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
