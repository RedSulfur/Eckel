package com.preparation.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SerialNumberChecker {

    private static int SIZE = 10;
    private static CircularSet set = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {

        @Override
        public void run() {
            while (true) {
                int val = SerialNumberGenerator.nextSerialNumber();
                if (set.contains(val)) {
                    System.out.println("Val " + val + " is already present in set!");
                    System.exit(0);
                }
                set.add(val);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new SerialChecker());
        }
    }
}
