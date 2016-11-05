package com.pluralsight.generics.bounded_wildcards;

public class CovariantArrays {

    public static void main(String[] args) {

        Partner john = new Partner("John Doe", 25);
        Partner jane = new Partner("Jane Doe", 30);

        Employee[] employees = new Employee[2];
        Person[] persons = employees;

        persons[0] = john;
        persons[1] = jane;

    }
}

