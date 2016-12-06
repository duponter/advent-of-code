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

    public int part2(Input input) {
        return 0;
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
}
