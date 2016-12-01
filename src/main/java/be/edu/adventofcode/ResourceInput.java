package be.edu.adventofcode;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import javaslang.collection.CharSeq;
import javaslang.collection.List;

public final class ResourceInput implements Input {
    private final Class<?> base;

    public ResourceInput(Class<?> base) {
        this.base = base;
    }

    @Override
    public String text() {
        return this.joined("");
    }

    @Override
    public String joined(String separator) {
        return String.join(separator, this.lines());
    }

    @Override
    public CharSeq chars() {
        return CharSeq.ofAll(this.lines().flatMap(CharSeq::of));
    }

    @Override
    public List<String> lines() {
        URL resource = this.base.getResource(String.format("%s.txt", this.base.getSimpleName()));
        URI input;
        try {
            input = resource.toURI();
        } catch (URISyntaxException use) {
            throw new IllegalArgumentException(String.format("Invalid URI syntax: %s", resource.getPath()), use);
        }
        try {
            return List.ofAll(Files.readAllLines(Paths.get(input)));
        } catch (IOException ioe) {
            throw new IllegalArgumentException(String.format("Unable to read lines from %s", resource.getPath()), ioe);
        }
    }

    @Override
    public List<String> split(String separator) {
        return new StringInput(this.text()).split(separator);
    }
}
