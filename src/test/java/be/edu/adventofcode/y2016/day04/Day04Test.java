package be.edu.adventofcode.y2016.day04;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;
import be.edu.adventofcode.StringInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day04Test {
    @Test
    void assertPart1() {
        String input = String.join("\n",
                "aaaaa-bbb-z-y-x-123[abxyz]",
                "a-b-c-d-e-f-g-h-987[abcde]",
                "not-a-real-room-404[oarel]",
                "totally-real-room-200[decoy]");
        Assertions.assertThat(new Day04().part1(new StringInput(input))).isEqualTo(1514);
    }

    @Test
    void solvePart1() {
        int sum = new Day04().part1(new ResourceInput(Day04.class));
        Solve.day(4)
                .part(1)
                .q("What is the sum of the sector IDs of the real rooms?")
                .a(sum);
    }

    @Test
    void assertPart2() {
        Assertions.assertThat(Room.parse("qzmt-zixmtkozy-ivhz-343[abcde]").realName()).isEqualTo("very encrypted name");
    }

    @Test
    void solvePart2() {
        int sectorId = new Day04().part2(new ResourceInput(Day04.class));
        Solve.day(4)
                .part(2)
                .q("What is the sector ID of the room where North Pole objects are stored?")
                .a(sectorId);
    }

}