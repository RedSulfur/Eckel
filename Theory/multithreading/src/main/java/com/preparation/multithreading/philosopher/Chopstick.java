package com.preparation.multithreading.philosopher;

public class Chopstick {

    private boolean taken = false;

    public synchronized
    void take() throws InterruptedException {
        if(taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
