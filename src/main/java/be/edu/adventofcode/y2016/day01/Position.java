package be.edu.adventofcode.y2016.day01;

import java.util.function.Function;

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

    public int blocks() {
        return this.coordinates.blocks();
    }

    @Override
    public String toString() {
        return String.format("Position{coordinates=%s, direction=%s}", coordinates, direction);
    }
}
