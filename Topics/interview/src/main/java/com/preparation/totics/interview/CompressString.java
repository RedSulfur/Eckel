package com.preparation.totics.interview;

/**
 * abba -> a1b2a1
 */

public class CompressString {

    public static String compress(String str) {

        char[] chars = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i]; //a
            sb.append(temp);//a
                while ((i + 1 < chars.length) && temp == chars[i + 1]) {
                    i++;
                    cnt++;
                }
            sb.append(cnt);
            cnt = 1;
        }
        return sb.toString();
    }

    public static String intToStr(int numb) {

        String result = "" + numb;

        return result;
    }

    public static void main(String[] args) {

        String abba = compress("aaaaaaaaaa");
        System.out.println(intToStr(-125));

        System.out.println("Is intToStr(125) is an instance of String? " + (intToStr(125) instanceof String));

        System.out.println(abba);

    }
}
