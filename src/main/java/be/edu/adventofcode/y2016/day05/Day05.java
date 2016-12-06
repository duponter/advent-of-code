package be.edu.adventofcode.y2016.day05;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javaslang.collection.Stream;

import be.edu.adventofcode.Input;

public class Day05 {
    public String part1(Input input) {
        return Stream.from(0)
                .map(i -> input.text() + i)
                .map(this::MD5)
                .filter(hash -> hash.startsWith("00000"))
                .take(8)
                .map(hash -> Character.toString(hash.charAt(5)))
                .reduce((a, b) -> a + b);
    }

    public String part2(Input input) {
        Password password = new Password();
        Stream.from(0)
                .map(i -> input.text() + i)
                .map(this::MD5)
                .filter(hash -> hash.startsWith("00000"))
                .peek(hash -> password.set(hash.charAt(5), hash.charAt(6)))
                .takeWhile(hash -> {
                    System.out.println("hash = " + hash);
                    return !password.isComplete();
                });
        return password.value();
    }

    private String MD5(String md5) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte anArray : array) {
                sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(Stream.from(0)
                .takeUntil(i -> i > 10)
                .mkString());

    }
}
