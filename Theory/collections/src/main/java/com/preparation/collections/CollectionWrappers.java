package com.preparation.collections;

import java.util.*;

/**
 * Created by sulfur on 10.04.16.
 */
public class CollectionWrappers {

    public static void main(String[] args) {

        List<String> list = Collections.nCopies(10, "DEFAULT");

        /*
        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        */
//        System.out.println("***********************");

        Set<String> singleton = Collections.singleton("SET DEFAULT");

        /*
        Iterator<String> setIter = singleton.iterator();

        while (setIter.hasNext()) {
            System.out.println(setIter.next());
        }
        */

        List subList = list.subList(1, 6);

        System.out.println(subList);

    }


    }

