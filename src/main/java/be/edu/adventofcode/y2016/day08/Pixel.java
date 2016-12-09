package be.edu.adventofcode.y2016.day08;

public final class Pixel {
    private boolean lit;

    public Pixel() {
        this(false);
    }

    private Pixel(boolean lit) {
        this.lit = lit;
    }

    public void toggle() {
        this.lit = !this.lit;
    }

    public void turnOn() {
        this.lit = true;
    }

    public void turnOff() {
        this.lit = false;
    }

    public boolean isLit() {
        return lit;
    }
}
