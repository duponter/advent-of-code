package be.edu.adventofcode.y2016.day05;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Decryption {
    private final String encrypted;

    public Decryption(String encrypted) {
        this.encrypted = encrypted;
    }

    public String md5Hash() {
        return md5Hash(encrypted);
    }

    private String md5Hash(String encrypted) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
        byte[] array = md.digest(encrypted.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte anArray : array) {
            sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

}
