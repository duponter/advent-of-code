package be.edu.adventofcode.y2016.day08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LightRectangleOperation implements Operation {
    private static final Pattern PATTERN = Pattern.compile("rect (\\d+)x(\\d+)");

    private final int cols;
    private final int rows;

    public static Operation parse(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(input);
        }
        return new LightRectangleOperation(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));

    }

    private LightRectangleOperation(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    @Override
    public <R> R executeWith(OperationHandler<R> handler) {
        return handler.createRectangle(cols, rows);
    }
}
