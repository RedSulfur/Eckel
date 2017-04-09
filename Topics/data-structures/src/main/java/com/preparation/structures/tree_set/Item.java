package com.preparation.structures.tree_set;

import java.util.Objects;

public class Item implements Comparable<Item> {

    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getPartNumber() {
        return partNumber;
    }

    @Override
    public int compareTo(Item item) {
        return Integer.compare(partNumber, item.partNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public boolean equals(Object object) {
        if(object == this) return true;
        if(object == null) return false;
        if(object.getClass() != this.getClass()) return false;
        Item item = (Item) object;
        return Objects.equals(this.description, item.description) &&
                this.partNumber == item.partNumber;
    }

    @Override
    public String toString() {
        return "[description = " + description +
                ", partNumber = " + partNumber + "]";
    }
}
