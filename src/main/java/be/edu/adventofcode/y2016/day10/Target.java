package be.edu.adventofcode.y2016.day10;

public interface Target {
    int number();

    boolean workUntil(Work work);

    void receiveChip(int chipValue);
}
