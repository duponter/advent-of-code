package be.edu.adventofcode.y2016.day10;

import java.util.function.Predicate;

public interface Target {
    int number();

    Predicate<ConveyorBelt> receiveChip(int chipValue);
}
