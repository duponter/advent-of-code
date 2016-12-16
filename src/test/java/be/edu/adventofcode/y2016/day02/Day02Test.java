package be.edu.adventofcode.y2016.day02;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day02Test {
    @Test
    void assertPart1() {
        String input = String.join("\n",
                "ULL",
                "RRDDD",
                "LURDL",
                "UUUUD");
        assertThat(new Day02().part1(new StringInput(input))).isEqualTo(1985);
    }

    @Test
    void solvePart1() {
        int code = new Day02().part1(new ResourceInput(Day02.class));
        Solve.day(2)
                .part(1)
                .q("What is the bathroom code?")
                .a(code);
        assertThat(code).isEqualTo(65556);
    }

    @Test
    void assertPart2() {
        String input = String.join("\n",
                "ULL",
                "RRDDD",
                "LURDL",
                "UUUUD");
        assertThat(new Day02().part2(new StringInput(input))).isEqualTo("5DB3");
    }

    @Test
    void solvePart2() {
        String code = new Day02().part2(new ResourceInput(Day02.class));
        Solve.day(2)
                .part(2)
                .q("What is the correct bathroom code?")
                .a(code);
        assertThat(code).isEqualTo("CB779");
    }
}