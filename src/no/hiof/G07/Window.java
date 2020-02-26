package no.hiof.G07;

public class Window {

    private int width, height;
    private Sprite background;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Window() {
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Sprite getBackground() { return background; }

    public void setBackground(Sprite background) { this.background = background; }
}
