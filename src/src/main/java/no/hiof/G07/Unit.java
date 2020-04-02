package no.hiof.G07;

import java.awt.*;

public class Unit extends GameObject {

    public Unit(int x, int y) {
        super(x, y);
    }

    @Override
    public void tick(double delta) {
        setX(getX() + getVelocityX());
        setY(getY() + getVelocityY());
    }

    @Override
    public void render(Graphics2D g) {

    }
}
