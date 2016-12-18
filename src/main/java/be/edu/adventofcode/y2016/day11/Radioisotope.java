package be.edu.adventofcode.y2016.day11;

public enum Radioisotope {
    CURIUM("Cm"),
    HYDROGEN("H"),
    LITHIUM("Li"),
    PLUTONIUM("Pu"),
    RUTHENIUM("Ru"),
    STRONTIUM("Sr"),
    THULIUM("Tm");

    private final String symbol;

    Radioisotope(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return this.symbol;
    }
}
