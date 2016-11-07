package com.pluralsight.generics.raw_types.notepad;

import java.util.List;

public class Erasure <T,B extends Comparable<T>> {

	public void unbounded(T param) {

    }

    public void lists(List<T> list, List<List<T>> nestedList) {
        T t = list.get(0);
    }

    public void bounded(B param) {

    }
}
