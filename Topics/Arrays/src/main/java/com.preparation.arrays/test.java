package com.preparation.arrays;

/**
 * Created by sulfur on 03.04.16.
 */
class Gizmo {
    public void spin() {}
}

public class test {

//    void f(final int i) {i++;}
    int g(final int i) {return i + 1;}

    public static void main(String[] args) {
        test test = new test();
        System.out.println(test.g(2));
    }

}
