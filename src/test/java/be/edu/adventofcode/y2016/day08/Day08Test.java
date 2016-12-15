package be.edu.adventofcode.y2016.day08;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day08Test {
    @Test
    void solvePart1() {
        int count = new Day08().part1(new ResourceInput(Day08.class));
        Solve.day(8)
                .part(1)
                .q("How many pixels should be lit?")
                .a(count);
        assertThat(count).isEqualTo(116);
    }

    @Test
    void solvePart2() {
        String display = new Day08().part2(new ResourceInput(Day08.class));
        Solve.day(8)
                .part(2)
                .q("What code is the screen trying to display?")
                .a("UPOJFLBCEZ\n" + display);
    }

}