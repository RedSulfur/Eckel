package com.preparation.interfaces.interface_implementation_separation;

public class LowPass extends Filter {

    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public Waveform process(Waveform input) {
        return input;
    }
}