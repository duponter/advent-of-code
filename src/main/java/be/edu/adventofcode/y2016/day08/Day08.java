package be.edu.adventofcode.y2016.day08;

import be.edu.adventofcode.Input;

public class Day08 {
    public int part1(Input input) {
        Layout startingLayout = new Landscape(new Screen());
        return input.lines()
                .map(Operation::parse)
                .foldLeft(startingLayout, (layout, op) -> op.executeWith(layout))
                .screen()
                .countLitPixels();
    }

    public String part2(Input input) {
        Layout startingLayout = new Landscape(new Screen());
        return input.lines()
                .map(Operation::parse)
                .foldLeft(startingLayout, (layout, op) -> op.executeWith(layout))
                .screen()
                .transpose()
                .toString();
    }
}
