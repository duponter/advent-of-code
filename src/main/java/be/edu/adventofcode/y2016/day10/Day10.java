package be.edu.adventofcode.y2016.day10;

import be.edu.adventofcode.Input;

public class Day10 {
    public int part1(Input input) {
        return input.lines()
                .map(Instruction::parse)
                .size();
    }

    public int part2(Input input) {
        return 0;
    }
}
