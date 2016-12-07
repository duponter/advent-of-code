package be.edu.adventofcode.y2016.day07;

import javaslang.Tuple2;
import javaslang.collection.CharSeq;
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
        return this.anyAutonomousBridgeBypassAnnotationMatch(split._1()) && !this.anyAutonomousBridgeBypassAnnotationMatch(split._2());
    }

    private boolean anyAutonomousBridgeBypassAnnotationMatch(List<Tuple2<String, Long>> list) {
        return list.map(Tuple2::_1)
                .toJavaStream()
                .anyMatch(this::containsAutonomousBridgeBypassAnnotation);
    }

    private boolean containsAutonomousBridgeBypassAnnotation(String text) {
        return !CharSeq.of(text)
                .sliding(4, 1)
                .filter(this::isAutonomousBridgeBypassAnnotation)
                .isEmpty();
    }

    private boolean isAutonomousBridgeBypassAnnotation(CharSeq chars) {
        if (chars.length() != 4) {
            return false;
        }
        return chars.get(0) == chars.get(3) && chars.get(1) == chars.get(2) && chars.get(0) != chars.get(1);
    }
}
