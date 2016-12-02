package be.edu.adventofcode.y2016.day01;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import javaslang.collection.List;

import be.edu.adventofcode.Input;

public class Day01 {
    public int part1(Input input) {
        return input.split(", ")
                .map(Instruction::new)
                .foldLeft(new Position(), Position::follow)
                .coordinates().blocks();
    }

    public int part2(Input input) {
        return input.split(", ")
                .map(Instruction::new)
                .foldLeft(List.of(new Position()),
                        (steps, instruction) -> steps.appendAll(steps.last().blocks(instruction)))
                .map(Position::coordinates)
                .dropUntil(new Duplicate())
                .head()
                .blocks();
    }

    private static class Duplicate implements Predicate<Coordinates> {
        private final Set<Coordinates> uniqueCoordinates = new HashSet<>();

        @Override
        public boolean test(Coordinates coordinates) {
            return !uniqueCoordinates.add(coordinates);
        }
    }
}
