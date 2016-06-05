package com.preparation.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sulfur on 09.05.16.
 */
public class SerialNumberChecker {

    private static CircularSet set = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static class serialChecker extends Thread{
        @Override
        public void run() {

            while (true) {
                int val = SerialNumberGenerator.nextSerialNumber();
                if (set.contains(val)) {
                    System.out.println("Duplicate serial " + val);
                    System.exit(0);
                }
                set.add(val);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            exec.execute(new serialChecker());
        }
        TimeUnit.SECONDS.sleep(2L);
        System.out.println("No duplicates detected");
        System.exit(0);
    }

}
