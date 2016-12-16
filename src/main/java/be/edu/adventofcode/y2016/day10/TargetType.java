package be.edu.adventofcode.y2016.day10;

public enum TargetType {
    BOT {
        @Override
        <R> R handle(TargetHandler<R> handler) {
            return handler.whenBot(this);
        }
    },
    OUTPUT {
        @Override
        <R> R handle(TargetHandler<R> handler) {
            return handler.whenOutputBin(this);
        }
    };

    abstract <R> R handle(TargetHandler<R> handler);
}
