package be.edu.adventofcode.y2016.day09;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Day09Test {
    @Test
    void assertPart1() {
        Assertions.assertThat(new Day09().part1(new StringInput("ADVENT"))).isEqualTo(6);
        Assertions.assertThat(new Day09().part1(new StringInput("A(1x5)BC"))).isEqualTo(7);
        Assertions.assertThat(new Day09().part1(new StringInput("(3x3)XYZ"))).isEqualTo(9);
        Assertions.assertThat(new Day09().part1(new StringInput("A(2x2)BCD(2x2)EFG"))).isEqualTo(11);
        Assertions.assertThat(new Day09().part1(new StringInput("(6x1)(1x3)A"))).isEqualTo(6);
        Assertions.assertThat(new Day09().part1(new StringInput("X(8x2)(3x3)ABCY"))).isEqualTo(18);
    }

    @Test
    void solvePart1() {
        int length = new Day09().part1(new ResourceInput(Day09.class));
        Solve.day(9)
                .part(1)
                .q("What is the decompressed length of the file? Don't count whitespace.")
                .a(length);
    }

    @Test
    @Disabled
    void assertPart2() {
        String input = String.join("\n",
                "aba[bab]xyz",
                "xyx[xyx]xyx",
                "aaa[kek]eke",
                "zazbz[bzb]cdb");
        Assertions.assertThat(new Day09().part2(new StringInput(input))).isEqualTo(3);
    }

    @Test
    @Disabled
    void solvePart2() {
        int count = new Day09().part2(new ResourceInput(Day09.class));
        Solve.day(9)
                .part(2)
                .q("How many IPs in your puzzle input support SSL?")
                .a(count);
    }

}