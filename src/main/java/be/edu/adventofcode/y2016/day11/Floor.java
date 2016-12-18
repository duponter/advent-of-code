package be.edu.adventofcode.y2016.day11;

import javaslang.collection.List;

public class Floor implements Container {
    private final int number;
    private final List<Component> content;

    public Floor(int number, Component... content) {
        this.number = number;
        this.content = List.of(content);
    }

    public int number() {
        return number;
    }

    @Override
    public List<Component> content() {
        return this.content;
    }

    @Override
    public String toString() {
        return String.format("F%d", number);
    }
}
