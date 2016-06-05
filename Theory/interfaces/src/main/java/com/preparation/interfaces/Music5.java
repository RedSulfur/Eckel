package com.preparation.interfaces;


class Wind implements Instrument {

    public void adjust() {
        System.out.println(this + ".adjust()");
    }

    public void play(Note n) {
        System.out.println(this + ".play()");
    }

    @Override
    public String toString() {
        return "Wind";
    }
}

class Percussion implements Instrument {

    public void adjust() {
        System.out.println(this + ".adjust()");
    }

    public void play(Note n) {
        System.out.println(this + ".play()");
    }

    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed implements Instrument {

    public void adjust() {
        System.out.println(this + ".adjust()");
    }

    public void play(Note n) {
        System.out.println(this + ".play()");
    }

    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Wind {

    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {

    public String toString() {
        return "Woodwind";
    }
}

public class Music5 {

    static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    static void tune(Instrument i) {
        i.play(Note.C_SHARP);
    }

    public static void main(String[] args) {

        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
