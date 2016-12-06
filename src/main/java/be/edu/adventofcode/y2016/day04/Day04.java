package be.edu.adventofcode.y2016.day04;

import be.edu.adventofcode.Input;

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
        return input.lines()
                .map(Room::parse)
                .filter(Room::isReal)
                .find(room -> room.realName().contains("northpole"))
                .map(Room::sectorId)
                .getOrElseThrow(IllegalStateException::new);
    }
}
