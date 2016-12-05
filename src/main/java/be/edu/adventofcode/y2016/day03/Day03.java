package be.edu.adventofcode.y2016.day03;

import javaslang.collection.Array;

import be.edu.adventofcode.Input;

public class Day03 {
    public int part1(Input input) {
        return input.lines()
                .map(Triangle::parse)
                .count(triangle -> !triangle.isInequal());
    }

    public int part2(Input input) {
        Array<String[]> lines = input.lines()
                .map(line -> line.trim().split("\\s+"))
                .toArray();
        return transpose(lines)
                .reduce(Array::appendAll)
                .grouped(3)
                .map(tokens -> String.join(" ", tokens))
                .map(Triangle::parse)
                .count(triangle -> !triangle.isInequal());
    }

    private <T> Array<Array<T>> transpose(Array<T[]> a) {
        return Array.tabulate(a.get().length, row ->
                Array.tabulate(a.size(), col -> a.get(col)[row]));
    }
}
