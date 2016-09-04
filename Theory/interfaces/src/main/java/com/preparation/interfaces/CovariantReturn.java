package com.preparation.interfaces;

/**
 * Created by sulfur on 05.04.16.
 */

class Grain {
    @Override
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    @Override
    public String toString() {
        return "Wheat";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    Wheat process() {
        return new Wheat();
    }
}


public class CovariantReturn {

    public static void main(String[] args) {

        java.lang.Integer val = new java.lang.Integer(1);
        System.out.println(val.getClass().getClassLoader()); //null

        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);

        System.out.println(m.getClass().getClassLoader()); //not null

        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }


}
