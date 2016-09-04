package com.preparation.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

    private IntGenerator gp;
    private final int id;

    public EvenChecker(IntGenerator gp, int id) {
        this.gp = gp;
        this.id = id;
    }

    @Override
    public void run() {
        while (!gp.isCanceled()) {
            int val = gp.next();
            if(val % 2 != 0) {
                System.out.println(val + " is not even!");
                gp.cancel();
            }
        }
    }

    public static void test(IntGenerator gp) {
    test(gp, 10);
    }

    private static void test(IntGenerator gp, int i) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int j = 0; j < i; j++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }
}
