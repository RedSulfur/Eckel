package com.preparation.multithreading.interaction_between_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Car {

    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitingForBuffing()
            throws InterruptedException {
        while (waxOn == true)
            wait();
    }

    public synchronized void waitingForWaxing()
            throws InterruptedException {
        while (waxOn == false)
            wait();
    }

    public static void main(String[] args) throws InterruptedException {

        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}