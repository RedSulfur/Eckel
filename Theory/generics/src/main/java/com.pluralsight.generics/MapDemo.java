package com.pluralsight.generics;

import com.pluralsight.generics.entity.Person;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {

        Person mattShadows = new Person("Matt Shadows", 36);
        Person zackyVengeance = new Person("Zacky Vengeance", 34);
        Person synysterGates = new Person("Synyster Gates", 35);

        Map<String, Person> map = new HashMap<>();
        map.put(mattShadows.getName(), mattShadows);
        map.put(zackyVengeance.getName(), zackyVengeance);
        map.put(synysterGates.getName(), synysterGates);

        for (Map.Entry<String, Person> entry: map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
