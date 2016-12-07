package be.edu.adventofcode.y2016.day05;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import javaslang.collection.Stream;

import be.edu.adventofcode.Input;

public class Day05 {
    public String part1(Input input) {
        return Stream.from(0)
                .map(i -> input.text() + i)
                .map(Decryption::new)
                .map(Decryption::md5Hash)
                .filter(hash -> hash.startsWith("00000"))
                .take(8)
                .map(hash -> Character.toString(hash.charAt(5)))
                .reduce((a, b) -> a + b);
    }

    public String part2(Input input) {
        Password password = new Password();

        AtomicInteger ai = new AtomicInteger(0);
        IntStream.generate(ai::getAndIncrement)
                .mapToObj(i -> input.text() + i)
                .map(Decryption::new)
                .map(Decryption::md5Hash)
                .filter(hash -> hash.startsWith("00000"))
                .anyMatch(hash -> password.set(hash.charAt(5), hash.charAt(6)));

        return password.value();
    }

    public void hangs() {
        AtomicInteger ai = new AtomicInteger(0);
        System.out.println(Stream.continually(ai.getAndIncrement())
                .takeUntil(i -> i > 10)
                .mkString());
    }
}
