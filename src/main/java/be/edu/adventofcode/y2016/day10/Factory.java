package be.edu.adventofcode.y2016.day10;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import javaslang.collection.List;

public class Factory implements TargetHandler<IntFunction<Target>> {
    private final Map<Integer, Bot> bots = new HashMap<>();
    private final Map<Integer, OutputBin> outputBins = new HashMap<>();

    public int product() {
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

    public List<Bot> botsWith2Chips() {
        return List.ofAll(bots.values().stream().filter(bot -> bot.chipCount() == 2).collect(Collectors.toList()));
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
