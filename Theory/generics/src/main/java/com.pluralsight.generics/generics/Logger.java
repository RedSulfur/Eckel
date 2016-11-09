package com.pluralsight.generics.generics;

public class Logger {

    private String value;

    // value should be injected to constructor
    public Logger(String value) {
        this.value = value;
    }

    public void log() {
        System.out.println(value);
    }
}
