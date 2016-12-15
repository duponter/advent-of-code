package be.edu.adventofcode.y2016.day10;

public class AddChip implements ChipsPattern<Chips> {
    private final int value;

    public AddChip(int value) {
        this.value = value;
    }

    @Override
    public Chips whenNone() {
        return new Single(this.value);
    }

    @Override
    public Chips whenSingle(int chipValue) {
        if (chipValue == value) {
            throw new IllegalStateException("Could not determine low or high value");
        }
        return chipValue > value ? new Pair(value, chipValue) : new Pair(chipValue, value);
    }

    @Override
    public Chips whenPair(int low, int high) {
        throw new IllegalStateException("A Bot can only contain 2 chips simultaneously");
    }
}
