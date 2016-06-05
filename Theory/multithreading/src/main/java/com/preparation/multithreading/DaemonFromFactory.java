package com.preparation.multithreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable{

    @Override
    public void run() {

        try {
        while (true) {

            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread() + " " + this);
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        /**
         * обьект DaemonThreadPoolExecutor будет использоваться
         * для создания новых потоков, возвращаемых методом newThread(Runnable r)
         * класса DaemonThreadFactory реализующего интерфейс ThreadFactory
         */

        ExecutorService dexec = new DaemonThreadPoolExecutor();

        for (int i = 0; i < 5; i++) {
            dexec.execute(new DaemonFromFactory());
        }
        System.out.println("Все демоны запущены");
        TimeUnit.MILLISECONDS.sleep(100);

    }


}


