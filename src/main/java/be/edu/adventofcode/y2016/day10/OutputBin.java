package be.edu.adventofcode.y2016.day10;

import java.util.function.Predicate;

import javaslang.collection.List;

public class OutputBin implements Target {
    private final int number;
    private List<Integer> chips = List.empty();

    public OutputBin(int number) {
        this.number = number;
    }

    @Override
    public int number() {
        return this.number;
    }

    public List<Integer> chips() {
        return chips;
    }

    @Override
    public Predicate<ConveyorBelt> receiveChip(int chipValue) {
        chips = chips.append(chipValue);
        return conveyorBelt -> true;
    }
}
