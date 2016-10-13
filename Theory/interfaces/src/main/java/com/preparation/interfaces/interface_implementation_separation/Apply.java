package com.preparation.interfaces.interface_implementation_separation;

import java.util.Arrays;

interface Processor {
    String name();
    Object process(Object input);
}

abstract class StringProcessor implements Processor {
    public String name() {
        return getClass().getSimpleName();
    }
    public abstract Object process(Object input);
}

class UpCase extends StringProcessor {

    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class DownCase extends StringProcessor {

    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {

    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

public class Apply {

    public static void process(Processor p, Object input) {
        System.out.println("Using processor " + p.name());
        System.out.println(p.process(input));
    }

    public static String devil = "Undo these chains, my Friend. I'll show you the rage i've hidden";

    public static void main(String[] args) {

        Waveform waveform = new Waveform();
        process(new FilterAdapter(new HighPass(1.0)), waveform);

        process(new DownCase(), devil);
        process(new UpCase(), devil);
        process(new Splitter(), devil);
    }
}