package be.edu.adventofcode.y2016.day11;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import be.edu.adventofcode.y2016.day04.Room;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day11Test {
    @Test
    void assertPart1() {
        String input = String.join("\n",
                "F4 .  .  .  .  .  " +
                "F3 .  .  .  LG .  " +
                "F2 .  HG .  .  .  " +
                "F1 E  .  HM .  LM ");
        assertThat(new Day11().part1(new StringInput(input))).isEqualTo(11);
    }

    @Test
    void solvePart1() {
        int steps = new Day11().part1(new ResourceInput(Day11.class));
        Solve.day(11)
                .part(1)
                .q("What is the minimum number of steps required to bring all of the objects to the fourth floor?")
                .a(steps);
        assertThat(steps).isEqualTo(0);
    }

    @Test
    @Disabled
    void assertPart2() {
        assertThat(Room.parse("qzmt-zixmtkozy-ivhz-343[abcde]").realName()).isEqualTo("very encrypted name");
    }

    @Test
    @Disabled
    void solvePart2() {
        int sectorId = new Day11().part2(new ResourceInput(Day11.class));
        Solve.day(11)
                .part(2)
                .q("What is the sector ID of the room where North Pole objects are stored?")
                .a(sectorId);
        assertThat(sectorId).isEqualTo(0);
    }

}