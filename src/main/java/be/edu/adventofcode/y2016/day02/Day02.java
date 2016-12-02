package be.edu.adventofcode.y2016.day02;

import javaslang.collection.CharSeq;

import be.edu.adventofcode.Input;

public class Day02 {
    public int part1(Input input) {
        return Integer.valueOf(input.lines()
                .scanLeft(new NumPad(), this::executeInstructions)
                .tail()
                .map(numPad -> Integer.toString(numPad.currentButton()))
                .foldLeft("", (s1, s2) -> s1 + s2));
    }

    private NumPad executeInstructions(NumPad start, String line) {
        return CharSeq.of(line)
                .map(character -> Instruction.valueOf(character.toString()))
                .foldLeft(start, (numpad, instruction) -> instruction.apply(numpad));
    }

    public int part2(Input input) {
        return 0;
    }
}
