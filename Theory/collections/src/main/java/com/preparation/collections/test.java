package com.preparation.collections;

public class test {

    public static void main(String[] args) {
        stringX("xabxxxcdx");
    }

    public static String stringX(String str) {
        String result = "";
        for (int i=0; i<str.length(); i++) {
            // Only append the char if it is not the "x" case
            System.out.println("i: " + i + ", expression: " + (i > 0 && i < (str.length()-1)));
            System.out.println(str.substring(i, i + 1));
            System.out.println("Substring equals x: " +
                    str.substring(i, i + 1).equals("x"));
            if (!(i > 0 && i < (str.length()-1) && str.substring(i, i+1).equals("x"))) {
                result = result + str.substring(i, i+1); // Could use str.charAt(i) here
            }
        }
        return result;
    }
}
