package be.edu.adventofcode.y2016.day03;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day03Test {
    @Test
    void assertPart1() {
        assertThat(new Day03().part1(new StringInput("5 10 25\n5 10 15\n     5 10   10"))).isEqualTo(1);
    }

    @Test
    void solvePart1() {
        int count = new Day03().part1(new ResourceInput(Day03.class));
        Solve.day(3)
                .part(1)
                .q("How many of the listed triangles are possible?")
                .a(count);
        assertThat(count).isEqualTo(1050);
    }

    @Test
    void assertPart2() {
        String input = String.join("\n",
                "101 301 501",
                "102 302 502",
                "103 303 503",
                "201 401 601",
                "202 402 602",
                "203 403 603");
        assertThat(new Day03().part2(new StringInput(input))).isEqualTo(6);
    }

    @Test
    void solvePart2() {
        int count = new Day03().part2(new ResourceInput(Day03.class));
        Solve.day(3)
                .part(2)
                .q("Reading by columns, how many of the listed triangles are possible?")
                .a(count);
        assertThat(count).isEqualTo(1921);
    }
}