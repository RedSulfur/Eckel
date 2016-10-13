package com.preparation.interfaces.interface_implementation_separation;

public class Waveform {

    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Waveform{" +
                "id=" + id +
                '}';
    }
}
