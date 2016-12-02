package be.edu.adventofcode.y2016.day02;

public final class KeyPad implements Navigable<KeyPad> {
    private static final Direction[] DIRECTIONS = new Direction[]{
            new Direction(1, 3, 1, 1), // 1
            new Direction(2, 6, 2, 3), // 2
            new Direction(1, 7, 2, 4), // 3
            new Direction(4, 8, 3, 4), // 4
            new Direction(5, 5, 5, 6), // 5
            new Direction(2, 10, 5, 7), // 6
            new Direction(3, 11, 6, 8), // 7
            new Direction(4, 12, 7, 9), // 8
            new Direction(9, 9, 8, 9), // 9
            new Direction(6, 10, 10, 11), // 10
            new Direction(7, 13, 10, 12), // 11
            new Direction(8, 12, 11, 12), // 12
            new Direction(11, 13, 13, 13)  // 13
    };
    private final int currentButton;

    public KeyPad() {
        this(5);
    }

    private KeyPad(int currentButton) {
        this.currentButton = currentButton;
    }

    public KeyPad up() {
        return new KeyPad(DIRECTIONS[currentButton - 1].up());
    }

    public KeyPad down() {
        return new KeyPad(DIRECTIONS[currentButton - 1].down());
    }

    public KeyPad left() {
        return new KeyPad(DIRECTIONS[currentButton - 1].left());
    }

    public KeyPad right() {
        return new KeyPad(DIRECTIONS[currentButton - 1].right());
    }

    public String currentButton() {
        return Integer.toHexString(currentButton).toUpperCase();
    }
}
