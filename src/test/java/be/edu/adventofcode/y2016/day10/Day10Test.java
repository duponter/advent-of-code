package be.edu.adventofcode.y2016.day10;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Day10Test {
    @Test
    void assertPart1() {
        String input = String.join("\n",
                "value 5 goes to bot 2",
                "bot 2 gives low to bot 1 and high to bot 0",
                "value 3 goes to bot 1",
                "bot 1 gives low to output 1 and high to bot 0",
                "bot 0 gives low to output 2 and high to output 0",
                "value 2 goes to bot 2");
        Assertions.assertThat(new Day10().part1(new StringInput(input))).isEqualTo(2);
    }

    @Test
    void solvePart1() {
        int count = new Day10().part1(new ResourceInput(Day10.class));
        Solve.day(10)
                .part(1)
                .q("What is the number of the bot that is responsible for comparing value-61 microchips with value-17 microchips?")
                .a(count);
    }

    @Test
    @Disabled
    void assertPart2() {
        String input = String.join("\n",
                "aba[bab]xyz",
                "xyx[xyx]xyx",
                "aaa[kek]eke",
                "zazbz[bzb]cdb");
        Assertions.assertThat(new Day10().part2(new StringInput(input))).isEqualTo(3);
    }

    @Test
    @Disabled
    void solvePart2() {
        int count = new Day10().part2(new ResourceInput(Day10.class));
        Solve.day(10)
                .part(2)
                .q("How many IPs in your puzzle input support SSL?")
                .a(count);
    }

}