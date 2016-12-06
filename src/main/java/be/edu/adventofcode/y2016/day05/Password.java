package be.edu.adventofcode.y2016.day05;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Password {
    private final Character[] value = new Character[8];

    public Password() {
        Arrays.fill(value, null);
    }

    public boolean set(char position, char c) {
        int pos = Character.getNumericValue(position);
        if (pos >= 0 && pos < value.length && value[pos] == null) {
            value[pos] = c;
        }
        return isComplete();
    }

    public boolean isComplete() {
        return Arrays.stream(value).allMatch(Objects::nonNull);
    }

    public String value() {
        return Arrays.stream(value)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
