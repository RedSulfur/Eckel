package com.preparation.multithreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    public static void main(String[] args) {

        /*
        С FixedThreadPool дорогостоящая операция создания потоков выполняется только один раз,
        в самом начале, поэтому количество потоков остается фиксированным
        */
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }


}
