package com.pluralsight.generics;

public class Queue {

    private Object[] queue;
    private int writeCursor = 0;
    private int readCursor = 0;

    public Queue(int queueSize) {
        queue = new Object[queueSize];
    }

    public boolean offer(Object value) {

        if(queue[writeCursor] != null) {
            return false;
        }
        queue[writeCursor] = value;
        writeCursor = next(writeCursor);

        return true;
    }

    public Object poll() {

        Object value = queue[readCursor];

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
