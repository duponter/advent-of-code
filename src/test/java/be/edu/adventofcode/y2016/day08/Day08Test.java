package be.edu.adventofcode.y2016.day08;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Day08Test {
    @Test
    void solvePart1() {
        int count = new Day08().part1(new ResourceInput(Day08.class));
        Solve.day(8)
                .part(1)
                .q("How many pixels should be lit?")
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
        Assertions.assertThat(new Day08().part2(new StringInput(input))).isEqualTo(3);
    }

    @Test
    @Disabled
    void solvePart2() {
        int count = new Day08().part2(new ResourceInput(Day08.class));
        Solve.day(8)
                .part(2)
                .q("How many IPs in your puzzle input support SSL?")
                .a(count);
    }

}