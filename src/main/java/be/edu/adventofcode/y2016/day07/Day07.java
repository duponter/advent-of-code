package be.edu.adventofcode.y2016.day07;

import be.edu.adventofcode.Input;

public class Day07 {
    public int part1(Input input) {
        return input.lines()
                .map(IPAddress::parse)
                .count(IPAddress::supportsTLS);
    }

    public int part2(Input input) {
        return input.lines()
                .map(IPAddress::parse)
                .count(IPAddress::supportsSSL);
    }
}
