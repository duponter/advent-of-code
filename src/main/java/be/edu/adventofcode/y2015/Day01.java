package be.edu.adventofcode.y2015;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;

public class Day01 {

    public static void main(String[] args) {
        new Day01().part1();
    }

    private void part1() {
        String input = this.readInput();
        int up = StringUtils.countMatches(input, '(');
        int down = StringUtils.countMatches(input, ')');
        System.out.printf("Going up %d times, going down %d times, ending at floor %d", up, down, up - down);
    }

    private String readInput() {
        URL resource = this.getClass().getResource("Day01.txt");
        URI input;
        try {
            input = resource.toURI();
        } catch (URISyntaxException use) {
            throw new IllegalArgumentException(String.format("Invalid URI syntax: %s", resource.getPath()), use);
        }
        try {
            return String.join("", Files.readAllLines(Paths.get(input)));
        } catch (IOException ioe) {
            throw new IllegalArgumentException(String.format("Unable to read lines from %s", resource.getPath()), ioe);
        }
    }
}
