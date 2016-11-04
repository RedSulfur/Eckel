package com.pluralsight.generics;

import com.pluralsight.generics.entity.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        Person mattShadows = new Person("Matt Shadows", 36);
        Person zackyVengeance = new Person("Zacky Vengeance", 34);
        Person synysterGates = new Person("Synyster Gates", 35);

        people.add(mattShadows);
        people.add(zackyVengeance);
        people.add(synysterGates);

        System.out.println("In ascending order");
        Collections.sort(people, new AgeComparator());
        people.forEach(System.out::println);

        System.out.println();

        Collections.sort(people, new ReverseComparator<>(new AgeComparator()));
        System.out.println("In descending order");
        people.forEach(System.out::println);
    }
}