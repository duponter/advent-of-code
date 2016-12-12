package be.edu.adventofcode.y2016.day10;

import static javaslang.API.$;
import static javaslang.API.Case;
import static javaslang.API.Match;

public interface Instruction {
    static Instruction parse(String input) {
        return Match(input).of(
                Case(s -> s.startsWith("value"), ReceiveChip::parse),
                Case(s -> s.startsWith("bot"), DisperseChips::parse),
                Case($(), o -> { throw new IllegalArgumentException(input); })
        );
    }

    <R> R executeWith(InstructionHandler<R> handler);
}
