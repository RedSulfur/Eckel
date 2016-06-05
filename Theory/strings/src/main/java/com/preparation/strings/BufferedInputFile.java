package com.preparation.strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {

    public static String
    read(String filename) throws IOException {
        String s;
        BufferedReader in = new BufferedReader(
                new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");

        }

        in.close();
        return sb.toString();
    }
}
