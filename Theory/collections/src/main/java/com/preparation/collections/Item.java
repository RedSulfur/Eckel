package com.preparation.collections;

import java.util.Objects;

/**
 * Created by sulfur on 09.04.16.
 */
public class Item implements Comparable<Item>{

    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(partNumber,o.partNumber);
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    @Override
    public int hashCode(){

        return Objects.hash(description,partNumber);
    }

    @Override
    public boolean equals(Object otherObj) {

        if(this == otherObj) return true;
        if(otherObj == null) return false;
        if(getClass() != otherObj.getClass()) return false;

        Item other = (Item) otherObj;

        return Objects.equals(description,other.description)
                && partNumber ==
                other.partNumber;
    }
}
