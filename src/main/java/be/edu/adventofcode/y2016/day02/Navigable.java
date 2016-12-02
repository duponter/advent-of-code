package be.edu.adventofcode.y2016.day02;

public interface Navigable<N extends Navigable<N>> {
    N up();

    N down();

    N left();

    N right();
}
