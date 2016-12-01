package be.edu.adventofcode.y2015;

import be.edu.adventofcode.Input;

public class Day01 {
    public static void main(String[] args) {
        new Day01().part1();
        new Day01().part2();
    }

    private void part1() {
        System.out.printf("Day 1 - Part 1 - To what floor do the instructions take Santa? %d%n", new Input(this.getClass()).chars()
                .foldLeft(0, (pos, next) -> (pos += (next == '(') ? 1 : -1))
        );
    }

    private void part2() {
        System.out.printf("Day 1 - Part 2 - What is the position of the character that causes Santa to first enter the basement? %d%n", new Input(this.getClass()).chars()
                .scanLeft(0, (pos, next) -> (pos += (next == '(') ? 1 : -1))
                .takeUntil(pos -> pos == -1)
                .size());
    }
}
