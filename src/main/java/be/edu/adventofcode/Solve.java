package be.edu.adventofcode;

public final class Solve {
    public static Part day(int day) {
        return part -> question -> answer -> System.out.printf("Day %02d - Part %d - %s %s%n", day, part, question, answer);
    }

    @FunctionalInterface
    public interface Part {
        Question part(int part);
    }

    @FunctionalInterface
    public interface Question {
        Answer q(String question);
    }

    @FunctionalInterface
    public interface Answer {
        void a(String answer);

        default void a(int answer) {
            this.a(Integer.toString(answer));
        }
    }
}
