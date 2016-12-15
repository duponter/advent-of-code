package be.edu.adventofcode.y2016.day10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiveChip implements Instruction {
    private static final Pattern PATTERN = Pattern.compile("value (\\d+) goes to (bot|output) (\\d+)");

    private final int chip;
    private final TargetType targetType;
    private final int targetId;

    public static ReceiveChip parse(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(input);
        }

        return new ReceiveChip(Integer.parseInt(matcher.group(1)),
                TargetType.valueOf(matcher.group(2).toUpperCase()),
                Integer.parseInt(matcher.group(3)));

    }

    protected ReceiveChip(int chip, TargetType targetType, int targetId) {
        this.chip = chip;
        this.targetType = targetType;
        this.targetId = targetId;
    }

    @Override
    public Target apply(Factory factory) {
        Target target = targetType.handle(factory).apply(targetId);
        target.receiveChip(chip);
        return target;
    }
}
