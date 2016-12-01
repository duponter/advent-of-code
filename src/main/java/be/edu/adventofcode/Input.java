package be.edu.adventofcode;

import javaslang.collection.CharSeq;
import javaslang.collection.List;

public interface Input {
    String text();

    String joined(String separator);

    CharSeq chars();

    List<String> lines();
}
