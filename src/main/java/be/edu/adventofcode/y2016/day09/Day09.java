package be.edu.adventofcode.y2016.day09;

import be.edu.adventofcode.Input;

public class Day09 {
    public int part1(Input input) {
        return new CompressedText(input.text()).decompressedLength();
    }

    public long part2(Input input) {
        return new ImprovedCompressedText(input.text()).decompressedLength();
    }
}
