package be.edu.adventofcode.y2016.day10;

import java.util.function.IntFunction;

public enum TargetType implements IntFunction<Target> {
    BOT {
        @Override
        public Target apply(int value) {
            return new Bot(value);
        }
    },
    OUTPUT {
        @Override
        public Target apply(int value) {
            return new Output(value);
        }
    };
}
