package be.edu.adventofcode.y2016.day08;

public abstract class Layout implements OperationHandler<Layout> {
    private final Screen screen;

    protected Layout(Screen screen) {
        this.screen = screen;
    }

    public Screen screen() {
        return screen;
    }
}
