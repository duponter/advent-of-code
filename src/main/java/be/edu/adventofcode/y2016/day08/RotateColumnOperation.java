package be.edu.adventofcode.y2016.day08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RotateColumnOperation implements Operation {
    private static final Pattern PATTERN = Pattern.compile("rotate column x=(\\d+) by (\\d+)");

    private final int column;
    private final int step;

    public static Operation parse(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(input);
        }
        return new RotateColumnOperation(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));

    }

    private RotateColumnOperation(int column, int step) {
        this.column = column;
        this.step = step;
    }

    @Override
    public <R> R executeWith(OperationHandler<R> handler) {
        return handler.rotateDown(column, step);
    }
}
