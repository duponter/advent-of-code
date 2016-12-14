package be.edu.adventofcode.y2016.day10;

import java.util.function.IntFunction;

public interface InstructionHandler<R> {
    R receiveChip(int chip, TargetType type, int targetId);

    R disperseChips(int givingBot, IntFunction<ReceiveChip> forLowerValueChip, IntFunction<ReceiveChip> forHigherValueChip);
}
