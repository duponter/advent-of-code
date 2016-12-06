package be.edu.adventofcode.y2016.day04;

import java.util.Comparator;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.CharSeq;

public class Room {
    private static final Pattern PATTERN = Pattern.compile("([\\w-]+)-(\\d+)\\[(\\w{5})]");

    private final String encryptedName;
    private final Integer sectorId;
    private final String checkSum;

    public static Room parse(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(input);
        }
        return new Room(matcher.group(1), Integer.parseInt(matcher.group(2)), matcher.group(3));
    }

    private Room(String encryptedName, Integer sectorId, String checkSum) {
        this.encryptedName = encryptedName;
        this.sectorId = sectorId;
        this.checkSum = checkSum;
    }

    public Integer sectorId() {
        return sectorId;
    }

    public boolean isReal() {
        return CharSeq.of(encryptedName)
                .groupBy(Function.identity())
                .remove('-')
                .mapValues(CharSeq::size)
                .map(Function.identity())
                .map(t2 -> Tuple.of(t2._2(), t2._1()))
                .sorted(Tuple2.comparator(Comparator.reverseOrder(), Comparator.naturalOrder()))
                .take(5)
                .map(Tuple2::_2)
                .foldLeft("", (s, c) -> s + c)
                .equals(checkSum);
    }

    public String realName() {
        int rotations = sectorId % 26;
        return CharSeq.of(encryptedName)
                .map(c -> rotate(c, rotations))
                .foldLeft("", (s, c) -> s + c);
    }

    private Character rotate(Character c, int count) {
        return c == '-' ? ' ' : (char) (c + count > 'z' ? c + count - 26 : c + count);
    }
}
