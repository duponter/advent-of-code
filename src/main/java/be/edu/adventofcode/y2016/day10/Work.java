package be.edu.adventofcode.y2016.day10;

public interface Work extends ChipsPattern<Boolean> {
    @Override
    default Boolean whenNone() {
        return false;
    }

    @Override
    default Boolean whenSingle(int value) {
        return false;
    }
}
