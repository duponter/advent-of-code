package be.edu.adventofcode.y2016.day10;

public class HasPair implements ChipsPattern<Boolean> {
    @Override
    public Boolean whenNone() {
        return false;
    }

    @Override
    public Boolean whenSingle(int value) {
        return false;
    }

    @Override
    public Boolean whenPair(int low, int high) {
        return true;
    }
}
