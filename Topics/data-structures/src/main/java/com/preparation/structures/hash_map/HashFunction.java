package com.preparation.structures.hash_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HashFunction {

    private String[] theArray;
    private int arraySize;
    private int itemsInTheArray;

    public static void main(String[] args) {

        HashFunction theFunc = new HashFunction(30);

        String[] elementsToAdd = { "100", "510", "170", "214", "268", "398",
                "235", "802", "900", "723", "699", "1", "16", "999", "890",
                "725", "998", "29", "988", "990", "29", "984", "320", "321",
                "400", "415", "450", "50", "660", "624"};

        String[] elementsToAdd3 = { "30", "60", "90", "120", "150", "180",
                "210", "240", "270", "300", "330", "360", "390", "420", "450",
                "480", "510", "540", "570", "600", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };

        theFunc.hashFunction(elementsToAdd3, theFunc.theArray);
        theFunc.increaseArraySize(60);
        theFunc.displayTheStack();
    }

    public boolean isPrime(int number) {

        if(number % 2 == 0) return false;

        for (int i = 3; i * i <= number; i += 2) {
            if(number % i == 0) return false;
        }
        return true;
    }

    public int nextPrime(int currentPrime) {

        for (int i = currentPrime; ; i++) {
            if(isPrime(i)) return i;
        }
    }

    public void increaseArraySize(int minArraySize) {

        int newArraySize = nextPrime(minArraySize);
        moveOldArray(newArraySize);
    }

    private void moveOldArray(int newArraySize) {

        String[] cleanArray = removeEmptySpaces(theArray);
        theArray = new String[newArraySize];
        arraySize = newArraySize;
        fillArrayWithNeg1();
        hashFunction(cleanArray, theArray);
    }

    private String[] removeEmptySpaces(String[] theArray) {

        List<String> cleanList = new ArrayList<>();

        for (String str: theArray) {
            if(!str.equals("-1") && !str.equals("")) {
                cleanList.add(str);
            }
        }

        return cleanList.toArray(new String[cleanList.size()]);
    }

    private void fillArrayWithNeg1() {
        Arrays.fill(theArray, "-1");
    }

    public String find(String key) {

        int index = Integer.parseInt(key) % arraySize;

        while (theArray[index] != "-1") {

            if(Objects.equals(theArray[index], key)) {
                System.out.println(key + " was found in index " + index);
                return theArray[index];
            }
            index++;
            index %= arraySize;
        }

        return null;
    }

    /*
    Double hashing is a technique used in hash tables to resolve hash collisions, in cases when two
    different values to be searched for produce the same hash key.
    It uses one hash value as a starting point and then repeatedly steps forward an interval until
    the desired value is located, an empty location is reached, or the entire table has been searched;
    but this interval is decided using a second, independent hash function (hence the name double hashing).
    This interval depends on the data, so that even values mapping to the same location have different
    bucket sequences; this minimizes repeated collisions and the effects of clustering.
     */
    private void hashFunction(String[] elementsToAdd, String[] theArray) {

        for (int i = 0; i < elementsToAdd.length; i++) {
            String newElementVal = elementsToAdd[i];
            //1st hashing
            int index = Integer.parseInt(newElementVal) % arraySize;

            System.out.println("Modulus Index = " + index + " for value " + newElementVal);
            //the interval depends on the data, so that even values mapping to the same location
            // have different bucket sequences; this minimizes repeated collisions and the effects
            // of clustering.
            //2nd hashing
            int step = 7 - (Integer.parseInt(newElementVal)) % 7;

            while (!Objects.equals(theArray[index], "-1")) {
                index += step;
                System.out.println("Collision Try " + index + " Instead");
                index %= arraySize;
            }
            theArray[index] = newElementVal;
        }
    }

    public void displayTheStack() {

        int increment = 0;

        int numberOfRows = (arraySize / 10) + 1;

        for (int m = 0; m < numberOfRows; m++) {

            increment += 10;

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {

                System.out.format("| %3s " + " ", n);

            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {

                if (n >= arraySize)
                    System.out.print("|      ");

                else if (theArray[n].equals("-1"))
                    System.out.print("|      ");

                else
                    System.out
                            .print(String.format("| %3s " + " ", theArray[n]));

            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

        }
    }

    public HashFunction(int arraySize) {
        theArray = new String[arraySize];
        this.arraySize = arraySize;
        Arrays.fill(theArray, "-1");
    }
}
