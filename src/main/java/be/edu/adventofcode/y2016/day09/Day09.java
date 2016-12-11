package be.edu.adventofcode.y2016.day09;

import be.edu.adventofcode.Input;
import be.edu.adventofcode.y2016.day07.IPAddress;

public class Day09 {
    public int part1(Input input) {
        return new CompressedText(input.text()).decompressedLength();
    }

    public int part2(Input input) {
        return input.lines()
                .map(IPAddress::parse)
                .count(IPAddress::supportsSSL);
    }
}
