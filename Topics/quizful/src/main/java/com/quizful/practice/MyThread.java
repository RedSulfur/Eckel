package com.quizful.practice;

public class MyThread extends Thread {

    private String message;

    public MyThread(String message) {
        this.message = message;
    }

    public void run() {
        System.out.println("Overwritten method from the superclass Thread");
    }

    public static void main(String[] args) {
        System.out.println("About to run thread");
        new MyThread("Run, Run, Run!").start();
    }

}
