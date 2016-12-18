package be.edu.adventofcode.y2016.day11;

import javaslang.collection.List;

public class Elevator implements Container {
    private int steps = 0;
    private int onFloor = 1;
    private List<Component> content;

    public Elevator() {
        this(List.empty());
    }

    public Elevator(Component first) {
        this(List.of(first));
    }

    public Elevator(Component first, Component second) {
        this(List.of(first, second));
    }

    private Elevator(List<Component> content) {
        this.content = content;
    }

    public void up() {
        onFloor++;
        steps++;
    }

    public void down() {
        onFloor--;
        steps++;
    }

    @Override
    public List<Component> content() {
        return this.content;
    }

    public String print(Floor floor) {
        return floor.number() == onFloor ? this.toString() : ".";
    }
    @Override
    public String toString() {
        return "E";
    }
}
