package be.edu.adventofcode.y2016.day10;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;

import javaslang.collection.List;

public class Factory implements TargetHandler<IntFunction<Target>> {
    private final Map<Integer, Bot> bots = new HashMap<>();
    private final Map<Integer, OutputBin> outputBins = new HashMap<>();

    public Bot workUntilChips17And61() {
        bots.values().stream().anyMatch(bot -> bot.workUntil((low, high) -> low == 17 && high == 61));

        return List.ofAll(bots.values())
                .filter(Bot::containsPairOfChips)
                .head();
    }

    public int product() {
        List.ofAll(bots.values()).forEach(bot -> bot.workUntil((low, high) -> false));
        return outputBin(0).chip().getOrElseThrow(IllegalStateException::new)
                * outputBin(1).chip().getOrElseThrow(IllegalStateException::new)
                * outputBin(2).chip().getOrElseThrow(IllegalStateException::new);
    }

    public Bot bot(int id) {
        return bots.computeIfAbsent(id, Bot::new);
    }

    public OutputBin outputBin(int id) {
        return outputBins.computeIfAbsent(id, OutputBin::new);
    }

    @Override
    public IntFunction<Target> whenBot(TargetType targetType) {
        return this::bot;
    }

    @Override
    public IntFunction<Target> whenOutputBin(TargetType targetType) {
        return this::outputBin;
    }
}
