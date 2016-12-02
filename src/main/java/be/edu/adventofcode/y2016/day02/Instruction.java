package be.edu.adventofcode.y2016.day02;

import java.util.function.Function;

public enum Instruction {
    U(Navigable::up),
    D(Navigable::down),
    L(Navigable::left),
    R(Navigable::right);

    private Function<Navigable, Navigable> move;

    Instruction(Function<Navigable, Navigable> move) {
        this.move = move;
    }

    public Navigable apply(Navigable numPad) {
        return this.move.apply(numPad);
    }
}
