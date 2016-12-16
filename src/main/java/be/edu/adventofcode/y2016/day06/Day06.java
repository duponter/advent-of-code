package be.edu.adventofcode.y2016.day06;

import java.util.Comparator;
import java.util.function.Function;

import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.Array;
import javaslang.collection.CharSeq;

import be.edu.adventofcode.Input;

public class Day06 {
    public String part1(Input input) {
        return transpose(input.lines().toArray()
                .map(CharSeq::of)
                .map(seq -> seq.toJavaArray(Character.class))).map(this::maxOccurrence)
                .foldLeft("", (s, c) -> s + c);
    }

    public String part2(Input input) {
        return transpose(input.lines().toArray()
                .map(CharSeq::of)
                .map(seq -> seq.toJavaArray(Character.class))).map(this::minOccurrence)
                .foldLeft("", (s, c) -> s + c);
    }

    private <T> Array<Array<T>> transpose(Array<T[]> a) {
        return Array.tabulate(a.get().length, row ->
                Array.tabulate(a.size(), col -> a.get(col)[row]));
    }

    private Character maxOccurrence(Array<Character> chars) {
        return this.sortedByOccurrence(chars, Comparator.reverseOrder());
    }

    private Character minOccurrence(Array<Character> chars) {
        return this.sortedByOccurrence(chars, Comparator.naturalOrder());
    }

    private Character sortedByOccurrence(Array<Character> chars, Comparator<Integer> comparator) {
        return chars.groupBy(Function.identity())
                .mapValues(Array::size)
                .map(Function.identity())
                .map(t2 -> Tuple.of(t2._2(), t2._1()))
                .sorted(Tuple2.comparator(comparator, Comparator.naturalOrder()))
                .head()
                ._2();
    }
}
