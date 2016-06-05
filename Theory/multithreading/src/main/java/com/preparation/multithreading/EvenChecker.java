package com.preparation.multithreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable{

    private EvenGenerator gen;
    private int id;

    public EvenChecker(EvenGenerator gen, int id) {
        this.gen = gen;
        this.id = id;
    }

    @Override
    public void run() {
        while (!gen.isCanceled()) {
            if(gen.next()%2 != 0) {
                System.out.println(gen.next() + " isn't an even number");
                gen.cancel();
            }
        }
    }

    public static void test(EvenGenerator eg, int count) {

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(eg,i));
        }
    }

    public static void test(EvenGenerator eg) {
        test(eg,10);
    }

}
