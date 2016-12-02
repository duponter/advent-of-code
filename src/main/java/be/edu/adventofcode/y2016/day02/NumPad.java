package be.edu.adventofcode.y2016.day02;

import java.util.function.IntPredicate;

public final class NumPad implements Navigable<NumPad> {
    private final int currentButton;

    public NumPad() {
        this(5);
    }

    private NumPad(int currentButton) {
        this.currentButton = currentButton;
    }

    @Override
    public NumPad up() {
        return this.move(-3, d -> d > 3);
    }

    @Override
    public NumPad down() {
        return this.move(3, d -> d < 7);
    }

    @Override
    public NumPad left() {
        return this.move(-1, d -> d % 3 != 1);
    }

    @Override
    public NumPad right() {
        return this.move(1, d -> d % 3 != 0);
    }

    private NumPad move(int step, IntPredicate condition) {
        if (condition.test(currentButton)) {
            return new NumPad(currentButton + step);
        }
        return this;
    }

    public int currentButton() {
        return currentButton;
    }
}
