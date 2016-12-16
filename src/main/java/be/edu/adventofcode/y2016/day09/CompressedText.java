package be.edu.adventofcode.y2016.day09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CompressedText {
    private static final Pattern PATTERN = Pattern.compile("(.*?)\\((\\d+)x(\\d+)\\)");

    private final String value;

    public CompressedText(String value) {
        this.value = value;
    }

    public int decompressedLength() {
        Matcher matcher = PATTERN.matcher(this.value);
        if (matcher.lookingAt()) {
            return this.calculateDecompressedLength(matcher) + new CompressedText(this.value.substring(this.calculateDropLength(matcher))).decompressedLength();
        } else {
            return this.value.length();
        }
    }

    private int calculateDropLength(Matcher matcher) {
        return matcher.group().length() + this.sequenceLength(matcher);
    }

    private int calculateDecompressedLength(Matcher matcher) {
        return this.uncompressedPrefix(matcher).length() + this.sequenceLength(matcher) * this.timesRepeated(matcher);
    }

    private String uncompressedPrefix(Matcher matcher) {
        return matcher.group(1);
    }

    private int sequenceLength(Matcher matcher) {
        return Integer.valueOf(matcher.group(2));
    }

    private int timesRepeated(Matcher matcher) {
        return Integer.valueOf(matcher.group(3));
    }
}
