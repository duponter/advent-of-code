package be.edu.adventofcode.y2016.day10;

public interface TargetHandler<R> {
    R whenBot(TargetType targetType);

    R whenOutputBin(TargetType targetType);
}
