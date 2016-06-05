package com.preparation.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sulfur on 09.05.16.
 */
public class AttemptLocking {

    private Lock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("Captured: " + captured);
        }
        finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {

        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        try {
            System.out.println("Captured: " + captured);
        } finally {
            if (captured) lock.unlock();
        }
    }

    public static void main(String[] args) {

        AttemptLocking locking = new AttemptLocking();

        locking.untimed();
        locking.timed();

        new Thread(new Runnable() {
            @Override
            public void run() {
                locking.lock.lock();
                System.out.println("acquired");
            }
        }).start();
        
        locking.untimed();
        locking.timed();


    }

}
