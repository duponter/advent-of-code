package be.edu.adventofcode.y2016.day01;

import java.util.function.Function;

import javaslang.collection.List;

public class Position {
    private final Coordinates coordinates;
    private final Direction direction;

    public Position() {
        this(new Coordinates(0, 0), Direction.NORTH);
    }

    public Position(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Position follow(Instruction instruction) {
        return instruction.parse()
                .left().map(blocks -> move(direction.left(), blocks)).toEither()
                .right().map(blocks -> move(direction.right(), blocks)).toEither()
                .fold(Function.identity(), Function.identity());
    }

    private Position move(Direction direction, int blocks) {
        return new Position(direction.move(blocks).apply(this.coordinates), direction);
    }

    public List<Position> blocks(Instruction instruction) {
        return instruction.parse()
                .left().map(blocks -> blocks(direction.left(), blocks)).toEither()
                .right().map(blocks -> blocks(direction.right(), blocks)).toEither()
                .fold(Function.identity(), Function.identity());
    }

    private List<Position> blocks(Direction direction, int blocks) {
        return List.range(0, blocks).scanLeft(this, (pos, step) -> pos.move(direction, 1)).tail();
    }

    public Coordinates coordinates() {
        return this.coordinates;
    }

    @Override
    public String toString() {
        return String.format("Position{coordinates=%s, direction=%s}", coordinates, direction);
    }
}
