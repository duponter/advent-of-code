package be.edu.adventofcode.y2016.day07;

import java.util.function.Predicate;

import javaslang.Tuple2;
import javaslang.collection.CharSeq;
import javaslang.collection.Iterator;
import javaslang.collection.List;

public final class IPAddress {
    private Tuple2<List<Tuple2<String, Long>>, List<Tuple2<String, Long>>> split;

    public static IPAddress parse(String input) {
        return new IPAddress(List.of(input.split("\\["))
                .flatMap(token -> List.of(token.split("]")))
                .zipWithIndex()
                .partition(t2 -> t2._2() % 2 == 0));
    }

    private IPAddress(Tuple2<List<Tuple2<String, Long>>, List<Tuple2<String, Long>>> split) {
        this.split = split;
    }

    public boolean supportsTLS() {
        return this.anyMatch(split._1(), this::containsAutonomousBridgeBypassAnnotation)
                && !this.anyMatch(split._2(), this::containsAutonomousBridgeBypassAnnotation);
    }

    private boolean containsAutonomousBridgeBypassAnnotation(String text) {
        return this.contains(text, 4, this::isAutonomousBridgeBypassAnnotation);
    }

    private boolean isAutonomousBridgeBypassAnnotation(CharSeq chars) {
        if (chars.length() != 4) {
            return false;
        }
        return chars.get(0) == chars.get(3) && chars.get(1) == chars.get(2) && chars.get(0) != chars.get(1);
    }

    public boolean supportsSSL() {
        return split._1().map(Tuple2::_1)
                .flatMap(this::filterAreaBroadcastAccessor)
                .crossProduct(split._2().map(Tuple2::_1))
                .toJavaStream()
                .anyMatch(t2 -> containsByteAllocationBlock(t2._2(), t2._1()));
    }

    private Iterator<CharSeq> filterAreaBroadcastAccessor(String text) {
        return this.filter(text, 3, this::isAreaBroadcastAccessor);
    }

    private boolean containsByteAllocationBlock(String text, CharSeq aba) {
        return this.contains(text, 3, charSeq -> isByteAllocationBlock(charSeq, aba));
    }

    private Iterator<CharSeq> filter(String text, int size, Predicate<CharSeq> predicate) {
        return CharSeq.of(text)
                .sliding(size, 1)
                .filter(predicate);
    }

    private boolean isAreaBroadcastAccessor(CharSeq chars) {
        if (chars.length() != 3) {
            return false;
        }
        return chars.get(0) == chars.get(2) && chars.get(0) != chars.get(1);
    }

    private boolean isByteAllocationBlock(CharSeq chars, CharSeq aba) {
        return this.isAreaBroadcastAccessor(chars) && chars.get(0) == aba.get(1) && chars.get(1) == aba.get(0);
    }

    private boolean anyMatch(List<Tuple2<String, Long>> list, Predicate<String> predicate) {
        return list.map(Tuple2::_1)
                .toJavaStream()
                .anyMatch(predicate);
    }

    private boolean contains(String text, int size, Predicate<CharSeq> predicate) {
        return !CharSeq.of(text)
                .sliding(size, 1)
                .filter(predicate)
                .isEmpty();
    }
}
