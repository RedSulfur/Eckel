package com.preparation.multithreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingThread extends LiftOff {

    public void run() {

        try {
            while (countDown-- > 0) {

            System.out.print(next());
            TimeUnit.MILLISECONDS.sleep(100);
        }
        } catch(InterruptedException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        /*
        После каждой команды вывода задача переходит в режим ожидания, что позволяет
        планировщику потоков переключиться на другой поток
        */
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) executorService.execute(new SleepingThread());

        executorService.shutdown();
    }
}
