package com.pluralsight.generics.raw_types.erasure_implications;

public class UncompilableException/*<T>*/ extends Exception {

    public static void main(String[] args) {

        try {
            throw new UncompilableException();

            // runtime check on a generic type is banned. At runtime a
            // generic type is being erased
        } catch (UncompilableException/*<T>*/ e) {
            e.printStackTrace();
        }

    }
}
