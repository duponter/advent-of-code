package be.edu.adventofcode.y2016.day08;

import java.util.function.Function;

import javaslang.collection.Array;

public class Screen {
    private final Array<Array<Pixel>> pixels;

    public Screen() {
        this(Array.tabulate(6, row -> Array.tabulate(50, col -> new Pixel())));
    }

    private Screen(Array<Array<Pixel>> pixels) {
        this.pixels = pixels;
    }

    public int countLitPixels() {
        return this.pixels
                .flatMap(Function.identity())
                .count(Pixel::isLit);
    }

    public Screen light(int cols, int rows) {
        this.pixels.take(rows)
                .forEach(row -> row.take(cols)
                        .forEach(Pixel::turnOn));
        return this;
    }

    public Screen rotate(int row, int step) {
        Array<Pixel> rotatedRow = this.pixels.get(row);
        return new Screen(this.pixels.replace(rotatedRow, this.rotate(rotatedRow, step)));
    }

    private <T> Array<T> rotate(Array<T> array, int step) {
        return array.takeRight(step).appendAll(array.dropRight(step));
    }

    public Screen transpose() {
        return new Screen(
                Array.tabulate(this.pixels.get().size(), row ->
                        Array.tabulate(this.pixels.size(), col -> this.pixels.get(col).get(row))
                )
        );
    }

    @Override
    public String toString() {
        return this.pixels.map(Array::mkString).mkString("\n");
    }
}
