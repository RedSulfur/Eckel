package com.preparation.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by sulfur on 08.04.16.
 */
public class LinkedListTest {

    public static void main(String[] args) {

        List<String> a = new LinkedList<>();

        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();

        b.add("Bob");
        b.add("Smith");
        b.add("James");
        b.add("Cate");

        ListIterator<String> aIter = a.listIterator();
        ListIterator<String> bIter = b.listIterator();

        while (bIter.hasNext()) {
            if(aIter.hasNext()) aIter.next();
                aIter.add(bIter.next());

        }

        System.out.println(a);


        while (bIter.hasNext()) {
            bIter.next();

            if(bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);

        a.removeAll(b);

        System.out.println(a);
    }

}
