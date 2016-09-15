package com.preparation.multithreading.philosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadLockResolution {

    public static void main(String[] args) throws InterruptedException {

        int size = 5;
        int ponder = 0;

        Chopstick[] chopsticks = new Chopstick[size];

        for (int i = 0; i < size; i++) {
            chopsticks[i] = new Chopstick();
        }

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < size; i++) {
            if(i < size - 1) {
                exec.execute(new Philosopher(chopsticks[i], chopsticks[i + 1], i, ponder));
            } else {
                exec.execute(new Philosopher(chopsticks[0], chopsticks[i], i, ponder));
            }
        }
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
