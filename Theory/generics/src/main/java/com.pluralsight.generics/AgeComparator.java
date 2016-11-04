package com.pluralsight.generics;

import com.pluralsight.generics.entity.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person left, Person right) {
        return Integer.compare(left.getAge(), right.getAge());
    }
}
