package be.edu.adventofcode.y2016.day01;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day01Test {
    @Test
    public void assertPart1() {
        Assertions.assertThat(new Day01().part1(new StringInput("R2, L3"))).isEqualTo(5);
        Assertions.assertThat(new Day01().part1(new StringInput("R2, R2, R2"))).isEqualTo(2);
        Assertions.assertThat(new Day01().part1(new StringInput("R5, L5, R5, R3"))).isEqualTo(12);
    }

    @Test
    public void solvePart1() {
        int blocks = new Day01().part1(new ResourceInput(Day01.class));
        Solve.day(1)
                .part(1)
                .q("How many blocks away is Easter Bunny HQ?")
                .a(blocks);
    }
}