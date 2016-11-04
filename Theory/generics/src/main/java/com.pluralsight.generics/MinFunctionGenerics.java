package com.pluralsight.generics;

import com.pluralsight.generics.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinFunctionGenerics {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        Person mattShadows = new Person("Matt Shadows", 36);
        Person zackyVengeance = new Person("Zacky Vengeance", 34);
        Person synysterGates = new Person("Synyster Gates", 35);

        people.add(mattShadows);
        people.add(zackyVengeance);
        people.add(synysterGates);

        System.out.println(min(people, new AgeComparator()));

        List<Integer> integers = Arrays.asList(4, 5, 3, 1, 7, 2);

        System.out.println(min(integers, Integer::compare));
    }

    private static <T> T min(List<T> list, Comparator<T> comparator) {
        if(list.isEmpty()) {
            throw new IllegalStateException("List is empty, cannot find minimum");
        }
        T min = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            T element = list.get(i);
            if(comparator.compare(element, min) < 0) {
                min = element;
            }
        }

        return min;
    }
}