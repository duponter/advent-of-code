package be.edu.adventofcode.y2016.day10;

import be.edu.adventofcode.Input;

public class Day10 {
    public int part1(Input input) {
        Factory factory = new Factory();
        ConveyorBelt conveyorBelt = new ConveyorBelt(factory);

        input.lines()
                .map(Instruction::parse)
                .forEach(instruction -> instruction.executeWith(conveyorBelt));

        return conveyorBelt.start().map(Bot::number).getOrElseThrow(IllegalStateException::new);
    }

    public int part2(Input input) {
        Factory factory = new Factory();
        ConveyorBelt conveyorBelt = new ConveyorBelt(factory);

        input.lines()
                .map(Instruction::parse)
                .forEach(instruction -> instruction.executeWith(conveyorBelt));

        conveyorBelt.start();
        return factory.product();
    }
}
