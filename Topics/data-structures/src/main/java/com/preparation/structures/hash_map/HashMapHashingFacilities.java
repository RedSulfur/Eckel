package com.preparation.structures.hash_map;

public class HashMapHashingFacilities {

    public static void main(String[] args) {
        unsignedShift();
    }

    public static void unsignedShift() {
        int number = 0b1111_1111_1111_1111_1111_1111_1111_1110;
        System.out.println("Before unsigned right shift : " + Integer.toBinaryString(number));
        System.out.println("number in decimal format : " + number);
        number = number >>> 1;
        System.out.println("After unsigned right shift : " + Integer.toBinaryString(number));
        System.out.println("number in decimal format : " + number);
    }

    public static void signedShift() {
        // Using right shift operator with negative number in Java
        int number = -2;
        System.out.println(number); System.out.println("Before shift : " + Integer.toBinaryString(number));
        number = number >>> 1; //shifting 1 right bit
        System.out.println(number);
        System.out.println("After shift : " + Integer.toBinaryString(number));
    }
}
