package be.edu.adventofcode.y2016.day05;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import be.edu.adventofcode.y2016.day04.Room;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Day05Test {
    @Test
    void assertPart1() {
        Assertions.assertThat(new Day05().part1(new StringInput("abc"))).isEqualTo("18f47a30");
    }

    @Test
    void solvePart1() {
        String pw = new Day05().part1(new StringInput("wtnhxymk"));
        Solve.day(5)
                .part(1)
                .q("Given the actual Door ID, what is the password?")
                .a(pw);
    }

    @Test
    @Disabled
    void assertPart2() {
        Assertions.assertThat(Room.parse("qzmt-zixmtkozy-ivhz-343[abcde]").realName()).isEqualTo("very encrypted name");
    }

    @Test
    @Disabled
    void solvePart2() {
        int sectorId = new Day05().part2(new ResourceInput(Day05.class));
        Solve.day(5)
                .part(2)
                .q("What is the sector ID of the room where North Pole objects are stored?")
                .a(sectorId);
    }

}