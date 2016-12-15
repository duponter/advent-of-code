package be.edu.adventofcode.y2016.day10;

public interface Chips {
    <R> R match(ChipsPattern<R> pattern);
}
