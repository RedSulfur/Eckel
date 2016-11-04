package com.pluralsight.generics;

import com.pluralsight.generics.entity.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinFunctionWithoutGenerics {

    public static void main(String[] args) {

        List people = new ArrayList();

        Person mattShadows = new Person("Matt Shadows", 36);
        Person zackyVengeance = new Person("Zacky Vengeance", 34);
        Person synysterGates = new Person("Synyster Gates", 35);

        people.add(mattShadows);
        people.add(zackyVengeance);
        people.add(synysterGates);

        Object youngest = min(people, new AgeComparator());

        System.out.println("Youngest person is: " + youngest);
    }

    private static Object min(List people, Comparator comparator) {

        if(people.isEmpty()) {
            throw new IllegalStateException("List is empty, cannot find minimum");
        }
        Object youngest = people.get(0);

        for (int i = 1; i < people.size(); i++) {
            Object currentPerson = people.get(i);
            if(comparator.compare(currentPerson, youngest) < 0) {
                youngest = currentPerson;
            }
        }

        return youngest;
    }
}