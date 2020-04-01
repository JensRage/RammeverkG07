package no.hiof.G07;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.Set;

public class Controls extends KeyAdapter {

    // Finds all methods annotated with @KeyListen and calls them
    Reflections reflections = new Reflections("no.hiof.G07", new MethodAnnotationsScanner());
    Set<Method> methods = reflections.getMethodsAnnotatedWith(KeyListen.class);

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (Method method : methods) {
            try {
                method.invoke(null, e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
