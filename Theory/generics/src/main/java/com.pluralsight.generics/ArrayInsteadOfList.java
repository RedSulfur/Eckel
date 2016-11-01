package com.pluralsight.generics;

import com.pluralsight.generics.entity.Person;

import java.util.Arrays;

public class ArrayInsteadOfList {

    public static void main(String[] args) {

        Person mattShadows = new Person("Matt Shadows", 35);
        Person zackyVengeance = new Person("Zacky Vengeance", 34);

        Person[] people = new Person[] {mattShadows, zackyVengeance};

        System.out.println(Arrays.toString(people));
        Person synysterGates = new Person("Synyster Gates", 35);

        people = add(people, synysterGates);
        System.out.println(Arrays.toString(people));

    }

    private static Person[] add(Person[] people, Person person) {

        int length = people.length;
        Person[] broadenedArray = Arrays.copyOf(people, length + 1);
        broadenedArray[length] = person;

        return broadenedArray;
    }
}
