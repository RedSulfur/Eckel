package com.pluralsight.generics.bounded_wildcards;

import java.util.List;
import com.preparation.structures.queue.Queue;

public class UpperBoundedWildcards {

    public void putAll(List<? extends Person> list, Queue<Person> queue) {
        list.forEach(queue::enqueue);
    }
}
