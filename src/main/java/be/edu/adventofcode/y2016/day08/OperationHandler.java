package be.edu.adventofcode.y2016.day08;

public interface OperationHandler<R> {
    R createRectangle(int cols, int rows);

    R rotateDown(int col, int step);

    R rotateRight(int row, int step);
}
