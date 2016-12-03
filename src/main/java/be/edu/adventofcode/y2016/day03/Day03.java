package be.edu.adventofcode.y2016.day03;

import be.edu.adventofcode.Input;

public class Day03 {
    public int part1(Input input) {
        return input.lines()
                .map(Triangle::parse)
                .count(triangle -> !triangle.isInequal());
    }

    public int part2(Input input) {
        return input.lines()
                .map(Triangle::parse)
                .count(triangle -> !triangle.isInequal());
    }
}
