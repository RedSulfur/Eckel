package com.preparation.collections.maps_tasks;

import java.util.HashMap;
import java.util.Map;

/*
Loop over the given array of strings to build a result string like this: when a
string appears the 2nd, 4th, 6th, etc. time in the array, append the string to the result.
Return the empty string if no string appears a 2nd time.

wordAppend(["a", "b", "a"]) → "a"
wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
wordAppend(["a", "", "a"]) → "a"
 */
public class WordAppend {

    public static void main(String[] args) {
        String[] strings = new String[]{"a", "b", "a", "c", "a", "d", "a"};
        Map<String, Integer> map = new HashMap<>();
        String result = "";

        for(String str: strings) {
            if(!map.containsKey(str)) {
                System.out.println("Map dit not contain the following key: " + str);
                map.put(str, 1);
            } else {
                int value = map.get(str);
                System.out.println("Map contained the following key: " + str);
                map.put(str, value + 1);
            }
            if(map.get(str) != 0 && map.get(str) % 2 == 0) {
                System.out.println("In if map.get(str) = " + map.get(str));
                result += str;
            } else {
                System.out.println("In else map.get(str) = " + map.get(str));
                result += "";
            }
            System.out.println();
        }
        System.out.println(result);
    }
}
