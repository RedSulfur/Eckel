package com.preparation.recursion;


public class codingBatRecursion {


    /*
        Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1.
        Compute the result recursively (without loops).

        factorial(1) → 1
        factorial(2) → 2
        factorial(3) → 6
    */

    public static int factorial(int number) {

        /*
        Every recursive method must have a condition that leads
        to the method no longer making another method call on itself.
        This condition is known as a base case
        */

        if (number == 1) {

            return 1;

        } else {

            int result = number * factorial(number - 1);
            return result;
        }
    }

    /*
    We have a number of bunnies and each bunny has two big floppy ears.
    We want to compute the total number of ears across all the bunnies recursively
    (without loops or multiplication).

    bunnyEars(0) → 0
    bunnyEars(1) → 2
    bunnyEars(2) → 4
    bunnyEars(12) → 24
    */

    public static int bunnyEars(int bunnies) {
        if (bunnies == 0) {
            return 0;
        } else {
            int result = 2 + bunnyEars(bunnies - 1);
            return result;
        }
    }

    /*
    The fibonacci sequence is a famous bit of mathematics, and it happens
    to have a recursive definition. The first two values in the sequence
    are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum
    of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5,
    8, 13, 21 and so on. Define a recursive fibonacci(n) method that returns
    the nth fibonacci number, with n=0 representing the start of the sequence.

    fibonacci(0) → 0
    fibonacci(1) → 1
    fibonacci(2) → 1
    fibonacci(5) → 5
    */

    public static int fibonacci(int n) {

        System.out.println("Method : "  + n);
        if (n == 0) return 0;
        else if (n == 1) {
            System.out.println("Returned 1");
            return 1;
        }
        else {
            int result = fibonacci(n - 1) + fibonacci(n - 2);
            System.out.print("Result : " + result);
            System.out.println(" : " + "fibonacci(" + n + " - 1)" + " + " + "fibonacci(" + n + " - 2)");
            return result;
        }
    }

    /*
    We have bunnies standing in a line, numbered 1, 2, ...
    The odd bunnies (1, 3, ..) have the normal 2 ears.
    The even bunnies (2, 4, ..) we'll say have 3 ears,
    because they each have a raised foot. Recursively return
    the number of "ears" in the bunny line 1, 2, ... .

    bunnyEars2(0) → 0
    bunnyEars2(1) → 2
    bunnyEars2(2) → 5
    */

    public static int bunnyEars2(int bunnies) {

        System.out.println("Method " + bunnies);
        if (bunnies == 0) {
            System.out.println("Returned 0");
            return 0;
        } else if (bunnies%2 == 1){
            int result = 2 + bunnyEars2(bunnies - 1);
            System.out.print("Result : " + result);
            System.out.println(" : " + "2 + " + "bunnyEars2(" + bunnies + " - 1)");
            return result;
        } else {
            int result = 3 + bunnyEars2(bunnies - 1);
            System.out.print("Result : " + result);
            System.out.println(" : " + "3 + " + "bunnyEars2(" + bunnies + " - 1)");
            return result;
        }
    }

    /*
    We have triangle made of blocks. The topmost row has 1 block,
    the next row down has 2 blocks, the next row has 3 blocks, and so on.
    Compute recursively (no loops or multiplication) the total number
    of blocks in such a triangle with the given number of rows.

    triangle(0) → 0
    triangle(1) → 1
    triangle(2) → 3
    triangle(3) → 6
    triangle(4) → 10
    triangle(5) → 15
    triangle(6) → 21
    */

    public static int triangle(int number) {

        if(number == 0) return 0;
        else if(number == 1) return 1;
        else {
            int result = number + triangle(number - 1);
            return result;
        }

    }

    /*
    Given a non-negative int n, return the sum of its digits recursively
    (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
    while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

    sumDigits(126) → 9
    sumDigits(49) → 13
    sumDigits(12) → 3
    */
    public static int sumDigits(int n) {

        if (n == 0) {
            return 0;
        } else {
            int result = n%10 + sumDigits(n/10);
            return result;
        }
    }

    public static void main(String[] args) {

//        System.out.println(factorial(3));
//        fibonacci(4);
//        System.out.println(bunnyEars2(5));
//        System.out.println(triangle(0));
        System.out.println(sumDigits(49));
    }

}
