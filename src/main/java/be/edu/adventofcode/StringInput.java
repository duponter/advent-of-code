package be.edu.adventofcode;

import java.util.Arrays;

import javaslang.collection.CharSeq;
import javaslang.collection.List;

public class StringInput implements Input {
    private final String input;

    public StringInput(String input) {
        this.input = input;
    }

    @Override
    public String text() {
        return this.input;
    }

    @Override
    public String joined(String separator) {
        return this.input;
    }

    @Override
    public CharSeq chars() {
        return CharSeq.of(this.input);
    }

    @Override
    public List<String> lines() {
        return List.ofAll(Arrays.asList(this.input.split("\n")));
    }
}
