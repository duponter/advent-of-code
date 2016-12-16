package be.edu.adventofcode.y2016.day09;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day09Test {
    @Test
    void assertPart1() {
        assertThat(new Day09().part1(new StringInput("ADVENT"))).isEqualTo(6);
        assertThat(new Day09().part1(new StringInput("A(1x5)BC"))).isEqualTo(7);
        assertThat(new Day09().part1(new StringInput("(3x3)XYZ"))).isEqualTo(9);
        assertThat(new Day09().part1(new StringInput("A(2x2)BCD(2x2)EFG"))).isEqualTo(11);
        assertThat(new Day09().part1(new StringInput("(6x1)(1x3)A"))).isEqualTo(6);
        assertThat(new Day09().part1(new StringInput("X(8x2)(3x3)ABCY"))).isEqualTo(18);
    }

    @Test
    void solvePart1() {
        int length = new Day09().part1(new ResourceInput(Day09.class));
        Solve.day(9)
                .part(1)
                .q("What is the decompressed length of the file? Don't count whitespace.")
                .a(length);
        assertThat(length).isEqualTo(152851);
    }

    @Test
    void assertPart2() {
        assertThat(new Day09().part2(new StringInput("(3x3)XYZ"))).isEqualTo(9);
        assertThat(new Day09().part2(new StringInput("X(8x2)(3x3)ABCY"))).isEqualTo(20);
        assertThat(new Day09().part2(new StringInput("(27x12)(20x12)(13x14)(7x10)(1x12)A")))
                .isEqualTo(241920);
        assertThat(new Day09().part2(new StringInput(
                "(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"))).isEqualTo(445);
    }

    @Test
    void solvePart2() {
        long length = new Day09().part2(new ResourceInput(Day09.class));
        Solve.day(9)
                .part(2)
                .q("What is the decompressed length of the file using this improved format?")
                .a(length);
        assertThat(length).isEqualTo(11797310782L);
    }

}