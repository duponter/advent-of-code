package be.edu.adventofcode.y2016.day10;

import java.util.function.Function;

import static javaslang.API.$;
import static javaslang.API.Case;
import static javaslang.API.Match;

public interface Instruction extends Function<Factory, Target> {
    static Instruction parse(String input) {
        return Match(input).of(
                Case(s -> s.startsWith("value"), ReceiveChip::parse),
                Case(s -> s.startsWith("bot"), DisperseChips::parse),
                Case($(), o -> { throw new IllegalArgumentException(input); })
        );
    }
}
