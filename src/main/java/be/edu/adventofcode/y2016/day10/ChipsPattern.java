package be.edu.adventofcode.y2016.day10;

public interface ChipsPattern<R> {
    R whenNone();

    R whenSingle(int value);

    R whenPair(int low, int high);
}
