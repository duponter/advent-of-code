package be.edu.adventofcode.y2016.day09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ImprovedCompressedText {
    private static final Pattern PATTERN = Pattern.compile("(.*?)\\((\\d+)x(\\d+)\\)");

    private final String value;

    public ImprovedCompressedText(String value) {
        this.value = value;
    }

    public long decompressedLength() {
        Matcher matcher = PATTERN.matcher(this.value);
        if (matcher.lookingAt()) {
            int dropLength = this.calculateDropLength(matcher);
            return this.calculateDecompressedLength(matcher, this.value.substring(0, dropLength))
                    + new ImprovedCompressedText(this.value.substring(dropLength)).decompressedLength();
        } else {
            return this.value.length();
        }
    }

    private int calculateDropLength(Matcher matcher) {
        return matcher.group().length() + this.sequenceLength(matcher);
    }

    private long calculateDecompressedLength(Matcher matcher, String data) {
        String data2 = data.substring(matcher.group().length(),
                matcher.group().length() + this.sequenceLength(matcher));
        String data3 = data.substring(matcher.group().length() + this.sequenceLength(matcher));
        Matcher matcher2 = PATTERN.matcher(data2);

        if (matcher2.lookingAt()) {
            return this.uncompressedPrefix(matcher)
                    .length() + this.timesRepeated(matcher) * this.calculateDecompressedLength(matcher2, data2) + new ImprovedCompressedText(data3).decompressedLength();
        } else {
            return this.uncompressedPrefix(matcher)
                    .length() + this.sequenceLength(matcher) * this.timesRepeated(matcher) + new ImprovedCompressedText(data3).decompressedLength();
        }
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
