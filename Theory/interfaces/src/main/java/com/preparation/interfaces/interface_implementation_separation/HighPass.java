package com.preparation.interfaces.interface_implementation_separation;

public class HighPass extends Filter {
    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public Object process(Object input) {
        return null;
    }
}