package be.edu.adventofcode.y2016.day01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javaslang.Function1;
import javaslang.control.Either;

public final class Instruction {
    private static final Pattern PATTERN = Pattern.compile("([LR])(\\d+)");

    private final Side side;
    private final int blocks;

    public Instruction(String value) {
        Matcher matcher = PATTERN.matcher(value.trim());

        if (matcher.matches()) {
            this.side = Side.valueOf(matcher.group(1));
            this.blocks = Integer.valueOf(matcher.group(2));
        } else {
            throw new IllegalArgumentException(String.format("Illegal instruction '%s', expecting [LR]\\d+", value));
        }
    }

    public Either<Integer, Integer> parse() {
        return side.apply(blocks);
    }

    private enum Side implements Function1<Integer, Either<Integer, Integer>> {
        L {
            @Override
            public Either<Integer, Integer> apply(Integer blocks) {
                return Either.left(blocks);
            }
        },
        R {
            @Override
            public Either<Integer, Integer> apply(Integer blocks) {
                return Either.right(blocks);
            }
        }
    }
}
