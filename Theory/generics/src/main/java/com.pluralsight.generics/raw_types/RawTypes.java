package com.pluralsight.generics.raw_types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RawTypes {

    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("abc");
        list.add(1);
        list.add(new Object());

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        integers = list;

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Integer i: integers) {
            System.out.println(i);
        }
    }
}
