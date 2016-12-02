package be.edu.adventofcode.y2016.day02;

import java.util.function.Function;

public enum Instruction {
    U(NumPad::up),
    D(NumPad::down),
    L(NumPad::left),
    R(NumPad::right);

    private Function<NumPad, NumPad> move;

    Instruction(Function<NumPad, NumPad> move) {
        this.move = move;
    }

    public NumPad apply(NumPad numPad) {
        return this.move.apply(numPad);
    }
}
