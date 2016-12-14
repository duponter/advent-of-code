package be.edu.adventofcode.y2016.day10;

import java.util.function.Predicate;

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
    public Predicate<ConveyorBelt> receiveChip(int chipValue) {
        chip = Option.some(chipValue);
        return conveyorBelt -> true;
    }
}
