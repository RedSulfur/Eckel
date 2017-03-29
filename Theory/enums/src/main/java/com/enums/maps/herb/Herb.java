package com.enums.maps.herb;

public class Herb {

    public enum Type { ANNUAL, PERENNIAL, BIENNIAL }

    public Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    final String name;
    final Type type;

    @Override
    public String toString() {
        return name;
    }
}
