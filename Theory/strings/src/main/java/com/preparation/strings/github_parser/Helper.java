package com.preparation.strings.github_parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Helper {

    public static final String ROOT = "/home/sulfur/old-system/IdeaProjects/Eckel/Theory/strings/src/main/java/com/preparation/strings/github_parser/";

    public static Stream<String> getStreamOfLines(String filename) throws IOException {
        return Files.lines(Paths.get(ROOT, filename));
    }
}
