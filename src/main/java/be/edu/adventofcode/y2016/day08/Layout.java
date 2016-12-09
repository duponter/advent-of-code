package be.edu.adventofcode.y2016.day08;

import javaslang.collection.Array;

public abstract class Layout implements OperationHandler<Layout> {
    private final Array<Array<Pixel>> pixels;

    protected Layout(Array<Array<Pixel>> pixels) {
        this.pixels = pixels;
    }

    protected <T> Array<Array<T>> transpose(Array<Array<T>> array2d) {
        return Array.tabulate(array2d.get().size(), row ->
                Array.tabulate(array2d.size(), col -> array2d.get(col).get(row)));
    }

    protected <T> Array<T> rotate(Array<T> array, int step) {
        return array.takeRight(step).appendAll(array.dropRight(step));
    }
}
