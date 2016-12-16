package be.edu.adventofcode.y2016.day10;

public class Single implements Chips {
    private final int value;

    public Single(int value) {
        this.value = value;
    }

    @Override
    public <R> R match(ChipsPattern<R> pattern) {
        return pattern.whenSingle(value);
    }
}
