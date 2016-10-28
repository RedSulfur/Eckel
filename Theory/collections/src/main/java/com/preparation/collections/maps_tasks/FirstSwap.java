package com.preparation.collections.maps_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstSwap {

    public static void main(String[] args) {

        String[] strings = new String[]{"ax", "bt", "ay", "c", "am", "bg", "a"};
        String[] result = firstSwap(strings);
        System.out.println(Arrays.toString(result));
    }

    public static String[] firstSwap(String[] strings) {

        Map<String, Integer> map = new HashMap();
        List<String> vorbidden = new ArrayList();

        for(int i = 0; i < strings.length; i++) {
            if(!vorbidden.contains(strings[i].substring(0, 1))) {
                if (!map.containsKey(strings[i].substring(0, 1))) {
                    map.put(strings[i].substring(0, 1), i);
                } else {
                    int indexToSwap = map.get(strings[i].substring(0, 1));
                    String temp = strings[indexToSwap];
                    strings[indexToSwap] = strings[i];
                    strings[i] = temp;
                    map.remove(strings[i].substring(0, 1));
                    vorbidden.add(strings[i].substring(0, 1));
                }
            }
        }

        return strings;
    }
}