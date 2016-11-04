package com.pluralsight.generics;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

    private Comparator<T> builtInComparator;

    public ReverseComparator(Comparator<T> builtInComparator) {
        this.builtInComparator = builtInComparator;
    }

    @Override
    public int compare(T left, T right) {
        return -1 * builtInComparator.compare(left, right);
    }
}
