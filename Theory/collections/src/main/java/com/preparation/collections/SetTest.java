package com.preparation.collections;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sulfur on 08.04.16.
 */
public class SetTest {

    public static void main(String[] args) {

        Scanner in = null;
        Set<String> words = new HashSet<>();
        long totalTime = 0;
        int count = 0;

        try {

            in = new Scanner(new BufferedReader(new FileReader("/home/sulfur/IdeaProjects/Preparation/Theory/collections/src/main/java/com/preparation/collections/test.txt")));

            while (in.hasNext()) {
                /**
                 * @param in.next() - By default, a scanner uses white space to separate tokens
                 */
                String word = in.next();
                long callbackTime = System.currentTimeMillis();
                words.add(word);
                callbackTime = callbackTime - System.currentTimeMillis();
                totalTime += callbackTime;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Iterator<String> iter = words.iterator();

        for (int i = 1; i <= 20 && iter.hasNext(); i ++) {
            System.out.println(iter.next());
        }

        System.out.println("*********************");
        System.out.println(words.size() + " distinct words, " + totalTime + " milliseconds");
    }

}
