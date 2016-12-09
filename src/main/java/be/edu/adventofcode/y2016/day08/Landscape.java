package be.edu.adventofcode.y2016.day08;

import javaslang.collection.Array;

public class Landscape extends Layout {
    public Landscape(Array<Array<Pixel>> pixels) {
        super(pixels);
    }

    @Override
    public Layout createRectangle(int cols, int rows) {
        return null;
    }

    @Override
    public Layout rotateDown(int col, int step) {
        return null;
    }

    @Override
    public Layout rotateRight(int row, int step) {
        return null;
    }
}
