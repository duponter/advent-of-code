package be.edu.adventofcode.y2016.day11;

import javaslang.collection.Array;
import javaslang.collection.List;

public class Facility {
    private final Array<Floor> floors;
    private final Elevator elevator;

    public Facility(Elevator elevator, Floor... floors) {
        this.elevator = elevator;
        this.floors = Array.of(floors);
    }

    public void print(Radioisotope... isotopes) {
        floors.reverse().forEach(floor -> print(floor, isotopes));
    }

    private void print(Floor floor, Radioisotope... isotopes) {
        String components = List.of(isotopes)
                .flatMap(isotope -> List.of(new Generator(isotope), new Microchip(isotope)))
                .map(component -> floor.content().contains(component) ? component.toString() : ".")
                .map(text -> String.format("%4s", text))
                .fold("", (a, b) -> a + b);

        System.out.printf("%s %s %s%n", floor, elevator.print(floor), components);
    }
}
