package com.preparation.strings.github_parser;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    public static final String REGEX = "\\[([a-zA-z ]*)\\]\\(.+\\)";

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        try(Stream<String> lines = Helper.getStreamOfLines("in.txt")) {
//            Object[] objects = lines.toArray();
            for(String line : lines.collect(Collectors.toList())) {
                sb.append(line + "\n");
            }
            Matcher m = Pattern.compile(REGEX).matcher(sb.toString());
            while (m.find()) {
                System.out.println(m.group(1));
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
