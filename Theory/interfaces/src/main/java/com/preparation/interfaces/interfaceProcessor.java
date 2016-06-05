package com.preparation.interfaces;

/**
 * Created by sulfur on 05.04.16.
 */

class UtilizeProcessor {
    public static void process(ProcessorVol2 p, Object s) {
        System.out.println("Using processor " + p);
        System.out.println(p.process(s));
    }
}

class Waveform {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Wavefrom " + id;
    }
}

class Filter {

    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }

}

class FilterAdapter implements ProcessorVol2 {

    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    public Object process(Object input) {
        return filter.process((Waveform) input);
    }

    public String name() {
        return filter.name();
    }
}

class LowPass extends Filter{
    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }
    public Waveform process(Waveform input) {
        return input;
    }
}

class HighPass extends Filter{
    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }
    public Waveform process(Waveform input) {
        return input;
    }
}


public class interfaceProcessor {
    public static void main(String[] args) {
    Waveform w = new Waveform();
        UtilizeProcessor.process(new FilterAdapter(new LowPass(1.0)),w);
        UtilizeProcessor.process(new FilterAdapter(new HighPass(1.0)),w);
    }
}
