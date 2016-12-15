package be.edu.adventofcode.y2016.day10;

public class Pair implements Chips {
    private final int lowValue;
    private final int highValue;

    public Pair(int lowValue, int highValue) {
        this.lowValue = lowValue;
        this.highValue = highValue;
    }

    @Override
    public <R> R match(ChipsPattern<R> pattern) {
        return pattern.whenPair(lowValue, highValue);
    }
}
