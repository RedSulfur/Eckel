package com.preparation.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by sulfur on 04.04.16.
 */
public class MemoryInput {

    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile
                .read("/home/sulfur/IdeaProjects/Preparation/Theory/NIO/src/main/java/com/preparation/io/MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }

}
