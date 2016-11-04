package com.pluralsight.generics;

public class SortedPair<T extends Comparable<T>> {

    private final T left;
    private final T right;

    public SortedPair(T left, T right) {
        if(left.compareTo(right) < 0) {
            this.left = left;
            this.right = right;
        } else {
            this.left = right;
            this.right = left;
        }
    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }
}
