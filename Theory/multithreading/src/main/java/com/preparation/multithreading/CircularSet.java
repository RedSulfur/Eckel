package com.preparation.multithreading;

public class CircularSet {

    private int[] array;
    private int len;
    private int index;

    public CircularSet(int len) {
        this.len = len;
        array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = -1;
        }
    }

    public synchronized boolean contains(int val) {

        for (int i = 0; i < len; i++) {
            if(array[i] == val) return true;
        }
        return false;
    }

    public synchronized void add(int val) {
        array[index] = val;
        index = ++index % len;
    }
}
