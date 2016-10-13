package com.preparation.recursion;


public class CodingBatRecursion {

    /*
    Given a non-negative int n, compute recursively (no loops) the count of the
    occurrences of 8 as a digit, except that an 8 with another 8 immediately to
    its left counts double, so 8818 yields 4. Note that mod (%) by 10 yields the
    rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost
    digit (126 / 10 is 12).

    count8(8) → 1
    count8(818) → 2
    count8(8818) → 4
     */
    public int count8(int n) {
        if(n == 0) return 0;
        if(n % 10 == 8 && (n / 10) % 10 == 8) return 2 + count8(n / 10);
        if(n % 10 == 8) return 1 + count8(n / 10);
        return count8(n / 10);
    }

    /*
    Given base and n that are both 1 or more, compute recursively (no loops) the
    value of base to the n power, so powerN(3, 2) is 9 (3 squared).

    powerN(3, 1) → 3
    powerN(3, 2) → 9
    powerN(3, 3) → 27
     */
    public int powerN(int base, int n) {
        if(n < 1) return 1;
        return base * powerN(base, n - 1);
    }

    /*
    Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.

    countX("xxhixx") → 4
    countX("xhixhix") → 3
    countX("hi") → 0
     */
    public int countX(String word) {
        if(word.length() < 2) {
            if(word.equals("x")) return 1;
            else return 0;
        }
        if((word.substring(word.length() - 1, word.length())).equals("x"))
            return 1 + countX(word.substring(0, word.length() - 1));
        return countX(word.substring(0, word.length() - 1));
    }

    /*
    Given a string, compute recursively (no loops) the number of times lowercase "hi"
    appears in the string.

    countHi("xxhixx") → 1
    countHi("xhixhix") → 2
    countHi("hi") → 1
     */
    public int countHi(String str) {
        if(str.length() < 2) return 0;
        if(str.substring(str.length() - 2, str.length()).equals("hi"))
            return 1 + countHi(str.substring(0, str.length() - 1));
        else return countHi(str.substring(0, str.length() - 1));
    }

    /*
    Given a string, compute recursively (no loops) a new string where all the lowercase 'x'
    chars have been changed to 'y' chars.

    changeXY("codex") → "codey"
    changeXY("xxhixx") → "yyhiyy"
    changeXY("xhixhix") → "yhiyhiy"
     */
    public String changeXY(String str) {
        if(str.length() < 1) return "";
        if(str.substring(0, 1).equals("x"))
            return "y" + changeXY(str.substring(1));
        else return str.substring(0, 1)
                + changeXY(str.substring(1));
    }
}
