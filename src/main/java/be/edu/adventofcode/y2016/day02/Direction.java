package be.edu.adventofcode.y2016.day02;

public final class Direction {
    private final int up;
    private final int down;
    private final int left;
    private final int right;

    public Direction(int up, int down, int left, int right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public int up() {
        return up;
    }

    public int down() {
        return down;
    }

    public int left() {
        return left;
    }

    public int right() {
        return right;
    }
}
