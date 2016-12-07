package be.edu.adventofcode.y2016.day06;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day06Test {
    @Test
    void assertPart1() {
        String input = String.join("\n",
                "eedadn",
                "drvtee",
                "eandsr",
                "raavrd",
                "atevrs",
                "tsrnev",
                "sdttsa",
                "rasrtv",
                "nssdts",
                "ntnada",
                "svetve",
                "tesnvt",
                "vntsnd",
                "vrdear",
                "dvrsen",
                "enarar");
        Assertions.assertThat(new Day06().part1(new StringInput(input))).isEqualTo("easter");
    }

    @Test
    void solvePart1() {
        String msg = new Day06().part1(new ResourceInput(Day06.class));
        Solve.day(6)
                .part(1)
                .q("What is the error-corrected version of the message being sent?")
                .a(msg);
    }

    @Test
    void assertPart2() {
        String input = String.join("\n",
                "eedadn",
                "drvtee",
                "eandsr",
                "raavrd",
                "atevrs",
                "tsrnev",
                "sdttsa",
                "rasrtv",
                "nssdts",
                "ntnada",
                "svetve",
                "tesnvt",
                "vntsnd",
                "vrdear",
                "dvrsen",
                "enarar");
        Assertions.assertThat(new Day06().part2(new StringInput(input))).isEqualTo("advent");
    }

    @Test
    void solvePart2() {
        String msg = new Day06().part2(new ResourceInput(Day06.class));
        Solve.day(6)
                .part(2)
                .q("Given  this new decoding methodology, what is the original message that Santa is trying to send?")
                .a(msg);
    }

}