package be.edu.adventofcode.y2016.day10;

import be.edu.adventofcode.Input;

public class Day10 {
    public int part1(Input input) {
        return this.initializeFactory(input)
                .workUntilChips17And61()
                .number();
    }

    public int part2(Input input) {
        return this.initializeFactory(input)
                .product();
    }

    private Factory initializeFactory(Input input) {
        Factory factory = new Factory();
        input.lines()
                .map(Instruction::parse)
                .forEach(instruction -> instruction.apply(factory));
        return factory;
    }
}
