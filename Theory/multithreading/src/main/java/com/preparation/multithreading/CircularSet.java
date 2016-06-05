package com.preparation.multithreading;

/**
 * Created by sulfur on 09.05.16.
 */
public class CircularSet {

    int array[];
    int index = 0;
    int len;

    public CircularSet(int size) {
        len = size;
        array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add (int val) {

        array[index] = val;
        index = ++index % len;

    }

    public synchronized boolean contains (int val) {

        for (int i = 0; i < len; i++) {
            if (array[i] == val) {
                return true;
            }
        }
        return false;
    }
}
