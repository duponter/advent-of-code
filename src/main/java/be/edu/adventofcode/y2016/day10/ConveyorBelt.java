package be.edu.adventofcode.y2016.day10;

import java.util.function.IntFunction;
import java.util.function.Predicate;

import javaslang.control.Option;

public class ConveyorBelt implements InstructionHandler<Boolean> {
    private final Factory factory;
    private boolean running = false;

    public ConveyorBelt(Factory factory) {
        this.factory = factory;
    }

    public Option<Bot> start() {
        running = true;
        this.factory.botsWith2Chips().head().start().test(this);
        return this.factory.botsWith2Chips().headOption();
    }

    @Override
    public Boolean receiveChip(int chip, TargetType type, int targetId) {
        Predicate<ConveyorBelt> beltPredicate = type.handle(this.factory).apply(targetId).receiveChip(chip);
        return !running || beltPredicate.test(this);
    }

    @Override
    public Boolean disperseChips(int givingBot, IntFunction<ReceiveChip> forLowerValueChip, IntFunction<ReceiveChip> forHigherValueChip) {
        this.factory.bot(givingBot).instruct(forLowerValueChip, forHigherValueChip);
        return true;
    }
}
