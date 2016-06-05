package com.preparation.io;

import java.io.*;

/**
 * Created by sulfur on 04.04.16.
 */
public class BasicFileOutput {
    static String file = "/home/sulfur/BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
        /*
        The Java StringReader class enables you to turn an ordinary String
        into a Reader. This is useful if you have data as a String but need to pass
        that String to a component that only accepts a Reader.
        */
                new StringReader(
                        BufferedInputFile.read("/home/sulfur/IdeaProjects/Preparation/Theory/NIO/src/main/java/com/preparation/io/BasicFileOutput.java")
                )
        );
        PrintWriter out = new PrintWriter(new FileWriter(file));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
