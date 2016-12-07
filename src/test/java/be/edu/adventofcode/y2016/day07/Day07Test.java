package be.edu.adventofcode.y2016.day07;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day07Test {
    @Test
    void assertPart1() {
        String input = String.join("\n",
                "abba[mnop]qrst",
                "abcd[bddb]xyyx",
                "aaaa[qwer]tyui",
                "ioxxoj[asdfgh]zxcvbn");
        Assertions.assertThat(new Day07().part1(new StringInput(input))).isEqualTo(2);
    }

    @Test
    void solvePart1() {
        int count = new Day07().part1(new ResourceInput(Day07.class));
        Solve.day(7)
                .part(1)
                .q("How many IPs in your puzzle input support TLS?")
                .a(count);
    }

    @Test
    void assertPart2() {
        String input = String.join("\n",
                "abba[mnop]qrst",
                "abcd[bddb]xyyx",
                "aaaa[qwer]tyui",
                "ioxxoj[asdfgh]zxcvbn");
        Assertions.assertThat(new Day07().part2(new StringInput(input))).isEqualTo(0);
    }

    @Test
    void solvePart2() {
        int sectorId = new Day07().part2(new ResourceInput(Day07.class));
        Solve.day(7)
                .part(2)
                .q("What is the sector ID of the room where North Pole objects are stored?")
                .a(sectorId);
    }

}