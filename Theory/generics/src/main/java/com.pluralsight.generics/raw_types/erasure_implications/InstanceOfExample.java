package com.pluralsight.generics.raw_types.erasure_implications;

public class InstanceOfExample<T> {

    public boolean equals(Object o) {

        // it is illegal to have a generic type parameter when we are using instanceOf
        // because at runtime that class does not really exist
        if(o instanceof InstanceOfExample/*<T>*/) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new InstanceOfExample<>() instanceof InstanceOfExample);
    }
}
