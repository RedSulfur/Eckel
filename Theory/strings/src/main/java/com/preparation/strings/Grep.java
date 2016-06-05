package com.preparation.strings;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep {

    public static void main(String[] args) {

        if(args.length < 1) {
            System.out.println("Usage: Java grep file regex");
            System.exit(0);
        }
        try {
            int index = 0;

            Pattern p = Pattern.compile("\\b[Ssct]\\w+");

            Matcher m = p.matcher("");

            File file = new File("/home/sulfur/IdeaProjects/Preparation/Theory/strings/src/main/java/com/preparation/strings/Grep.java");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                m.reset(nextLine);
                index++;

                while (m.find()) {
                    System.out.format("index: %2d %9.7s: %4d \n", index, m.group(), m.start());
                }
            }


        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}
