package be.edu.adventofcode.y2016.day01;

import java.util.function.Function;

public enum Direction {
    NORTH {
        @Override
        Direction left() {
            return WEST;
        }

        @Override
        Direction right() {
            return EAST;
        }

        @Override
        Function<Coordinates, Coordinates> move(int blocks) {
            return coordinates -> coordinates.moveVertical(blocks);
        }
    },
    EAST {
        @Override
        Direction left() {
            return NORTH;
        }

        @Override
        Direction right() {
            return SOUTH;
        }

        @Override
        Function<Coordinates, Coordinates> move(int blocks) {
            return coordinates -> coordinates.moveHorizontal(blocks);
        }
    },
    SOUTH {
        @Override
        Direction left() {
            return EAST;
        }

        @Override
        Direction right() {
            return WEST;
        }

        @Override
        Function<Coordinates, Coordinates> move(int blocks) {
            return coordinates -> coordinates.moveVertical(-blocks);
        }
    },
    WEST {
        @Override
        Direction left() {
            return SOUTH;
        }

        @Override
        Direction right() {
            return NORTH;
        }

        @Override
        Function<Coordinates, Coordinates> move(int blocks) {
            return coordinates -> coordinates.moveHorizontal(-blocks);
        }
    };

    abstract Direction left();
    abstract Direction right();
    abstract Function<Coordinates, Coordinates> move(int blocks);
}
