package be.edu.adventofcode.y2016.day08;

import static javaslang.API.$;
import static javaslang.API.Case;
import static javaslang.API.Match;

public interface Operation {
    static Operation parse(String input) {
        return Match(input).of(
                Case(s -> s.startsWith("rect"), LightRectangleOperation::parse),
                Case(s -> s.startsWith("rotate column"), RotateColumnOperation::parse),
                Case(s -> s.startsWith("rotate row"), RotateRowOperation::parse),
                Case($(), o -> { throw new IllegalArgumentException(input); })
        );
    }

    <R> R executeWith(OperationHandler<R> handler);
}
