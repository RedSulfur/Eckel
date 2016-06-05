package com.preparation.composition;

/*
        isEverywhere({1, 2, 1, 3}, 1) → true
        isEverywhere({1, 2, 1, 3}, 2) → false
        isEverywhere({1, 2, 1, 3, 4}, 1) → false
        ({2, 1, 2, 3, 1}, 2) → false
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


public class isEverywhere {

    public static Logger log = LoggerFactory.getLogger(isEverywhere.class);
    static final String fileIn= "/home/sulfur/IdeaProjects/Preparation/" +
            "Theory/composition/src/main/java/isEverywhere.out";
    static final String fileOut = "/home/sulfur/IdeaProjects/Preparation/" +
            "Theory/composition/src/main/java/isEverywhere.in";

    public static int[]
    read(String filename) throws IOException {

        String s, PreResult;
        BufferedReader in = new BufferedReader(
                new FileReader(filename)
        );

        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            log.debug("Symbols fetched: {}", s);
            sb.append(s);
        }

        log.debug("String have been read: {}", sb.toString());

        PreResult = sb.toString().trim().replaceAll("\n","");

        log.debug("Trimmed string: {}", PreResult);

        String [] array = sb.toString().split(", ");

        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i ++) {
            log.debug("token in the result array: {}, type: {}", array[i]
                    , array[i].getClass().getCanonicalName());
        }
        log.debug("array.length: {}", array.length);
        log.debug("result.length: {}", result.length);

        for(int i = 0; i < result.length; i ++) {
            result[i] = Integer.parseInt(array[i]);
            log.debug("Here is the problem: {}", result[i]);
        }
        in.close();
        return result;
    }

    public static boolean isEverywhere(int val) {

        int[] nums = new int[0];
        try {
            nums = read(fileIn);
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean status = true;

        for (int i = 0; i < nums.length - 1; i ++) {
            if((nums[i] != val) && (nums[i + 1] != val)) {
                status = false;
            }
        }

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileOut));
            out.write(Boolean.toString(status));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("*********************************");

        return status;
    }


    public static void main(String[] args) {

        System.out.println("Program has processed the following result: " + isEverywhere(1));

    }

}
