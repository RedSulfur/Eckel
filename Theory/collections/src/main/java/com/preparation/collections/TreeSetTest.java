package com.preparation.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sulfur on 09.04.16.
 */
public class TreeSetTest {

    public static void main(String[] args) {

        Set<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",2145));
        parts.add(new Item("Widget",1089));
        parts.add(new Item("Modem",641));
        System.out.println(parts);

        Comparator<Item> comparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                String desc1 = o1.getDescription();
                String desc2 = o2.getDescription();
                return desc1.compareTo(desc2);
            }
        };

        Set<Item> withComparator = new TreeSet<>(comparator);
        withComparator.addAll(parts);

        System.out.println(withComparator);

    }

}
