package com.pluralsight.generics.bounded_wildcards;

import com.preparation.structures.queue.Queue;

import java.util.List;

public class LowerBoundedWildcard {

    public void loadAll(List<? super Person> personList, Queue<Person> personQueue) {
        for (Person person: personQueue) {
            personList.add(person);
        }
    }
}
