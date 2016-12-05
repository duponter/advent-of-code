package be.edu.adventofcode.y2016.day04;

import be.edu.adventofcode.Input;
import be.edu.adventofcode.StringInput;

public class Day04 {
    public int part1(Input input) {
        return input.lines()
                .map(Room::parse)
                .filter(Room::isReal)
                .map(Room::sectorId)
                .sum()
                .intValue();
    }

    public int part2(Input input) {
        return 0;
    }

    public static void main(String[] args) {
        String input = String.join("\n",
                "aaaaa-bbb-z-y-x-123[abxyz]",
                "a-b-c-d-e-f-g-h-987[abcde]",
                "not-a-real-room-404[oarel]",
                "totally-real-room-200[decoy]");
        System.out.println(new Day04().part1(new StringInput(input)));

    }
}
