package com.preparation.multithreading;

public class BasicThreads {


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();

    }
}
