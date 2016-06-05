package com.preparation.recursion;

public class recursion {

    public int getTriangularNumR (int number) {

        System.out.println("Method " + number);

        if(number == 1) {

            System.out.println("Returned 1");
            return 1;
        } else {
            int result = number + getTriangularNumR(number - 1);
            System.out.print("Result: " + result);
            System.out.print(" : " + number + " + getTriangularNumR(" + number + " - 1)\n");
            return result;
        }
    }

    public int getFactorial(int number) {

        System.out.println("Method " + number);
        if (number == 1) {
            System.out.println("Returned 1");
            return 1;
        } else {
            int result = number * getFactorial(number - 1);
            System.out.print("Result : " + result);
            System.out.println(" : " + number + " * getFactorial(" + number + " - 1)");
            return result;
        }

    }



    public static void main(String[] args) {

        recursion recursion = new recursion();
//        recursion.getTriangularNumR(6);
        recursion.getFactorial(6);

    }


}
