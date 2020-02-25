package no.hiof.G07;

public class Unit extends GameObject {

    public Unit(int x, int y) {
        super(x, y);
    }

    @Override
    public void tick() {
        setX(getX() + getVelocityX());
        setY(getY() + getVelocityY());
    }

    @Override
    public void render() {

    }
}
