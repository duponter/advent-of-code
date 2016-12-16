package be.edu.adventofcode.y2016.day08;

public class Landscape extends Layout {
    public Landscape(Screen screen) {
        super(screen);
    }

    @Override
    public Layout createRectangle(int cols, int rows) {
        screen().light(cols, rows);
        return this;
    }

    @Override
    public Layout rotateDown(int col, int step) {
        return new Portrait(this.screen().transpose()).rotateDown(col, step);
    }

    @Override
    public Layout rotateRight(int row, int step) {
        return new Landscape(this.screen().rotate(row, step));
    }
}
