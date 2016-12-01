package be.edu.adventofcode.y2016.day01;

import javaslang.collection.List;

import be.edu.adventofcode.Input;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;

public class Day01 {
    public int part1(Input input) {
        return input.split(", ")
            .map(Instruction::new)
            .foldLeft(new Position(), Position::follow)
            .blocks();
    }

    public static void main(String[] args) {
        List.of("R2, L3", "R2, R2, R2", "R5, L5, R5, R3")
                .forEach(instruction ->
                        Solve.day(1)
                                .part(1)
                                .q(instruction + "?")
                                .a(new Day01().part1(new StringInput(instruction))));

    }
}
