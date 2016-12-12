package be.edu.adventofcode.y2016.day10;

import java.util.function.IntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisperseChips implements Instruction {
    private static final Pattern PATTERN = Pattern.compile("bot (\\d+) gives low to (bot|output) (\\d+) and high to (bot|output) (\\d+)");

    private final int givingBot;
    private final IntFunction<ReceiveChip> forLowerValueChip;
    private final IntFunction<ReceiveChip> forHigherValueChip;

    public static DisperseChips parse(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(input);
        }

        int givingBot = Integer.parseInt(matcher.group(1));
        Target lowChipTarget = TargetType.valueOf(matcher.group(2).toUpperCase()).apply(Integer.parseInt(matcher.group(3)));
        Target highChipTarget = TargetType.valueOf(matcher.group(4).toUpperCase()).apply(Integer.parseInt(matcher.group(5)));
        return new DisperseChips(givingBot, l -> new ReceiveChip(l, lowChipTarget), h -> new ReceiveChip(h, highChipTarget));

    }

    private DisperseChips(int givingBot, IntFunction<ReceiveChip> forLowerValueChip, IntFunction<ReceiveChip> forHigherValueChip) {
        this.givingBot = givingBot;
        this.forLowerValueChip = forLowerValueChip;
        this.forHigherValueChip = forHigherValueChip;
    }

    @Override
    public <R> R executeWith(InstructionHandler<R> handler) {
        return handler.disperseChips(givingBot, forLowerValueChip, forHigherValueChip);
    }
}
