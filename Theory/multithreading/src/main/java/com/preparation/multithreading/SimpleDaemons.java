package com.preparation.multithreading;


import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " "  + this);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            Thread d = new Thread(new SimpleDaemons());
            d.setDaemon(true);
            d.start();
        }

        System.out.println("Все демоны запущены");
        Thread.sleep(175);
    }
}
