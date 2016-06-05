package com.preparation.composition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sulfur on 06.04.16.
 */
public class isEverywherePt2 {

    public static Logger log = LoggerFactory.getLogger(isEverywhere.class);
    static final String filename = "/home/sulfur/IdeaProjects/Preparation/" +
            "Theory/composition/src/main/java/isEverywhere.out";

    public static int[] read(String filename) throws FileNotFoundException {

        String temp;

            Scanner inFile = new Scanner(new File("/home/sulfur/IdeaProjects/Preparation/" +
                    "Theory/composition/src/main/java/isEverywhere.out")).useDelimiter(",\\s*||\n");

            List<String> list = new LinkedList<String>();
            while (inFile.hasNext()) {
                temp = inFile.next();
                log.debug("token : {}", temp);
                list.add(temp);
            }
            int[] result = new int[list.size()];

            String[] array = list.toArray(new String[list.size()]);

        log.debug("Retrieved array: {}", Arrays.toString(array));

            for(int i = 0; i < array.length; i ++) {
                    log.debug("array[i]: {}", array[i]);
                    result[i] = Integer.parseInt(array[i]);
            }

            return result;

    }

    public static boolean isEverywhere(int val) {

        int[] nums = new int[0];

        try {
            nums = read(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        boolean status = true;

        for (int i = 0; i < nums.length - 1; i ++) {
            if((nums[i] != val) && (nums[i + 1] != val)) {
                status = false;
            }
        }

        return status;
    }

    public static void main(String[] args) {

        System.out.println("Program has processed the following result: " + isEverywhere(1));

    }

}
