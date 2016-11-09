package com.pluralsight.generics.generics;

import java.util.ArrayList;
import java.util.List;

public class ReifiableClasses {

    public static void main(String[] args) {

        System.out.println(int.class);
        System.out.println(String.class);

        List<?> wildcards = new ArrayList<>();
        System.out.println(wildcards.getClass());

        List rawList = new ArrayList();
        System.out.println(rawList.getClass());

        System.out.println(wildcards.getClass() == rawList.getClass());

        System.out.println(List[].class);
    }
}
