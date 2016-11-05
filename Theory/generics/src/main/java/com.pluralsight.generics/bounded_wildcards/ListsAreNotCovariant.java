package com.pluralsight.generics.bounded_wildcards;

import com.pluralsight.generics.GenericQueue;

import java.util.ArrayList;
import java.util.List;

public class ListsAreNotCovariant {

    public static void main(String[] args) {

        GenericQueue<Person> queue = new GenericQueue<>(5);

        Partner john = new Partner("John Doe", 25);
        Partner jane = new Partner("Jane Doe", 30);

        List<Partner> persons = new ArrayList<>();

        persons.add(john);
        persons.add(jane);

        putAll(persons, queue);
        loadAll(queue);
    }

    // Upper bounded wildcards
    private static void putAll(List<? extends Person> persons, GenericQueue<Person> queue) {
        persons.forEach(queue::offer);
    }

    private static void loadAll(GenericQueue<Person> queue) {
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}