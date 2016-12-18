package be.edu.adventofcode.y2016.day11;

import java.util.Objects;

public class Microchip implements Component {
    private final Radioisotope compatibleIsotope;

    public Microchip(Radioisotope compatibleIsotope) {
        this.compatibleIsotope = compatibleIsotope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Microchip microchip = (Microchip) o;
        return compatibleIsotope == microchip.compatibleIsotope;
    }

    @Override
    public int hashCode() {
        return Objects.hash(compatibleIsotope);
    }

    @Override
    public String toString() {
        return String.format("M%s", compatibleIsotope);
    }
}
