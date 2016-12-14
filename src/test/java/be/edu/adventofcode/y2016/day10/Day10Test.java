package be.edu.adventofcode.y2016.day10;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10Test {
    @Test
    void solvePart1() {
        int bot = new Day10().part1(new ResourceInput(Day10.class));
        Solve.day(10)
                .part(1)
                .q("What is the number of the bot that is responsible for comparing value-61 microchips with value-17 microchips?")
                .a(bot);
        assertThat(bot).isEqualTo(98);
    }

    @Test
    void solvePart2() {
        int product = new Day10().part2(new ResourceInput(Day10.class));
        Solve.day(10)
                .part(2)
                .q("What do you get if you multiply together the values of one chip in each of outputs 0, 1, and 2?")
                .a(product);
        assertThat(product).isEqualTo(4042);
    }

}