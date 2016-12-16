package be.edu.adventofcode.y2016.day10;

import javaslang.control.Option;

public class OutputBin implements Target {
    private final int number;
    private Option<Integer> chip = Option.none();

    public OutputBin(int number) {
        this.number = number;
    }

    @Override
    public int number() {
        return this.number;
    }

    public Option<Integer> chip() {
        return chip;
    }

    @Override
    public boolean workUntil(Work work) {
        return false;
    }

    @Override
    public void receiveChip(int chipValue) {
        chip = Option.some(chipValue);
    }
}
