package com.preparation.multithreading;


class Sleeper extends Thread {

    int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {

        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted: " + isInterrupted());
            return;
        }
        System.out.println(getName() + " reactivated");
    }
}

class Joiner extends Thread {
    Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " finished");
    }
}

public class Joining {

    public static void main(String[] args) {

        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);

        Joiner dopey = new Joiner("Dopey", sleepy);
        Joiner doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }

}
