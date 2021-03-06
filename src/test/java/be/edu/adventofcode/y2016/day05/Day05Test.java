package be.edu.adventofcode.y2016.day05;

import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Day05Test {
    @Test
    void assertPart1() {
        Assertions.assertThat(new Day05().part1(new StringInput("abc"))).isEqualTo("18f47a30");
    }

    @Test
    @Disabled
    void solvePart1() {
        String pw = new Day05().part1(new StringInput("wtnhxymk"));
        Solve.day(5)
                .part(1)
                .q("Given the actual Door ID, what is the password?")
                .a(pw);
    }

    @Test
    void assertPart2() {
        Assertions.assertThat(new Day05().part2(new StringInput("abc"))).isEqualTo("05ace8e3");
    }

    @Test
    void solvePart2() {
        String pw = new Day05().part2(new StringInput("wtnhxymk"));
        Solve.day(5)
                .part(2)
                .q("Given the actual Door ID and this new method, what is the password?")
                .a(pw);
    }

}