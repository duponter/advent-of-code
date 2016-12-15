package be.edu.adventofcode.y2016.day10;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisperseChips implements Instruction {
    private static final Pattern PATTERN = Pattern.compile(
            "bot (\\d+) gives low to (bot|output) (\\d+) and high to (bot|output) (\\d+)");

    private final int givingBot;
    private final Function<Factory, IntFunction<Target>> forLowerValueChip;
    private final Function<Factory, IntFunction<Target>> forHigherValueChip;

    public static DisperseChips parse(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(input);
        }

        int givingBot = Integer.parseInt(matcher.group(1));
        TargetType lowChipTargetType = TargetType.valueOf(matcher.group(2).toUpperCase());
        int lowChipTargetId = Integer.parseInt(matcher.group(3));
        TargetType highChipTargetType = TargetType.valueOf(matcher.group(4).toUpperCase());
        int highChipTargetId = Integer.parseInt(matcher.group(5));
        return new DisperseChips(givingBot,
                factory -> l -> new ReceiveChip(l, lowChipTargetType, lowChipTargetId).apply(factory),
                factory -> h -> new ReceiveChip(h, highChipTargetType, highChipTargetId).apply(factory));
    }

    private DisperseChips(int givingBot, Function<Factory, IntFunction<Target>> forLowerValueChip, Function<Factory, IntFunction<Target>> forHigherValueChip) {
        this.givingBot = givingBot;
        this.forLowerValueChip = forLowerValueChip;
        this.forHigherValueChip = forHigherValueChip;
    }

    @Override
    public Target apply(Factory factory) {
        Bot bot = factory.bot(givingBot);
        bot.instruct(forLowerValueChip.apply(factory), forHigherValueChip.apply(factory));
        return bot;
    }
}
