package com.preparation.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Queue351 {

    public static void printQ(Queue queue) {

        while (queue.peek() != null) {

            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Random random = new Random();
        Queue<Integer> queue1 = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            queue1.offer(random.nextInt(i + 10));
        }
        printQ(queue1);
        char[] chars = "Brontosaurus".toCharArray();
        Queue <Character> queue2 = new LinkedList<Character>();
        for (int i = 0; i < chars.length; i++) {
            queue2.offer(chars[i]);
        }
        printQ(queue2);
    }

}
