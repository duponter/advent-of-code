package be.edu.adventofcode.y2015;

import be.edu.adventofcode.ResourceInput;
import be.edu.adventofcode.Solve;

public class Day01 {
    public static void main(String[] args) {
        new Day01().part1();
        new Day01().part2();
    }

    private void part1() {
        Integer answer = new ResourceInput(this.getClass()).chars()
                .foldLeft(0, (pos, next) -> (pos += (next == '(') ? 1 : -1));
        Solve.day(1)
                .part(1)
                .q("To what floor do the instructions take Santa?")
                .a(answer);
    }

    private void part2() {
        int answer = new ResourceInput(this.getClass()).chars()
                .scanLeft(0, (pos, next) -> (pos += (next == '(') ? 1 : -1))
                .takeUntil(pos -> pos == -1)
                .size();
        Solve.day(1)
                .part(2)
                .q("What is the position of the character that causes Santa to first enter the basement?")
                .a(answer);
    }
}
