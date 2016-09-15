package com.preparation.multithreading.philosopher;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {

    private Chopstick left;
    private Chopstick right;
    private int id;
    private int ponder;
    private Random rand = new Random(47);

    public Philosopher(Chopstick left, Chopstick right, int id, int pond) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponder = pond;
    }

    public void pause()
            throws InterruptedException {
        if(ponder == 0) return;
        TimeUnit.MILLISECONDS.sleep(ponder * 250);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println(this + " is philosophizing");
                pause();
                System.out.println(this + " takes the right stick");
                right.take();
                System.out.println(this + " takes the left stick");
                left.take();
                System.out.println(this + " eats");
                pause();
                right.drop();
                left.drop();
            } catch (InterruptedException e) {
                System.out.println("Exit due to interruption");
            }
        }
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                '}';
    }
}
