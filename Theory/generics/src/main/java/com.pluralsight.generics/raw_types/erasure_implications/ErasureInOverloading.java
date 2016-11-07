package com.pluralsight.generics.raw_types.erasure_implications;

import com.pluralsight.generics.bounded_wildcards.Person;

import java.util.List;

public class ErasureInOverloading {

    public void setValue(String value) {
    }

    public void setValue(List<String> list) {
    }

    /*public void setValue(List<Person> list) {
    }*/
}
