package be.edu.adventofcode.y2016.day03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Triangle {
    public static final Pattern PATTERN = Pattern.compile("\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)");
    private final int sideLength1;
    private final int sideLength2;
    private final int sideLength3;

    public static Triangle parse(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(input);
        }
        return new Triangle(Integer.parseInt(matcher.group(1)),Integer.parseInt(matcher.group(2)),Integer.parseInt(matcher.group(3)));
    }

    public Triangle(int sideLength1, int sideLength2, int sideLength3) {
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
        this.sideLength3 = sideLength3;
    }

    public boolean isInequal() {
        return sideLength1 + sideLength2 <= sideLength3
                || sideLength1 + sideLength3 <= sideLength2
                || sideLength2 + sideLength3 <= sideLength1;
    }
}
