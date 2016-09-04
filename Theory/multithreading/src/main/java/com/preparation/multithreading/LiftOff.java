package com.preparation.multithreading;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable{

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String next() {
        return "#" + id + ((countDown > 0) ?  "("  + countDown + ") " : "LiftOff! ");
    }

    @Override
    public void run() {

        while (countDown-- > 0) {
            System.out.print(next() + " ");
            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
