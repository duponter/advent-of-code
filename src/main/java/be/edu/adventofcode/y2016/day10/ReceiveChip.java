package be.edu.adventofcode.y2016.day10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiveChip implements Instruction {
    private static final Pattern PATTERN = Pattern.compile("value (\\d+) goes to (bot|output) (\\d+)");

    private final int chip;
    private final Target target;

    public static ReceiveChip parse(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(input);
        }

        TargetType targetType = TargetType.valueOf(matcher.group(2).toUpperCase());
        return new ReceiveChip(Integer.parseInt(matcher.group(1)),
                targetType.apply(Integer.parseInt(matcher.group(3))));

    }

    protected ReceiveChip(int chip, Target target) {
        this.chip = chip;
        this.target = target;
    }

    @Override
    public <R> R executeWith(InstructionHandler<R> handler) {
        return handler.receiveChip(chip, target);
    }
}
