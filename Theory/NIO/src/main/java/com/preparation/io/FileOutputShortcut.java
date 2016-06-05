package com.preparation.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by sulfur on 04.04.16.
 */
public class FileOutputShortcut {
    static String file = "/home/sulfur/FileOutputShortcut";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("/home/sulfur/IdeaProjects/Preparation/Theory/NIO/src/main/java/com/preparation/io/FileOutputShortcut.java")
                )
        );
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
