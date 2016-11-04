package com.pluralsight.generics;

public class GenericQueue<T> {

    private T[] queue;
    private int writeCursor = 0;
    private int readCursor = 0;

    public GenericQueue(int queueSize) {
        queue = (T[]) new Object[queueSize];
    }

    public boolean offer(T value) {

        if(queue[writeCursor] != null) {
            return false;
        }
        queue[writeCursor] = value;
        writeCursor = next(writeCursor);

        return true;
    }

    public T poll() {

        T value = queue[readCursor];

        if(value != null) {
            queue[readCursor] = null;
            readCursor = next(readCursor);
            return value;
        }

        return value;
    }

    private int next(int writeCursor) {
        return (writeCursor + 1) % queue.length;
    }
}
