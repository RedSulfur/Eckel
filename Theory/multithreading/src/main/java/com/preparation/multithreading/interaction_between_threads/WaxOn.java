package com.preparation.multithreading.interaction_between_threads;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {

    Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitingForBuffing();
            }
        } catch(InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
    }
}
