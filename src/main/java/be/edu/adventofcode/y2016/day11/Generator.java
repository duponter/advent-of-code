package be.edu.adventofcode.y2016.day11;

import java.util.Objects;

public class Generator implements Component {
    private final Radioisotope generatesIsotope;

    public Generator(Radioisotope generatesIsotope) {
        this.generatesIsotope = generatesIsotope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Generator generator = (Generator) o;
        return generatesIsotope == generator.generatesIsotope;
    }

    @Override
    public int hashCode() {
        return Objects.hash(generatesIsotope);
    }

    @Override
    public String toString() {
        return String.format("G%s", generatesIsotope);
    }
}
