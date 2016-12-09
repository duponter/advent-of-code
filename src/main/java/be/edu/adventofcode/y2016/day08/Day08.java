package be.edu.adventofcode.y2016.day08;

import be.edu.adventofcode.Input;

public class Day08 {
    public int part1(Input input) {
        return input.lines()
                .map(Operation::parse)
                .size();
    }

    public int part2(Input input) {
        return 0;
    }
}
