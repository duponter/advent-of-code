package be.edu.adventofcode.y2016.day08;

public class Portrait extends Layout {
    public Portrait(Screen screen) {
        super(screen);
    }

    @Override
    public Layout createRectangle(int cols, int rows) {
        this.screen().light(rows, cols);
        return this;
    }

    @Override
    public Layout rotateDown(int col, int step) {
        return new Portrait(screen().rotate(col, step));
    }

    @Override
    public Layout rotateRight(int row, int step) {
        return new Landscape(screen().transpose()).rotateRight(row, step);
    }
}
