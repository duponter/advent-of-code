package be.edu.adventofcode.y2016.day02;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Day02Test {
    @Test
    void assertPart1() {
        String input = String.join("\n",
                "ULL",
                "RRDDD",
                "LURDL",
                "UUUUD");
        Assertions.assertThat(new Day02().part1(new StringInput(input))).isEqualTo(1985);
    }

    @Test
    void solvePart1() {
        int code = new Day02().part1(new ResourceInput(Day02.class));
        Solve.day(2)
                .part(1)
                .q("What is the bathroom code?")
                .a(code);
    }

    @Test
    @Disabled
    void assertPart2() {
        Assertions.assertThat(new Day02().part2(new StringInput("R8, R4, R4, R8"))).isEqualTo(4);
    }

    @Test
    @Disabled
    void solvePart2() {
        int blocks = new Day02().part2(new ResourceInput(Day02.class));
        Solve.day(2)
                .part(2)
                .q("How many blocks away is the first location you visit twice?")
                .a(blocks);
    }
}