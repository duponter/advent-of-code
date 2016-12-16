package be.edu.adventofcode.y2016.day07;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day07Test {
    @Test
    void assertPart1() {
        String input = String.join("\n",
                "abba[mnop]qrst",
                "abcd[bddb]xyyx",
                "aaaa[qwer]tyui",
                "ioxxoj[asdfgh]zxcvbn");
        assertThat(new Day07().part1(new StringInput(input))).isEqualTo(2);
    }

    @Test
    void solvePart1() {
        int count = new Day07().part1(new ResourceInput(Day07.class));
        Solve.day(7)
                .part(1)
                .q("How many IPs in your puzzle input support TLS?")
                .a(count);
        assertThat(count).isEqualTo(115);
    }

    @Test
    void assertPart2() {
        String input = String.join("\n",
                "aba[bab]xyz",
                "xyx[xyx]xyx",
                "aaa[kek]eke",
                "zazbz[bzb]cdb");
        assertThat(new Day07().part2(new StringInput(input))).isEqualTo(3);
    }

    @Test
    void solvePart2() {
        int count = new Day07().part2(new ResourceInput(Day07.class));
        Solve.day(7)
                .part(2)
                .q("How many IPs in your puzzle input support SSL?")
                .a(count);
        assertThat(count).isEqualTo(231);
    }

}