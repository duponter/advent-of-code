package be.edu.adventofcode.y2016.day10;

public class None implements Chips {
    @Override
    public <R> R match(ChipsPattern<R> pattern) {
        return pattern.whenNone();
    }
}
