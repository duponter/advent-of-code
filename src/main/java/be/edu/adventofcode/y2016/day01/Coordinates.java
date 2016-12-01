package be.edu.adventofcode.y2016.day01;

public final class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates moveHorizontal(int blocks) {
        return new Coordinates(this.x + blocks, this.y);
    }

    public Coordinates moveVertical(int blocks) {
        return new Coordinates(this.x, this.y + blocks);
    }

    public int blocks() {
        return Math.abs(x) + Math.abs(y);
    }

    @Override
    public String toString() {
        return String.format("Coordinates{x=%d, y=%d}", x, y);
    }
}
