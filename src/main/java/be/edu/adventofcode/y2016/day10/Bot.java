package be.edu.adventofcode.y2016.day10;

import java.util.function.IntFunction;

public class Bot implements Target {
    private final int number;
    private Chips chips = new None();
    private IntFunction<Target> giveLowChip;
    private IntFunction<Target> giveHighChip;

    public Bot(int number) {
        this.number = number;
        this.giveLowChip = noInstruction(number);
        this.giveHighChip = noInstruction(number);
    }

    private static IntFunction<Target> noInstruction(int bot) {
        return value -> {
            throw new IllegalStateException("No instructions set on bot " + bot);
        };
    }

    @Override
    public int number() {
        return this.number;
    }

    public boolean containsPairOfChips() {
        return this.chips.match(new HasPair());
    }

    @Override
    public boolean workUntil(Work work) {
        return this.chips.match((Work) (low, high) -> work.whenPair(low, high) || passChips(low, high, work));
    }

    private boolean passChips(int lowValue, int highValue, Work work) {
        boolean result = this.giveLowChip.apply(lowValue).workUntil(work) &
                            this.giveHighChip.apply(highValue).workUntil(work);
        this.chips = new None();
        return result;
    }

    @Override
    public void receiveChip(int chipValue) {
        this.chips = this.chips.match(new AddChip(chipValue));
    }

    public void instruct(IntFunction<Target> giveLowChip, IntFunction<Target> giveHighChip) {
        this.giveLowChip = giveLowChip;
        this.giveHighChip = giveHighChip;
    }
}
