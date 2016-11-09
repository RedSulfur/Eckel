package com.pluralsight.generics.generics;

public class DependencyInjectionDemo {

    public static void main(String[] args) {

        Injector injector = new Injector().with("Hello World");

        Logger logger = injector.newInstance(Logger.class);
        logger.log();
    }
}
