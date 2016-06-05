package com.preparation.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by sulfur on 05.04.16.
 */

class RandomDoubles {
    private static Random rand = new Random();
    public double next() {
    return rand.nextDouble();
    }

    public static void main(String[] args) {
        RandomDoubles rd = new RandomDoubles();
        for (int i = 0; i < 7; i++) {
            System.out.print(rd.next() + " ");
        }
    }
}



class RandomDoublesWithImplementation extends RandomDoubles
implements Readable{
    int count;

    public RandomDoublesWithImplementation(int count) {
        this.count = count;
    }

    public int read(CharBuffer cb) throws IOException {
        if(count-- == 0) {
            return -1;
        }
        String result = Double.toString(next()) + " ";
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        return result.length();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomDoublesWithImplementation(7));
        while (s.hasNextDouble()) {
            System.out.println(s.nextDouble() + " ");
        }
    }
}

public class AdaptedRandomDoubles {
    /*
    public String next()
    Finds and returns the next complete token from this scanner.
    */

}
